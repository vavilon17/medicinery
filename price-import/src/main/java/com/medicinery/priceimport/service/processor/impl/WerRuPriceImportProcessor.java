package com.medicinery.priceimport.service.processor.impl;

import com.medicinery.priceimport.data.Drugstore;
import com.medicinery.priceimport.data.jaxb.werru.Drug;
import com.medicinery.priceimport.data.jaxb.werru.Drugs;
import com.medicinery.priceimport.service.processor.AbstractPriceImportProcessor;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class WerRuPriceImportProcessor extends AbstractPriceImportProcessor {

    public WerRuPriceImportProcessor(String fileName, Drugstore drugstore) {
        super(fileName, drugstore);
    }

    @Override
    public long processPrices() {
        long start = System.currentTimeMillis();
        try {
            File file = new File("/home/vyaskal/dev/temp/wer_ru.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Drugs.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Drugs res = (Drugs) jaxbUnmarshaller.unmarshal(file);
            for (Drug d : res.getDrugs()) {
                System.out.println("Name: " + d.getName() + ", form: " + d.getForm() + ", url: " + d.getUrl()
                        + ", vendor: " + d.getVendor() + ", price: " + d.getPrice());
            }
        } catch (JAXBException e) {
            System.out.println(e);
        }
        return System.currentTimeMillis() - start;
    }
}
