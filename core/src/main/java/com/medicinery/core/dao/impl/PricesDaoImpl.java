package com.medicinery.core.dao.impl;

import com.medicinery.core.dao.AbstractDao;
import com.medicinery.core.dao.PricesDao;
import com.medicinery.core.data.dto.PricesRange;
import com.medicinery.core.data.entity.MedicineInfoCore;
import com.medicinery.core.data.entity.Price;
import com.medicinery.core.util.Const;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("pricesDao")
public class PricesDaoImpl extends AbstractDao<Price> implements PricesDao {

    public PricesRange findLowestAndHigestPrices(MedicineInfoCore medicine, String segment) {
        PricesRange prices = new PricesRange();
        Query q = currentSession().getNamedQuery(namedQueryForPriceRange(segment)).setEntity("medicine", medicine);
        List<Object[]> res = q.list();
        if (res.get(0)[0] != null) {
            prices.setFilled(true);
            prices.setLowPrice((String) res.get(0)[0]);
            prices.setHighPrice((String) res.get(0)[1]);
        }
        return prices;
    }

    @Override
    public List<Price> pricesByMedicine(MedicineInfoCore medicine, String segment) {
        return (List<Price>) currentSession().getNamedQuery(namedQueryForPricePerMedicine(segment))
                .setEntity("medicine", medicine).list();
    }

    private String namedQueryForPriceRange(String segment) {
        if (Const.SEGM_RU.equalsIgnoreCase(segment)) {
            return "lowestHighestPricesRu";
        } else if (Const.SEGM_UA.equalsIgnoreCase(segment)) {
            return "lowestHighestPricesUa";
        }
        return null;
    }

    private String namedQueryForPricePerMedicine(String segment) {
        if (Const.SEGM_RU.equalsIgnoreCase(segment)) {
            return "pricesRuByMedicine";
        } else if (Const.SEGM_UA.equalsIgnoreCase(segment)) {
            return "pricesUaByMedicine";
        }
        return null;
    }
}
