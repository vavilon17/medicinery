package com.medicinery.core.service;

import com.medicinery.core.data.dto.PricesRange;
import com.medicinery.core.data.entity.MedicineInfoCore;
import com.medicinery.core.data.entity.Price;

import java.util.List;

public interface PricesService {

    PricesRange findPriceRange(MedicineInfoCore medicine, String segment);

    List<Price> providePriceList(MedicineInfoCore medicine, String segment);

}
