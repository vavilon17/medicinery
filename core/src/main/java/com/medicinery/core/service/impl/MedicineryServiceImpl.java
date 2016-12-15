package com.medicinery.core.service.impl;

import com.medicinery.core.dao.MedicineInfoCoreDao;
import com.medicinery.core.dao.MedicineSummaryDao;
import com.medicinery.core.data.entity.MedicineInfoCore;
import com.medicinery.core.data.entity.MedicineSummary;
import com.medicinery.core.service.MedicineryService;
import com.medicinery.core.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Transactional(readOnly = true)
public class MedicineryServiceImpl implements MedicineryService {

    private final static int TOP = 10;

    @Autowired
    private MedicineInfoCoreDao medicineInfoCoreDao;

    @Autowired
    private MedicineSummaryDao medicineSummaryDao;

    public MedicineInfoCore findMedicineWithDetails(String title) {
        return medicineInfoCoreDao.findByTitleEager(title);
    }

    @Cacheable("popular")
    public Map<String, String> mostPopular() {
        Map<String, String> res = new HashMap<>(TOP);
        for (MedicineSummary ms : medicineSummaryDao.findPopular(TOP)) {
            res.put(ms.getMedicineTitle(), ms.getManufacturerName());
        }
        return res;
    }

    public List<String> similarItems(Long medicineId, Long innId) {
        if (innId == null) {
            return Collections.emptyList();
        } else {
            return medicineSummaryDao.findSimilar(medicineId, innId);
        }
    }

    @Override
    public MedicineSummary findMedicineSummary(String title) {
        return medicineSummaryDao.findByTitle(title);
    }

    @Override
    public List<MedicineInfoCore> findMedicinesByFirstLetter(String firstLetter) {
        return medicineInfoCoreDao.findByFirstTitlePart(firstLetter.toUpperCase());
    }

    @Override
    public List<String> findMedicineTitlesByTitlePart(String start) {
        String capStart = Utils.capitalizeFirstLetter(start);
        return medicineInfoCoreDao.findTitlesByFirstTitlePart(capStart);
    }
}
