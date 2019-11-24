package com.example.codemingleapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {
    @SerializedName("userid")
    @Expose
    private String userid;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("client_no")
    @Expose
    private String clientNo;
    @SerializedName("client/company_name")
    @Expose
    private String clientCompanyName;
    @SerializedName("authorized_representative")
    @Expose
    private String authorizedRepresentative;
    @SerializedName("Full_Address")
    @Expose
    private String fullAddress;
    @SerializedName("phone_no_R")
    @Expose
    private String phoneNoR;
    @SerializedName("phone_no_O")
    @Expose
    private String phoneNoO;
    @SerializedName("client_mobile_no")
    @Expose
    private String clientMobileNo;
    @SerializedName("e_mail")
    @Expose
    private String eMail;
    @SerializedName("active_Status")
    @Expose
    private String activeStatus;
    @SerializedName("gender_id")
    @Expose
    private String genderId;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("occupation")
    @Expose
    private String occupation;
    @SerializedName("address_des")
    @Expose
    private String addressDes;
    @SerializedName("country_id")
    @Expose
    private String countryId;
    @SerializedName("state_id")
    @Expose
    private String stateId;
    @SerializedName("city_id")
    @Expose
    private String cityId;
    @SerializedName("pincode")
    @Expose
    private String pincode;
    @SerializedName("count")
    @Expose
    private String count;

    public Example(){

    }
    public Example(String nm,String location,String contact,String emailId,String designation){

        clientCompanyName=nm;
        addressDes=location;
        clientMobileNo=contact;
        eMail=emailId;
        occupation=designation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getClientCompanyName() {
        return clientCompanyName;
    }

    public void setClientCompanyName(String clientCompanyName) {
        this.clientCompanyName = clientCompanyName;
    }

    public String getAuthorizedRepresentative() {
        return authorizedRepresentative;
    }

    public void setAuthorizedRepresentative(String authorizedRepresentative) {
        this.authorizedRepresentative = authorizedRepresentative;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getPhoneNoR() {
        return phoneNoR;
    }

    public void setPhoneNoR(String phoneNoR) {
        this.phoneNoR = phoneNoR;
    }

    public String getPhoneNoO() {
        return phoneNoO;
    }

    public void setPhoneNoO(String phoneNoO) {
        this.phoneNoO = phoneNoO;
    }

    public String getClientMobileNo() {
        return clientMobileNo;
    }

    public void setClientMobileNo(String clientMobileNo) {
        this.clientMobileNo = clientMobileNo;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getGenderId() {
        return genderId;
    }

    public void setGenderId(String genderId) {
        this.genderId = genderId;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAddressDes() {
        return addressDes;
    }

    public void setAddressDes(String addressDes) {
        this.addressDes = addressDes;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

}