package com.medicinery.priceimport.service.impl;

import com.medicinery.priceimport.dao.AbsentDrugDao;
import com.medicinery.priceimport.dao.DrugstoreDao;
import com.medicinery.priceimport.data.AbsentDrug;
import com.medicinery.priceimport.data.Drugstore;
import com.medicinery.priceimport.service.PriceImportService;
import com.medicinery.priceimport.service.processor.PriceImportProcessor;
import com.medicinery.priceimport.service.processor.impl.WerRuPriceImportProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class PriceImportServiceImpl implements PriceImportService {

    private static final Logger log = LoggerFactory.getLogger(PriceImportServiceImpl.class);

    private Set<String> absents = new HashSet<>();

    @Autowired
    private DrugstoreDao drugstoreDao;

    @Autowired
    private AbsentDrugDao absentDrugDao;

    @Override
    public void runImport() {
        log.debug("Start of import process");
        /*try {
            for (Drugstore d : drugstoreDao.findAllActive()) {
                log.debug("Import from {}", d.getPrintName());

            }
        } finally {
            absents.clear();
        }*/
        testImport();
        log.debug("Finish of import process");
    }

    // in test purposes - todo remove later
    private void testImport() {
        PriceImportProcessor werRuProcessor = new WerRuPriceImportProcessor(null, null);
        werRuProcessor.processPrices();

    }

    private void fillAbsents() {
        absents.clear();
        for (AbsentDrug a : absentDrugDao.findAll()) {
            absents.add(a.getName());
        }
    }



    // GROOVY CODE

    /*def processImport() {
        log.debug("START OF IMPORT PROCESS...")
        fillAbsents()
        try {
            for (Drugstore drugstore : Drugstore.findAllByStatus(DrugProviderStatus.ACTIVE)) {
                log.debug("Import from ${drugstore.printName}")
                long start = System.currentTimeMillis();
                try {
                    String url = drugstore.exportUrl
                    String encoding = (ExportType.PANIAPTEKA_PRC_32465434_LST.equals(drugstore.exportType)
                            || drugstore.exportType.equals(ExportType.APTEKA_PARYS)
                            || drugstore.exportType.equals(ExportType.E_APTEKA_RU_YML)) ? "windows-1251" : "UTF-8"
                    String xmlContent = url.toURL().getText(encoding)
                    XmlSlurper parser = new XmlSlurper()
                    parser.setFeature("http://apache.org/xml/features/disallow-doctype-decl", false)
                    parser.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
                    parser.setFeature("http://xml.org/sax/features/namespaces", false)
                    def root = parser.parseText(xmlContent)
                    def itemsList = []
                    if (ExportType.WER_RU_PILLSGURU.equals(drugstore.exportType)) {
                        itemsList = root.drug
                    } else if (ExportType.PILULI_RU_ADMITAD.equals(drugstore.exportType)) {
                        itemsList = root.shop.offers.offer
                    } else if (ExportType.APTEKA_PARYS.equals(drugstore.exportType)) {
                        itemsList = root.shop.offers.offer
                    } else if (ExportType.PANIAPTEKA_PRC_32465434_LST.equals(drugstore.exportType)) {
                        itemsList = root.items.item
                    } else if (ExportType.E_APTEKA_RU_YML.equals(drugstore.exportType)) {
                        itemsList = root.shop.offers.offer
                    }
                    int count = 0
                    itemsList.each { it ->
                        try {
                            //if (count <= 10) {
                            processItemImport(drugstore, it)
                            //}
                            count++
                            if (count % 1000 == 0) {
                                log.info("IMPORTED SO FAR = ${count}. EXPLICIT SESSION FLUSH")
                                Manufacturer.first().save(flush: true)
                            }
                        } catch (Exception e) {
                            log.error("Problems with importing of ${it} from ${drugstore.printName}", e)
                        }
                    }
                    clearDeprecatedPrices(drugstore)
                } catch (Exception e) {
                    log.error("Error while trying to import", e)
                    continue
                } finally {
                    priceIdsProcessed.clear()
                }
                log.debug("Import from ${drugstore.printName} finished. Spent ${(System.currentTimeMillis() - start) / 1000}sec")
            }
        } finally {
            absents.clear()
        }
        log.debug("FINISH OF IMPORT PROCESS")
    }

    @Transactional
    def processItemImport(Drugstore drugStore, def importItem) {
        DrugInfo drugInfo = provideDrugInfo(drugStore, importItem)
        if (!drugInfo?.name) {
            log.warn("Cannot find name in drug with url ${drugInfo.url}")
        } else {
            log.info("sync of " + drugInfo.name)
            if (absents.contains(drugInfo.name.toLowerCase())) {
                log.warn("${drugInfo.name} absent in medicinery.info DB so it is skipped from synchronizing")
            } else {
                ProviderMappingCache mapping = provideMappingRecord(drugInfo.name)
                if (mapping) {
                    boolean isRu = Segment.RU.equals(drugStore.segment)
                    Price price = Price.findByMedicineAndDrugNameAndDrugstoreAndForm(mapping.medicine, drugInfo.name, drugStore, drugInfo.form)
                    if (!price) {
                        price = isRu ? new Price_ru() : new Price_ua()
                        price.medicine = mapping.medicine
                        price.drugName = drugInfo.name
                        price.drugstore = drugStore
                        price.vendor = drugInfo.vendor
                        price.price = canonPrice(drugInfo.price)
                        price.form = drugInfo.form
                        price.url = drugInfo.url
                        price.save()
                    } else {
                        if (price.price != drugInfo.price) {
                            price.price = canonPrice(drugInfo.price)
                            price.save()
                        }
                    }
                    priceIdsProcessed.add(price.id)
                }
            }
        }
    }

    private DrugInfo provideDrugInfo(Drugstore drugStore, def importItem) {
        DrugInfo drugInfo = new DrugInfo()
        if (ExportType.WER_RU_PILLSGURU.equals(drugStore.exportType)
                || ExportType.APTEKA_PARYS.equals(drugStore.exportType)
                || ExportType.PANIAPTEKA_PRC_32465434_LST.equals(drugStore.exportType)
                || ExportType.E_APTEKA_RU_YML.equals(drugStore.exportType)) {
            drugInfo.name = importItem.name
            if (importItem?.vendor) {
                drugInfo.vendor = importItem.vendor
            }
            drugInfo.price = importItem.price
            if (importItem?.form) {
                drugInfo.form = importItem.form
            }
            drugInfo.url = importItem.url
        } else if (ExportType.PILULI_RU_ADMITAD.equals(drugStore.exportType)) {
            tmpHashMap.clear()
            importItem.param.each { paramItem ->
                    tmpHashMap.put(paramItem.@name.toString(), paramItem.toString())
            }
            if (tmpHashMap.containsKey("Название")) {
                drugInfo.name = tmpHashMap.get("Название")?.trim()
            } else if (tmpHashMap.containsKey("Название и дозировка")) {
                drugInfo.name = importItem.get("Название и дозировка")?.trim()
            } else {
                drugInfo.name = importItem.model?.toString().trim()
            }
            if (tmpHashMap.containsKey("Краткая дозировка")) {
                drugInfo.form = tmpHashMap.get("Краткая дозировка")
            } else if (tmpHashMap.containsKey("Полная дозировка")) {
                drugInfo.form = tmpHashMap.get("Полная дозировка")
            }
            drugInfo.vendor = importItem.vendor
            drugInfo.price = importItem.price
            drugInfo.url = importItem.url
        } else {
            throw new IllegalStateException("Not supported provider")
        }
        return drugInfo
    }

    @Transactional
    private ProviderMappingCache provideMappingRecord(String drugName) {
        ProviderMappingCache mapping = ProviderMappingCache.findByDrugName(drugName)
        if (!mapping) {
            boolean found = false
            for (String medName : itemsService.itemsMap.keySet()) {
                if (drugName.equalsIgnoreCase(medName) || drugName.indexOf(medName + " ") > -1) {
                    found = true
                    MedicineInfoCore medicineInfoCore = MedicineInfoCore.findById(itemsService.itemsMap.get(medName))
                    if (medicineInfoCore) {
                        mapping = new ProviderMappingCache(medicine: medicineInfoCore, drugName: drugName)
                        mapping.save()
                    }
                    break
                }
            }
            if (!found) {
                log.warn("${drugName} not found in DB so it is added to AbsentDrug")
                AbsentDrug absentDrug = new AbsentDrug(name: drugName)
                absents.add(drugName.toLowerCase())
                absentDrug.save(failOnError: false)
            }
        }
        mapping
    }

    private fillAbsents() {
        absents.clear()
        AbsentDrug.list().each {
            absents.add(it.name.toLowerCase())
        }
    }

    private void clearDeprecatedPrices(drugstore) {
        if (priceIdsProcessed) {
            Price.findAllByDrugstoreAndIdNotInList(drugstore, priceIdsProcessed.toList()).each {
                log.info("${it.drugName} ${it.form} is going to be deleted")
                it.delete()
            }
            Manufacturer.first().save(flush: true) // flush session
        }
    }

    private static String canonPrice(String price) {
        try {
            decimalFormat.format(Double.valueOf(price))
        } catch (Exception e) {
            println "Error while canonizating price: ${e.message}. Will be used input value: ${price}"
            return price
        }
    }*/
}
