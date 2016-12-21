package com.medicinery.priceimport.data.mapper;

import com.medicinery.priceimport.data.AbsentDrug;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AbsentDrugMapper implements RowMapper<AbsentDrug> {

    @Override
    public AbsentDrug mapRow(ResultSet rs, int i) throws SQLException {
        AbsentDrug item = new AbsentDrug();
        item.setId(rs.getLong("id"));
        item.setName(rs.getString("name"));
        return item;
    }
}
