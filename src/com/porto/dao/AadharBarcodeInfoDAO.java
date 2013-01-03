/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porto.dao;

/**
 *
 * @author eipps
 */
public class AadharBarcodeInfoDAO {
    private String uid;
    private String name;
    private String gender;
    private String yob;
    private String lm;
    private String address;
    private String vtc;
    private String dist;
    private String state;
    private String pincode;
    private boolean dataAvailable;
    public static final AadharBarcodeInfoDAO INSTANCE = new AadharBarcodeInfoDAO();
    public static AadharBarcodeInfoDAO getInstance(){
        if(INSTANCE!=null){
            return INSTANCE;
        }
        else{
            return new AadharBarcodeInfoDAO();
        }
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getYob() {
        return yob;
    }

    public void setYob(String yob) {
        this.yob = yob;
    }

    public String getLm() {
        return lm;
    }

    public void setLm(String lm) {
        this.lm = lm;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVtc() {
        return vtc;
    }

    public void setVtc(String vtc) {
        this.vtc = vtc;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
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

    public boolean isDataAvailable() {
        return dataAvailable;
    }

    public void setDataAvailable(boolean dataAvailable) {
        this.dataAvailable = dataAvailable;
    }
    
    
}
