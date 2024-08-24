package com.makersharks.MakersharksApplication.controller;

// Importing necessary classes and packages
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.makersharks.MakersharksApplication.model.Supplier;
import com.makersharks.MakersharksApplication.model.Supplier.ManufacturingProcess;
import com.makersharks.MakersharksApplication.model.Supplier.NatureOfBusiness;
import com.makersharks.MakersharksApplication.service.SupplierService;

/**
 * SupplierController is a REST controller that handles HTTP requests related to suppliers.
 * It provides endpoints for querying suppliers based on various criteria such as location,
 * nature of business, and manufacturing processes.
 */
@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    // Autowiring the SupplierService to use its methods for supplier operations
    @Autowired
    private SupplierService supplierService;

    /**
     * Endpoint to query suppliers based on location, nature of business, and manufacturing processes.
     * This method handles POST requests to the "/query" endpoint.
     *
     * @param location             The location of the suppliers to be queried.
     * @param natureOfBusiness     The nature of business of the suppliers.
     * @param manufacturingProcesses The manufacturing processes involved.
     * @param limit                The maximum number of suppliers to return (default is 10).
     * @param offset               The starting point in the list of suppliers (default is 0).
     * @return                     A ResponseEntity containing a list of suppliers that match the query.
     */
    @PostMapping("/query")
    public ResponseEntity<List<Supplier>> querySuppliers(
            @RequestParam String location,
            @RequestParam NatureOfBusiness natureOfBusiness,
            @RequestParam ManufacturingProcess manufacturingProcesses,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(defaultValue = "0") int offset) {

        // Fetching the list of suppliers from the service layer based on the query parameters
        List<Supplier> suppliers = supplierService.getSuppliers(location, natureOfBusiness, manufacturingProcesses, limit, offset);

        // Returning the list of suppliers wrapped in a ResponseEntity with an HTTP 200 status code
        return ResponseEntity.ok(suppliers);
    }

}
