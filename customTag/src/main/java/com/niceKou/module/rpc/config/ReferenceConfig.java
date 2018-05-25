package com.niceKou.module.rpc.config;

import java.io.Serializable;

public class ReferenceConfig implements Serializable {
    private static final long serialVersionUID = 6085584774121897060L;
    private String id;
    private String protocol;
    private String interfaceName;
    private String loadBalance;
    private String cluster;
    private String retries;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getLoadBalance() {
        return loadBalance;
    }

    public void setLoadBalance(String loadBalance) {
        this.loadBalance = loadBalance;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public String getRetries() {
        return retries;
    }

    public void setRetries(String retries) {
        this.retries = retries;
    }

    @Override
    public String toString() {
        return "ReferenceConfig{" +
                "id='" + id + '\'' +
                ", protocol='" + protocol + '\'' +
                ", interfaceName='" + interfaceName + '\'' +
                ", loadBalance='" + loadBalance + '\'' +
                ", cluster='" + cluster + '\'' +
                ", retries='" + retries + '\'' +
                '}';
    }
}
