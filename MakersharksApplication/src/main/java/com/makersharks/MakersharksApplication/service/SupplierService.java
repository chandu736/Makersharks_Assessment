package com.makersharks.MakersharksApplication.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makersharks.MakersharksApplication.model.Supplier;
import com.makersharks.MakersharksApplication.model.Supplier.ManufacturingProcess;
import com.makersharks.MakersharksApplication.model.Supplier.NatureOfBusiness;
import com.makersharks.MakersharksApplication.repository.SupplierRepository;

/**
 * SupplierService is a service layer that handles business logic related to suppliers.
 * It acts as an intermediary between the controller and the repository.
 */
@Service
public class SupplierService {
	
    // Autowiring the SupplierRepository to access supplier data
	@Autowired
	private SupplierRepository supplierRepository;
	
    /**
     * Retrieves a list of suppliers based on location, nature of business, 
     * and manufacturing process with pagination support.
     *
     * @param location             The location of the suppliers to filter by.
     * @param natureOfBusiness     The nature of business to filter by.
     * @param manufacturingProcess The manufacturing process to filter by.
     * @param limit                The maximum number of records to return.
     * @param offset               The starting position of the records to return.
     * @return                     A list of suppliers that match the specified criteria.
     */
	public List<Supplier> getSuppliers(String location, Supplier.NatureOfBusiness natureOfBusiness, Supplier.ManufacturingProcess manufacturingProcess, int limit, int offset) {
        return supplierRepository.findSuppliers(location, natureOfBusiness, manufacturingProcess, limit, offset);
    }
}
