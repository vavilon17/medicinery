package com.medicinery.priceimport.service.processor;

import com.medicinery.priceimport.data.Drugstore;

public abstract class AbstractPriceImportProcessor<T> implements PriceImportProcessor {

   protected String fileName;
   protected Drugstore drugstore;

   protected AbstractPriceImportProcessor(String fileName, Drugstore drugstore) {
      this.fileName = fileName;
      this.drugstore = drugstore;
   }

   protected String fileContent() {
      return null;
   }


}
