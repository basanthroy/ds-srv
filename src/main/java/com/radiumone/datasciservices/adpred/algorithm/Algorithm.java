package com.radiumone.datasciservices.adpred.algorithm;


import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by broy on 4/14/16.
 */
@Entity
@Table(name = "ALGORITHMS")
public class Algorithm {

    @Id
    @Column(name = "algo_id")
    private Integer algoId;

    @Column(name = "algo_name")
    private String algoName;

    private Algorithm() {
        // To satisfy hibernate
    }

    public Algorithm(Integer algoId, String algoName) {
        this.algoId = algoId;
        this.algoName = algoName;
    }

    public Integer getAlgoId() {
        return algoId;
    }

    public String getAlgoName() {
        return algoName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Algorithm algorithm = (Algorithm) o;
        return Objects.equal(algoId, algorithm.algoId) &&
                Objects.equal(algoName, algorithm.algoName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(algoId, algoName);
    }

    @Override
    public String toString() {
        return "Algorithm{" +
                "algoId=" + algoId +
                ", algoName='" + algoName + '\'' +
                '}';
    }
}