package com.makersharks.MakersharksApplication.model;

import java.util.Set;
import java.util.UUID;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity	
public class Supplier {
	
	@Id
	@GeneratedValue
	@Column(length=36)
	private UUID supplierId;
	
	@Column(nullable = false, length = 255)
	private String companyName;
	
	@Column(length = 255)
	private String website;
	
	@Column(nullable = false, length = 255)
	private String location;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private NatureOfBusiness natureOfBusiness;
	
	public enum NatureOfBusiness{
		SMALL_SCALE, MEDIUM_SCALE, LARGE_SCALE
	}
	
    private Set<ManufacturingProcess> manufacturingProcesses;
	
	public enum ManufacturingProcess {
	    MOULDING, PRINTING_3D, COATING, CASTING
	}

	public UUID getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(UUID suplierId) {
		this.supplierId = suplierId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public NatureOfBusiness getNatureOfBusiness() {
		return natureOfBusiness;
	}

	public void setNatureOfBusiness(NatureOfBusiness natureOfBusiness) {
		this.natureOfBusiness = natureOfBusiness;
	}

	public Set<ManufacturingProcess> getManufacturingProcesses() {
		return manufacturingProcesses;
	}

	public void setManufacturingProcesses(Set<ManufacturingProcess> manufacturingProcesses) {
		this.manufacturingProcesses = manufacturingProcesses;
	}
}