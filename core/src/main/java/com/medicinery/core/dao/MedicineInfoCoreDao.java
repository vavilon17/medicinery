package com.medicinery.core.dao;

import com.medicinery.core.data.entity.MedicineInfoCore;

import java.util.List;

public interface MedicineInfoCoreDao extends BasicDao<MedicineInfoCore> {

    MedicineInfoCore findByTitle(String title);

    MedicineInfoCore findByTitleEager(String title);

    List<MedicineInfoCore> findByFirstTitlePart(String part);

    List<String> findTitlesByFirstTitlePart(String part);
}
