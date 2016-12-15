package com.medicinery.core.dao.impl;

import com.medicinery.core.dao.AbstractDao;
import com.medicinery.core.dao.MedicineSummaryDao;
import com.medicinery.core.data.entity.MedicineSummary;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("medicineSummaryDao")
public class MedicineSummaryDaoImpl extends AbstractDao<MedicineSummary> implements MedicineSummaryDao {

    @Override
    public MedicineSummary findByTitle(String title) {
        return (MedicineSummary) currentSession().getNamedQuery("medicineSummaryByTitle")
                .setString("title", title).uniqueResult();
    }

    public List<String> findSimilar(Long medicineId, Long innId) {
        Query q = currentSession().getNamedQuery("similar")
                .setLong("medicineId", medicineId)
                .setLong("innId", innId);
        return (List<String>) q.list();
    }

    public List<MedicineSummary> findPopular(int top) {
        return currentSession().getNamedQuery("popular").setMaxResults(top).list();
    }

    public void refresh() {
        currentSession().createSQLQuery("REFRESH MATERIALIZED VIEW mv_medicine_summary").executeUpdate();
    }
}
