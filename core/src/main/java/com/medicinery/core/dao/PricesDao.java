package com.medicinery.core.dao;


import com.medicinery.core.data.dto.PricesRange;
import com.medicinery.core.data.entity.MedicineInfoCore;
import com.medicinery.core.data.entity.Price;

import java.util.List;

public interface PricesDao {

     PricesRange findLowestAndHigestPrices(MedicineInfoCore medicineInfoCore, String segment);

     List<Price> pricesByMedicine(MedicineInfoCore medicine, String segment);
}
