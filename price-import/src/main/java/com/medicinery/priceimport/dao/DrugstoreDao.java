package com.medicinery.priceimport.dao;

import com.medicinery.priceimport.data.Drugstore;

import java.util.List;

public interface DrugstoreDao {

    List<Drugstore> findAllActive();
}
