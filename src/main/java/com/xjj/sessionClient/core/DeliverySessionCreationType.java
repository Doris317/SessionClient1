package com.xjj.sessionClient.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "DeliverySession")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeliverySessionCreationType", propOrder = {
    "deliverySessionId",
    "action",
    "tmgiPool",
    "tmgi",
    "startTime",
    "stopTime"
})
public class DeliverySessionCreationType {

    @XmlElement(name = "DeliverySessionId")
    @XmlSchemaType(name = "unsignedInt")
    protected long deliverySessionId;
    @XmlElement(name = "Action", required = true)
    @XmlSchemaType(name = "string")
    protected ActionType action;
    @XmlElement(name = "TMGIPool")
    protected String tmgiPool;
    @XmlElement(name = "TMGI")
    protected String tmgi;
    @XmlElement(name = "StartTime")
    @XmlSchemaType(name = "unsignedInt")
    protected Long startTime;
    @XmlElement(name = "StopTime")
    @XmlSchemaType(name = "unsignedInt")
    protected Long stopTime;
    @XmlAttribute(name = "Version", required = true)
    protected String version;

    public long getDeliverySessionId() {
        return deliverySessionId;
    }

    public void setDeliverySessionId(long value) {
        this.deliverySessionId = value;
    }

    public ActionType getAction() {
        return action;
    }

    public void setAction(ActionType value) {
        this.action = value;
    }

    public String getTMGIPool() {
        return tmgiPool;
    }

    public void setTMGIPool(String value) {
        this.tmgiPool = value;
    }

    public String getTMGI() {
        return tmgi;
    }

    public void setTMGI(String value) {
        this.tmgi = value;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long value) {
        this.startTime = value;
    }

    public Long getStopTime() {
        return stopTime;
    }

    public void setStopTime(Long value) {
        this.stopTime = value;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String value) {
        this.version = value;
    }

}
