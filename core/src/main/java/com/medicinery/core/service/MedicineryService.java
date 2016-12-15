package com.medicinery.core.service;

import com.medicinery.core.data.entity.MedicineInfoCore;
import com.medicinery.core.data.entity.MedicineSummary;

import java.util.List;
import java.util.Map;

public interface MedicineryService {

    MedicineInfoCore findMedicineWithDetails(String title);

    List<String> similarItems(Long medicineId, Long innId);

    Map<String, String> mostPopular();

    MedicineSummary findMedicineSummary(String title);

    List<MedicineInfoCore> findMedicinesByFirstLetter(String firstLetter);

    List<String> findMedicineTitlesByTitlePart(String start);

}
