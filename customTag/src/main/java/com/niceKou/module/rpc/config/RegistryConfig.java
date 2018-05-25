package com.niceKou.module.rpc.config;

import java.io.Serializable;
import java.util.Map;

public class RegistryConfig implements Serializable {
    private static final long serialVersionUID = 4165191861868316850L;

    private String id;
    private String address;
    private String protocol;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @Override
    public String toString() {
        return "RegistryConfig{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", protocol='" + protocol + '\'' +
                '}';
    }
}
