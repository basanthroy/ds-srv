package com.radiumone.datasciservices.adpred.pom.domainrecommendation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by broy on 10/10/16.
 */
@Entity
@Table(name = "DOM_REC_RESULTS")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DomRecResults {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "dom_rec_result_id")
    private Long domRecResultId;

    @Column(name = "dom_rec_id")
    private Long domRecId;

    @Column(name = "list_data")
    private String listData;

    @Column(name = "baseline_bid_data")
    private String baselineBidData;

    private DomRecResults() {
        // To satisfy hibernate
    }

    public DomRecResults(Long domRecResultId, Long domRecId,
                         String listData, String baselineBidData) {
        this.domRecResultId = domRecResultId;
        this.domRecId = domRecId;
        this.listData = listData;
        this.baselineBidData = baselineBidData;
    }

    public Long getDomRecResultId() {
        return domRecResultId;
    }

    public Long getDomRecId() {
        return domRecId;
    }

    public String getBaselineBidData() {
        return baselineBidData;
    }

    public String getListData() {
        return listData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomRecResults that = (DomRecResults) o;
        return  Objects.equal(domRecResultId, that.domRecResultId) &&
                Objects.equal(listData, that.listData) &&
                Objects.equal(baselineBidData, that.baselineBidData) &&
                Objects.equal(domRecId, that.domRecId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(domRecResultId, listData, baselineBidData,
                domRecId);
    }

    @Override
    public String toString() {
        return "DomRecQueue{" +
                "domRecResultId=" + domRecResultId + '\'' +
                ", listData=" + listData + '\'' +
                ", baselineBidData=" + baselineBidData + '\'' +
                ", domRecId='" + domRecId + '\'' +
                '}';
    }
}