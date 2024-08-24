package com.makersharks.MakersharksApplication.controller;

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

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/query")
    public ResponseEntity<List<Supplier>> querySuppliers(
            @RequestParam String location,
            @RequestParam NatureOfBusiness natureOfBusiness,
            @RequestParam ManufacturingProcess manufacturingProcesses,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(defaultValue = "0") int offset) {

        List<Supplier> suppliers = supplierService.getSuppliers(location, natureOfBusiness, manufacturingProcesses, limit, offset);
        return ResponseEntity.ok(suppliers);
    }

}
