package com.radiumone.datasciservices.adpred.pom.domainrecommendation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by broy on 10/10/16.
 */
@XmlRootElement(name = "domain_recommend_jaccard_similarity")
public class DomRecQueueEnvelope {

    @JsonProperty("domain_recommend_jaccard_similarity")
    @Valid
    private DomRecQueue domRecQueue;

    private DomRecQueueEnvelope() {
        // To satisfy hibernate
    }

    public DomRecQueueEnvelope(DomRecQueue domRecQueue) {
        this.domRecQueue = domRecQueue;
    }

    public DomRecQueue getDomRecQueue() {
        return domRecQueue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomRecQueueEnvelope that = (DomRecQueueEnvelope) o;
        return Objects.equal(domRecQueue, that.domRecQueue);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(domRecQueue);
    }

    @Override
    public String toString() {
        return "DomRecQueue{" +
                "domRecQueue=" + domRecQueue + '\'' +
                '}';
    }
}