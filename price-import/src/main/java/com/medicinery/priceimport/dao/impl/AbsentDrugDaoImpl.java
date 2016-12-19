package com.medicinery.priceimport.dao.impl;

import com.medicinery.priceimport.dao.AbsentDrugDao;
import com.medicinery.priceimport.data.AbsentDrug;
import com.medicinery.priceimport.data.mapper.AbsentDrugMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("absentDrugDao")
public class AbsentDrugDaoImpl implements AbsentDrugDao {

    private static final String SQL_ABSENTS_ALL = "select id, name from absent_drug";

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private AbsentDrugMapper absentDrugMapper;

    @Override
    public List<AbsentDrug> findAll() {
        return jdbcTemplate.query(SQL_ABSENTS_ALL, absentDrugMapper);
    }
}
