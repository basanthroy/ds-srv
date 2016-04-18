package com.radiumone.datasciservices.arte.app.enqueue;


import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by broy on 4/18/16.
 */
@XmlRootElement(name = "Enqueue")
@Entity
@Table(name = "JOIN_REQUESTS")
public class Enqueue {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Integer requestId;

    @Column(name = "algo_id")
    private Integer algoId;

    @Column(name = "create_ts")
    private String createTs;

    @Column(name = "update_ts")
    private String updateTs;

    @Column(name = "status")
    private String status;

    private Enqueue() {
        // To satisfy hibernate
    }

    public void populateDefaultValues() {
        this.createTs = getCurrentTsString();
        this.updateTs = this.createTs;
        this.status = "pending";
    }

    private static String getCurrentTsString() {
        Date curDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssss");
        return format.format(curDate);
    }

    public static void main(String[] args) {
        System.out.println("getCurrentTsString = " + getCurrentTsString());
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getAlgoId() {
        return algoId;
    }

    public void setAlgoId(Integer algoId) {
        this.algoId = algoId;
    }

    public String getCreateTs() {
        return createTs;
    }

    public void setCreateTs(String createTs) {
        this.createTs = createTs;
    }

    public String getUpdateTs() {
        return updateTs;
    }

    public void setUpdateTs(String updateTs) {
        this.updateTs = updateTs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enqueue enqueue = (Enqueue) o;
        return Objects.equal(requestId, enqueue.requestId) &&
                Objects.equal(algoId, enqueue.algoId) &&
                Objects.equal(createTs, enqueue.createTs) &&
                Objects.equal(updateTs, enqueue.updateTs) &&
                Objects.equal(status, enqueue.status);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(requestId, algoId, createTs, updateTs, status);
    }

    @Override
    public String toString() {
        return "Enqueue{" +
                "requestId=" + requestId +
                ", algoId=" + algoId +
                ", createTs='" + createTs + '\'' +
                ", updateTs='" + updateTs + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}