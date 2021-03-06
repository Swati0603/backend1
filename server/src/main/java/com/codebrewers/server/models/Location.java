package com.codebrewers.server.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Entity
@Table(name="location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="location_id")
    private Long locationId;

    @Column(name="location_district", nullable=false)
    private String locationDistrict;

    @Column(name="location_city", nullable=false)
    private String locationCity;

    @Column(name="location_state", nullable=false)
    private String locationState;

    @Column(name="location_country", nullable=false)
    private String locationCountry;

    @Column(name="location_pincode", nullable=false)
    private String locationPinCode;

    @JsonIgnore
    @ManyToMany(mappedBy = "jobLocation")
    private List<JobPost> jobPosts;

    @JsonIgnore
    @OneToMany(mappedBy = "collegeLocation")
    private List<College> colleges;

    public Location() {
    }

    public Location(String locationDistrict, String locationCity, String locationState, String locationCountry, String locationPinCode, List<JobPost> jobPosts, List<College> colleges) {
        this.locationDistrict = locationDistrict;
        this.locationCity = locationCity;
        this.locationState = locationState;
        this.locationCountry = locationCountry;
        this.locationPinCode = locationPinCode;
        this.jobPosts = jobPosts;
        this.colleges = colleges;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getLocationDistrict() {
        return locationDistrict;
    }

    public void setLocationDistrict(String locationDistrict) {
        this.locationDistrict = locationDistrict;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationState() {
        return locationState;
    }

    public void setLocationState(String locationState) {
        this.locationState = locationState;
    }

    public String getLocationCountry() {
        return locationCountry;
    }

    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }

    public String getLocationPinCode() {
        return locationPinCode;
    }

    public void setLocationPinCode(String locationPinCode) {
        this.locationPinCode = locationPinCode;
    }

    @JsonIgnore
    public List<College> getColleges() {
        return colleges;
    }

    @JsonIgnore
    public void setColleges(List<College> colleges) {
        this.colleges = colleges;
    }

    @JsonIgnore
    public List<JobPost> getJobPosts() {
        return jobPosts;
    }

    @JsonIgnore
    public void setJobPosts(List<JobPost> jobPosts) {
        this.jobPosts = jobPosts;
    }
}
