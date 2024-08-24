package com.makersharks.MakersharksApplication.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.makersharks.MakersharksApplication.model.Supplier;

@Repository
public class SupplierRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

    private final RowMapper<Supplier> supplierRowMapper = (rs, rowNum) -> {
        Supplier supplier = new Supplier();
        supplier.setSupplierId(UUID.fromString(rs.getString("supplierId")));
        supplier.setCompanyName(rs.getString("companyName"));
        supplier.setWebsite(rs.getString("website"));
        supplier.setLocation(rs.getString("location"));
        supplier.setNatureOfBusiness(Supplier.NatureOfBusiness.valueOf(rs.getString("natureOfBusiness").toUpperCase()));

        Set<Supplier.ManufacturingProcess> processes = Arrays.stream(rs.getString("manufacturingProcesses").split(","))
                .map(process -> Supplier.ManufacturingProcess.valueOf(process.toUpperCase()))
                .collect(Collectors.toSet());

        supplier.setManufacturingProcesses(processes);
        return supplier;
    };

    public List<Supplier> findSuppliers(String location, Supplier.NatureOfBusiness natureOfBusiness, Supplier.ManufacturingProcess manufacturingProcess, int limit, int offset) {
        String sql = "SELECT * FROM suppliers WHERE location = ? AND natureOfBusiness = ? AND FIND_IN_SET(?, manufacturingProcesses) LIMIT ? OFFSET ?";

        return jdbcTemplate.query(sql, supplierRowMapper, location, natureOfBusiness.name().toLowerCase(), manufacturingProcess.name().toLowerCase(), limit, offset);
    }
}
