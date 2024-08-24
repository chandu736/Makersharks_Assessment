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

/**
 * SupplierRepository is a data access layer that interacts with the database 
 * to perform CRUD operations related to suppliers.
 */
@Repository
public class SupplierRepository {
	
    // Autowiring JdbcTemplate to execute SQL queries
	@Autowired
	private JdbcTemplate jdbcTemplate;

    /**
     * RowMapper implementation to map the result set from SQL queries to Supplier objects.
     * It converts each row of the result set into a Supplier object.
     */
    private final RowMapper<Supplier> supplierRowMapper = (rs, rowNum) -> {
        Supplier supplier = new Supplier();

        // Mapping columns from the result set to the Supplier object's fields
        supplier.setSupplierId(UUID.fromString(rs.getString("supplierId")));
        supplier.setCompanyName(rs.getString("companyName"));
        supplier.setWebsite(rs.getString("website"));
        supplier.setLocation(rs.getString("location"));
        supplier.setNatureOfBusiness(Supplier.NatureOfBusiness.valueOf(rs.getString("natureOfBusiness").toUpperCase()));

        // Converting the comma-separated manufacturing processes from the result set into a Set of ManufacturingProcess enums
        Set<Supplier.ManufacturingProcess> processes = Arrays.stream(rs.getString("manufacturingProcesses").split(","))
                .map(process -> Supplier.ManufacturingProcess.valueOf(process.toUpperCase()))
                .collect(Collectors.toSet());

        supplier.setManufacturingProcesses(processes);
        return supplier;
    };

    /**
     * Retrieves a list of suppliers from the database based on the provided location, 
     * nature of business, and manufacturing process.
     *
     * @param location             The location of the suppliers to filter by.
     * @param natureOfBusiness     The nature of business to filter by.
     * @param manufacturingProcess The manufacturing process to filter by.
     * @param limit                The maximum number of records to return.
     * @param offset               The starting position of the records to return.
     * @return                     A list of suppliers that match the specified criteria.
     */
    public List<Supplier> findSuppliers(String location, Supplier.NatureOfBusiness natureOfBusiness, Supplier.ManufacturingProcess manufacturingProcess, int limit, int offset) {
        // SQL query to fetch suppliers based on the location, nature of business, and manufacturing process
        String sql = "SELECT * FROM suppliers WHERE location = ? AND natureOfBusiness = ? AND FIND_IN_SET(?, manufacturingProcesses) LIMIT ? OFFSET ?";

        // Executing the query and mapping the results to Supplier objects using the RowMapper
        return jdbcTemplate.query(sql, supplierRowMapper, location, natureOfBusiness.name().toLowerCase(), manufacturingProcess.name().toLowerCase(), limit, offset);
    }
}
