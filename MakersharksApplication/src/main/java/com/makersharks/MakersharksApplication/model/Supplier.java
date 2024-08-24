package com.makersharks.MakersharksApplication.model;

// Importing necessary JPA and Java utility classes
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

/**
 * The Supplier class represents a supplier entity in the system.
 * It includes various attributes such as supplier ID, company name, website,
 * location, nature of business, and manufacturing processes.
 */
@Entity
public class Supplier {

    // Unique identifier for each supplier, generated automatically
    @Id
    @GeneratedValue
    @Column(length=36)
    private UUID supplierId;

    // Name of the company, mandatory field with a maximum length of 255 characters
    @Column(nullable = false, length = 255)
    private String companyName;

    // Website of the company, optional field with a maximum length of 255 characters
    @Column(length = 255)
    private String website;

    // Location of the supplier, mandatory field with a maximum length of 255 characters
    @Column(nullable = false, length = 255)
    private String location;

    // Nature of the business, represented as an enumeration and stored as a string in the database
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NatureOfBusiness natureOfBusiness;

    /**
     * Enumeration to represent the nature of business.
     * It can be either SMALL_SCALE, MEDIUM_SCALE, or LARGE_SCALE.
     */
    public enum NatureOfBusiness {
        SMALL_SCALE, MEDIUM_SCALE, LARGE_SCALE
    }

    // A set of manufacturing processes associated with the supplier
    private Set<ManufacturingProcess> manufacturingProcesses;

    /**
     * Enumeration to represent various manufacturing processes.
     * The options include MOULDING, PRINTING_3D, COATING, and CASTING.
     */
    public enum ManufacturingProcess {
        MOULDING, PRINTING_3D, COATING, CASTING
    }

    // Getters and setters for the fields

    public UUID getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(UUID supplierId) {
        this.supplierId = supplierId;
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
