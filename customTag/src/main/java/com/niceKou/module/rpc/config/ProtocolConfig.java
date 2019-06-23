package com.niceKou.module.rpc.config;

import java.io.Serializable;

public class ProtocolConfig implements Serializable {
    private static final long serialVersionUID = 4092374277763588824L;
    private String id;
    private String name;
    private String host;
    private Integer port;


    public ProtocolConfig() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProtocolConfig{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                '}';
    }
}
