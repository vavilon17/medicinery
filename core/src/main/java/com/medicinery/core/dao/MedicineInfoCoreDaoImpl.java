package com.medicinery.core.dao;

import com.medicinery.core.dao.impl.MedicineInfoCoreDao;
import com.medicinery.core.entity.MedicineInfoCore;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("medicineInfoCoreDao")
public class MedicineInfoCoreDaoImpl implements MedicineInfoCoreDao {

    @Autowired
    private SessionFactory sessionFactory;

    public MedicineInfoCore findById(Long id) {
        return (MedicineInfoCore) sessionFactory.getCurrentSession().get(MedicineInfoCore.class, id);
    }
}
