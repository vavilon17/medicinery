package com.medicinery.priceimport.data.mapper;

import com.medicinery.priceimport.data.Drugstore;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DrugstoreMapper implements RowMapper<Drugstore> {

    @Override
    public Drugstore mapRow(ResultSet rs, int i) throws SQLException {
        Drugstore drugstore = new Drugstore();
        drugstore.setId(rs.getLong("id"));
        drugstore.setPrintName(rs.getString("print_name"));
        drugstore.setExportType(rs.getString("export_type"));
        drugstore.setExportUrl(rs.getString("export_url"));
        return drugstore;
    }
}
