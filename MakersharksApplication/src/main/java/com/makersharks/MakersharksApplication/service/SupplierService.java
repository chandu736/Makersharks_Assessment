package com.makersharks.MakersharksApplication.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makersharks.MakersharksApplication.model.Supplier;
import com.makersharks.MakersharksApplication.model.Supplier.ManufacturingProcess;
import com.makersharks.MakersharksApplication.model.Supplier.NatureOfBusiness;
import com.makersharks.MakersharksApplication.repository.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	public List<Supplier> getSuppliers(String location, Supplier.NatureOfBusiness natureOfBusiness, Supplier.ManufacturingProcess manufacturingProcess, int limit, int offset) {
        return supplierRepository.findSuppliers(location, natureOfBusiness, manufacturingProcess, limit, offset);
    }
}
