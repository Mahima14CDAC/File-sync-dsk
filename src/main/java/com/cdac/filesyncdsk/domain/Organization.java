/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdac.filesyncdsk.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;


/**
 *
 * @author Mahima
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Organization {

    /**
     * id of the organization
     */
    private Long id;
    /**
     * name of organization
     */
    private String name;
    /**
     * code of organization: will be used in record identifier
     */
    private String organizationCode;
    /**
     * organization details
     */
    private String details;
    /**
     * creator's id
     */
    private Long createdBy;
    /**
     * When Created.
     */
    private Date createdOn;


    /**
     * give value of organization name property
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * set value of organization name property
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * give value of organizationCode property
     *
     * @return
     */
    public String getOrganizationCode() {
        return organizationCode;
    }

    /**
     * set value of organizationCode property
     *
     * @param organizationCode
     */
    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    /**
     * give value of details property
     *
     * @return
     */
    public String getDetails() {
        return details;
    }

    /**
     * set value of details property
     *
     * @param details
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * Gets the id of organization
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id of organization
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the id of creator
     * @return id of creator
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the id of creator
     * @param createdBy 
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * gets the date of creation
     * @return date
     */
    public Date getCreatedOn() {
        return createdOn;
    }

    /**
     * sets the date of creation
     * @param createdOn 
     */
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return "Organization{" + "id=" + id + ", name=" + name + ", organizationCode=" + organizationCode + ", details=" + details + ", createdBy=" + createdBy + ", createdOn=" + createdOn + '}';
    }

}