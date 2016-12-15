package com.medicinery.core.dao.impl;

import com.medicinery.core.dao.AbstractDao;
import com.medicinery.core.dao.MedicineInfoCoreDao;
import com.medicinery.core.data.entity.MedicineInfoCore;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("medicineInfoCoreDao")
public class MedicineInfoCoreDaoImpl extends AbstractDao<MedicineInfoCore> implements MedicineInfoCoreDao {

    public MedicineInfoCore findByTitle(String title) {
        return (MedicineInfoCore) currentSession().getNamedQuery("findByTitle")
                .setString("title", title).uniqueResult();
    }

    public MedicineInfoCore findByTitleEager(String title) {
        Criteria criteria = currentSession().createCriteria(MedicineInfoCore.class)
                .add(Restrictions.eq("title", title))
                .setFetchMode("details", FetchMode.JOIN);
        return (MedicineInfoCore) criteria.uniqueResult();
    }

    @Override
    public List<MedicineInfoCore> findByFirstTitlePart(String part) {
        return currentSession().getNamedQuery("medicineInfoCoreByTitlePart")
                .setString("part", part + "%").list();
    }

    @Override
    public List<String> findTitlesByFirstTitlePart(String part) {
        Query q = currentSession().getNamedQuery("medicineInfoCoreTitlesByTitlePart")
                .setString("part", part + "%");
        return (List<String>) q.list();
    }
}
