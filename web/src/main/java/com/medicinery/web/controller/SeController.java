package com.medicinery.web.controller;

import com.medicinery.core.service.ResourcesService;
import com.medicinery.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping(value = "/")
public class SeController {

    private static final Logger log = LoggerFactory.getLogger(SeController.class);

    @Autowired
    private ResourcesService resourcesService;

    @Autowired
    private Environment env;

    @RequestMapping("/robots.txt")
    public HttpEntity<byte[]> robots() {
        log.info("requested robots.txt");
        return provideHttpEntity("robots.txt");
    }

    @RequestMapping(value = "/sitemap.xml")
    public String mainSitemap(ModelMap model) {
        log.info("requested sitemap.xml");
        model.put("baseDomain", env.getProperty("base.domain"));
        return "templates/analysis/main_sitemap";
    }

    @RequestMapping("/sitemap-medicines.xml")
    public HttpEntity<byte[]> sitemapMedicines() {
        log.info("requested sitemap-medicines.xml");
        return provideHttpEntity("sitemap-medicines.xml");
    }

    @RequestMapping("/sitemap-catalogue.xml")
    public HttpEntity<byte[]> sitemapCatalogue() {
        log.info("requested sitemap-catalogue.xml");
        return provideHttpEntity("sitemap-catalogue.xml");
    }

    @RequestMapping("/sitemap-prices.xml")
    public HttpEntity<byte[]> sitemapPrices() {
        log.info("requested sitemap-prices.xml");
        return provideHttpEntity("sitemap-prices.xml");
    }

    private HttpEntity<byte[]> provideHttpEntity(String seFileName) {
        try {
            byte[] data = resourcesService.getFileForSe(seFileName);
            String ext = seFileName.split("\\.")[1];
            return WebUtils.prepareBinaryEntity(data, ext, "public, must-revalidate");
        } catch (IOException ioEx) {
            log.error("Error while providing file '" + seFileName + "': ", ioEx);
            return new HttpEntity<>(new byte[0]);
        }
    }
}
