package com.greenacademy.model;

import java.io.Serial;
import java.io.Serializable;

public class Provider implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String providerId;
    private String providerName;
    private String address;
    private String phone;

    public Provider() {
    }

    public Provider(String providerId, String providerName, String address, String phone) {
        this.providerId = providerId;
        this.providerName = providerName;
        this.address = address;
        this.phone = phone;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
