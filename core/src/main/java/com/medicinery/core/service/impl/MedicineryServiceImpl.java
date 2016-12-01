package com.medicinery.core.service.impl;

import com.medicinery.core.dao.impl.MedicineInfoCoreDao;
import com.medicinery.core.entity.MedicineInfoCore;
import com.medicinery.core.service.MedicineryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class MedicineryServiceImpl implements MedicineryService {

    @Autowired
    private MedicineInfoCoreDao medicineInfoCoreDao;

    public MedicineInfoCore findById(Long id) {
        return medicineInfoCoreDao.findById(id);
    }
}
