package com.medicinery.core.data.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
        @NamedQuery(
                name = "lowestHighestPricesRu",
                query = "select cast(min(cast(price as float)) as string), cast(max(cast(price as float)) as string) " +
                        "from PriceRu where medicine = :medicine"
        ),
        @NamedQuery(
                name = "pricesRuByMedicine",
                query = "from PriceRu where medicine = :medicine"
        )
})
@Entity
@Table(name = "price_ru")
public class PriceRu extends Price {
}
