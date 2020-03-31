package com.gupao.java_core.classify.demo3;

import java.util.Date;

/**
 * Every oak must be an acorn ...
 * Author : Seven
 */
public class IdentityCard {

    private  String idNumber;
    private String address;
    private Date startDate;
    private Date endDate;

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
