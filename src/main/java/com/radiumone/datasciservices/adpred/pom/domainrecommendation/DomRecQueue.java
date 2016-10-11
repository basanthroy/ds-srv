package com.radiumone.datasciservices.adpred.pom.domainrecommendation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by broy on 10/10/16.
 */
@Entity
@Table(name = "DOM_REC_QUEUE")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DomRecQueue {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "dom_rec_id")
    private Long domRecId;

    @Column(name = "date_new")
    @JsonIgnore
    private Date createdAt;

    @Column(name = "date_in_process")
    @JsonIgnore
    private Date dateInProcess;

    @Column(name = "date_processed")
    @JsonIgnore
    private Date dateProcessed;

    @Column(name = "date_error")
    @JsonIgnore
    private Date dateError;

    @Column(name = "bid_list_name")
    private String bidListName;

    @Column(name = "bid_list_id")
    @NotNull(message = "bid_list_id cannot be null")
    private Integer bidListId;

    @Column(name = "strategy_name")
    private String strategyName;

    @Column(name = "line_id")
    @NotNull(message = "lineId cannot be null")
    private Integer lineId;

    @Column(name = "target_cpm")
    private BigDecimal targetCpm;

    @Column(name = "uniques")
    @NotNull(message = "Uniques cannot be null")
    private Integer uniques;

    @Column(name = "min_bid")
    @NotNull(message = "min_bid cannot be null")
    private BigDecimal minBid;

    @Column(name = "max_bid")
    @NotNull(message = "max_bid cannot be null")
    private BigDecimal maxBid;

    @Column(name = "strategy_id")
    @NotNull(message = "strategy_id cannot be null")
    private Integer strategyId;

    @Column(name = "status")
    private String status = "new";

    @Column(name = "dom_rec_result_id")
    private Long domRecResultId;

    private DomRecQueue() {
        // To satisfy hibernate
    }

    public DomRecQueue(Long domRecId, Date createdAt, Date dateInProcess, Date dateProcessed,
                       Date dateError, String bidListName, Integer bidListId, String strategyName,
                       Integer lineId, BigDecimal targetCpm, Integer uniques, BigDecimal minBid,
                       BigDecimal maxBid, Integer strategyId, String status, Long domRecResultId) {
        this.domRecId = domRecId;
        this.createdAt = createdAt;
        this.dateInProcess = dateInProcess;
        this.dateProcessed = dateProcessed;
        this.dateError = dateError;
        this.bidListName = bidListName;
        this.bidListId = bidListId;
        this.strategyName = strategyName;
        this.lineId = lineId;
        this.targetCpm = targetCpm;
        this.uniques = uniques;
        this.minBid = minBid;
        this.maxBid = maxBid;
        this.strategyId = strategyId;
        this.status = status;
        this.domRecResultId = domRecResultId;
    }

    public Long getDomRecId() {
        return domRecId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getBidListName() {
        return bidListName;
    }

    public Integer getBidListId() {
        return bidListId;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public Integer getLineId() {
        return lineId;
    }

    public BigDecimal getTargetCpm() {
        return targetCpm;
    }

    public Integer getUniques() {
        return uniques;
    }

    public BigDecimal getMinBid() {
        return minBid;
    }

    public BigDecimal getMaxBid() {
        return maxBid;
    }

    public Integer getStrategyId() {
        return strategyId;
    }

    public Date getDateInProcess() {
        return dateInProcess;
    }

    public Date getDateProcessed() {
        return dateProcessed;
    }

    public Date getDateError() {
        return dateError;
    }

    public String getStatus() {
        return status;
    }

    public Long getDomRecResultId() {
        return domRecResultId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomRecQueue that = (DomRecQueue) o;
        return Objects.equal(domRecId, that.domRecId) &&
                Objects.equal(createdAt, that.createdAt) &&
                Objects.equal(dateInProcess, that.dateInProcess) &&
                Objects.equal(dateProcessed, that.dateProcessed) &&
                Objects.equal(dateError, that.dateError) &&
                Objects.equal(bidListName, that.bidListName) &&
                Objects.equal(bidListId, that.bidListId) &&
                Objects.equal(strategyName, that.strategyName) &&
                Objects.equal(lineId, that.lineId) &&
                Objects.equal(targetCpm, that.targetCpm) &&
                Objects.equal(uniques, that.uniques) &&
                Objects.equal(minBid, that.minBid) &&
                Objects.equal(maxBid, that.maxBid) &&
                Objects.equal(strategyId, that.strategyId) &&
                Objects.equal(status, that.status) &&
                Objects.equal(domRecResultId, that.domRecResultId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(domRecId, createdAt, dateInProcess, dateProcessed, dateError,
                bidListName, bidListId, strategyName,
                lineId, targetCpm, uniques, minBid,
                maxBid, strategyId, strategyId, domRecResultId);
    }

    @Override
    public String toString() {
        return "DomRecQueue{" +
                "domRecId=" + domRecId + '\'' +
                ", createdAt=" + createdAt + '\'' +
                ", dateInProcess=" + dateInProcess + '\'' +
                ", dateProcessed=" + dateProcessed + '\'' +
                ", dateError=" + dateError + '\'' +
                ", bidListName='" + bidListName + '\'' +
                ", bidListId='" + bidListId + '\'' +
                ", strategyName='" + strategyName + '\'' +
                ", lineId='" + lineId + '\'' +
                ", targetCpm='" + targetCpm + '\'' +
                ", uniques='" + uniques + '\'' +
                ", minBid='" + minBid + '\'' +
                ", maxBid='" + maxBid + '\'' +
                ", strategyId='" + strategyId + '\'' +
                ", status='" + status + '\'' +
                ", domRecResultId='" + domRecResultId + '\'' +
                '}';
    }
}