package com.medicinery.core.data.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
        @NamedQuery(
                name = "lowestHighestPricesUa",
                query = "select cast(min(cast(price as float)) as string), cast(max(cast(price as float)) as string) " +
                        "from PriceUa where medicine = :medicine"
        ),
        @NamedQuery(
                name = "pricesUaByMedicine",
                query = "from PriceUa where medicine = :medicine"
        )
})
@Entity
@Table(name = "price_ua")
public class PriceUa extends Price {
}
