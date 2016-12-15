package com.medicinery.core.service.impl;

import com.medicinery.core.dao.PricesDao;
import com.medicinery.core.data.dto.PricesRange;
import com.medicinery.core.data.entity.MedicineInfoCore;
import com.medicinery.core.data.entity.Price;
import com.medicinery.core.service.PricesService;
import com.medicinery.core.util.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

@Component
@Transactional(readOnly = true)
public class PricesServiceImpl implements PricesService {

    private static final Logger log = LoggerFactory.getLogger(PricesServiceImpl.class);

    @Autowired
    private PricesDao pricesDao;

    public PricesRange findPriceRange(MedicineInfoCore medicine, String segment) {
        if (StringUtils.isEmpty(segment)) {
            log.warn("Empty segment comes as an argument!");
            return new PricesRange(false);
        } else {
            return pricesDao.findLowestAndHigestPrices(medicine, segment);
        }
    }

    @Override
    public List<Price> providePriceList(MedicineInfoCore medicine, String segment) {
        if (!Const.SEGM_RU.equalsIgnoreCase(segment) && !Const.SEGM_UA.equalsIgnoreCase(segment)) {
            log.error("Segment '%s'is out of predicable range", segment);
            return Collections.emptyList();
        }
        return pricesDao.pricesByMedicine(medicine, segment);
    }

}
