package com.medicinery.priceimport.dao.impl;

import com.medicinery.priceimport.dao.DrugstoreDao;
import com.medicinery.priceimport.data.Drugstore;
import com.medicinery.priceimport.data.mapper.DrugstoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("drugstoreDao")
public class DrugstoreDaoImpl implements DrugstoreDao {

    private static final String ALL_ACTIVE = "select id, print_name from drugstore where status = 'ACTIVE'";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private DrugstoreMapper drugstoreMapper;

    @Override
    public List<Drugstore> findAllActive() {
        return namedParameterJdbcTemplate.query(ALL_ACTIVE, drugstoreMapper);
    }
}
