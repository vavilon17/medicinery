package com.medicinery.core.dao;

import com.medicinery.core.data.entity.MedicineSummary;

import java.util.List;

public interface MedicineSummaryDao extends Refreshable {

    MedicineSummary findByTitle(String title);

    List<String> findSimilar(Long medicineId, Long innId);

    List<MedicineSummary> findPopular(int top);
}
