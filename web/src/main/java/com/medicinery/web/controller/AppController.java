package com.medicinery.web.controller;

import com.medicinery.core.data.dto.PricesRange;
import com.medicinery.core.data.entity.Drugstore;
import com.medicinery.core.data.entity.MedicineInfoCore;
import com.medicinery.core.data.entity.Price;
import com.medicinery.core.service.MedicineryService;
import com.medicinery.core.service.PricesService;
import com.medicinery.core.util.Const;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/")
public class AppController {

    private static final Logger log = LoggerFactory.getLogger(AppController.class);

    @Autowired
    private MedicineryService medicineryService;

    @Autowired
    private PricesService pricesService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/popular", method = RequestMethod.GET)
    public String popular(@RequestParam("toWidget") boolean toWidget, ModelMap model) {
        Map<String, String> items = medicineryService.mostPopular();
        model.put("toWidget", toWidget);
        model.put("items", items);
        return "templates/popular_items";
    }

    @RequestMapping(value = "/medicine/{title}", method = RequestMethod.GET)
    public String medicine(
            @PathVariable String title,
            ModelMap model , HttpServletRequest request, Device device) {
        log.info("Start preparing medicine page for '%s'", title);
        MedicineInfoCore item = medicineryService.findMedicineWithDetails(title);
        if (item != null) {
            String segment = getSegmentFromSession(request);
            PricesRange pricesRange = pricesService.findPriceRange(item, segment);
            Element body = Jsoup.parse(item.getDetails().getTradeNameManual()).select("body").get(0);
            String viewToRender;
            if (device.isMobile()) {
                model.put("similars", medicineryService.similarItems(item.getId(), item.getDetails().getInnId()));
                viewToRender = "medicine_mob";
            } else {
                Map<String, String> anchors = new LinkedHashMap<>();
                int index = 1;
                for (Element part : body.select("h4")) {
                    String id = "anc_" + index++;
                    anchors.put(id, part.text().replace(":", ""));
                    part.before("<a id=\"" + id + "\"></a>");
                }
                model.put("item_content", body.outerHtml());
                model.put("anchors", anchors);
                viewToRender = "medicine";
            }
            model.put("item", item);
            model.put("pricesRange", pricesRange);
            model.put("curr", provideCurrency(segment));
            model.put("fakeFileName", fakeFileName(item));
            return viewToRender;
        } else {
            log.error("Cannot find item with name %s. isMobile = %s", title, device.isMobile());
            return "errors/custom404";
        }
    }

    @RequestMapping(value = "/prices/{title}", method = RequestMethod.GET)
    public String prices(@PathVariable String title, ModelMap model, HttpServletRequest request) {
        MedicineInfoCore medicineInfoCore = medicineryService.findMedicineWithDetails(title);
        if (medicineInfoCore != null) {
            Map<Drugstore, List<Price>> pricesPerStore = new HashMap<>();
            SortedMap<Float, String> prices = new TreeMap<>();
            List<Price> pricesList;
            String segment = getSegmentFromSession(request);
            pricesList = pricesService.providePriceList(medicineInfoCore, segment);
            if (pricesList != null && pricesList.size() > 0) {
                for (Price priceItem : pricesList) {
                    if (!pricesPerStore.containsKey(priceItem.getDrugstore())) {
                        pricesPerStore.put(priceItem.getDrugstore(), new ArrayList<>());
                    }
                    pricesPerStore.get(priceItem.getDrugstore()).add(priceItem);
                    prices.put(Float.parseFloat(priceItem.getPrice()), priceItem.getPrice());
                }
            }
            model.put("item", medicineInfoCore);
            model.put("prices", pricesPerStore);
            model.put("pricesVals", prices);
            model.put("curr", provideCurrency(segment));
            model.put("fakeFileName", fakeFileName(medicineInfoCore));
            return "prices";
        } else {
            log.error("Cannot prepare prices foe item with title %s", title);
            return "errors/custom404";
        }
    }

    @RequestMapping(value = "/catalogue/{letter}", method = RequestMethod.GET)
    public String catalogue(@PathVariable String letter, ModelMap model) {
        model.put("letter", letter);
        model.put("items", medicineryService.findMedicinesByFirstLetter(letter));
        return "catalogue";
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String search(@RequestParam("input") String input, ModelMap model) {
        model.put("results", medicineryService.findMedicineTitlesByTitlePart(input));
        return "templates/lookup_results";
    }

    @RequestMapping(value = "/similar", method = RequestMethod.GET)
    public String similarMedicines(
            @RequestParam(value = "innId") String innId,
            @RequestParam(value = "medicineId") String medicineId,
            ModelMap model) {
        List<String> similarItems;
        if (StringUtils.isEmpty(innId)) {
            similarItems = Collections.emptyList();
        } else {
            similarItems = medicineryService.similarItems(Long.parseLong(medicineId), Long.parseLong(innId));
        }
        model.put("similarItems", similarItems);
        return "templates/widget/similar";
    }

    private String getSegmentFromSession(HttpServletRequest request) {
        return (String) request.getSession().getAttribute(Const.SEGM_SESSION_ATTR);
    }

    private String provideCurrency(String segment) {
        String currency = "";
        if (!StringUtils.isEmpty(segment)) {
            if (Const.SEGM_RU.equals(segment)) {
                currency = "руб";
            } else if (Const.SEGM_UA.equals(segment)) {
                currency = "грн";
            }
        }
        return currency;
    }

    private String fakeFileName(MedicineInfoCore item) {
        if (StringUtils.isEmpty(item.getDetails().getMainImgSrc())) {
            return null;
        } else {
            String ext = item.getDetails().getMainImgSrc().split("\\.")[1];
            return item.getTitle() + "." + ext;
        }
    }
}