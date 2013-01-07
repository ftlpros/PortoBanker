/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porto.dao;

/**
 *
 * @author eipps
 */
public class CustomerInfoDAO {
    private String houseNo;
    private String buildingName;
    private String sectorNo;
    private String address;
    private String locality;
    private String city;
    private String state;
    private String pincode;
    private boolean presentAndPermanentsame;
    private String phouseNo;
    private String pbuildingName;
    private String psectorNo;
    private String paddress;
    private String plocality;
    private String pcity;
    private String pstate;
    private String ppincode;
    public static final CustomerInfoDAO INSTANCE = new CustomerInfoDAO();
    public static CustomerInfoDAO getInstance(){
        if(INSTANCE!= null){
            return INSTANCE;
        }
        else{
            return new CustomerInfoDAO();
        }
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getSectorNo() {
        return sectorNo;
    }

    public void setSectorNo(String sectorNo) {
        this.sectorNo = sectorNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public boolean isPresentAndPermanentsame() {
        return presentAndPermanentsame;
    }

    public void setPresentAndPermanentsame(boolean presentAndPermanentsame) {
        this.presentAndPermanentsame = presentAndPermanentsame;
    }
    
    public String getPhouseNo() {
        return phouseNo;
    }

    public void setPhouseNo(String phouseNo) {
        this.phouseNo = phouseNo;
    }

    public String getPbuildingName() {
        return pbuildingName;
    }

    public void setPbuildingName(String pbuildingName) {
        this.pbuildingName = pbuildingName;
    }

    public String getPsectorNo() {
        return psectorNo;
    }

    public void setPsectorNo(String psectorNo) {
        this.psectorNo = psectorNo;
    }

    public String getPaddress() {
        return paddress;
    }

    public void setPaddress(String paddress) {
        this.paddress = paddress;
    }

    public String getPlocality() {
        return plocality;
    }

    public void setPlocality(String plocality) {
        this.plocality = plocality;
    }

    public String getPcity() {
        return pcity;
    }

    public void setPcity(String pcity) {
        this.pcity = pcity;
    }

    public String getPstate() {
        return pstate;
    }

    public void setPstate(String pstate) {
        this.pstate = pstate;
    }

    public String getPpincode() {
        return ppincode;
    }

    public void setPpincode(String ppincode) {
        this.ppincode = ppincode;
    }
    
}
