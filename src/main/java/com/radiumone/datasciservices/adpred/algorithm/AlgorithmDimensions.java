package com.radiumone.datasciservices.adpred.algorithm;


import com.google.common.base.MoreObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Created by broy on 4/14/16.
 */
@Entity
@Table(name = "ALGORITHM_DIMENSIONS")
public class AlgorithmDimensions {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "algo_dim_id")
    private Integer algoDimId;

    @Column(name = "algo_id")
    private Integer algoId;

    @Column(name = "dimension_id")
    private String dimensionId;

    public AlgorithmDimensions() {
        // to satisfy hibernate
    }

    public AlgorithmDimensions(Integer algoId, String dimensionId) {
        this.algoId = algoId;
        this.dimensionId = dimensionId;
    }

    public Integer getAlgoDimId() {
        return algoDimId;
    }

    public Integer getAlgoId() {
        return algoId;
    }

    public String getDimensionId() {
        return dimensionId;
    }

    @Override
    public String toString() {
        return MoreObjects
                .toStringHelper(this.getClass())
                .add("algoDimId", algoDimId)
                .add("algoId", algoId)
                .add("dimensionId", dimensionId)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.algoDimId, this.algoId, this.dimensionId);
    }

    @Override
    public boolean equals(Object other) {
        if (! (other instanceof AlgorithmDimensions)) {
            return false;
        }
        AlgorithmDimensions otherAlgorithmDimensions = (AlgorithmDimensions) other;
        return Objects.equals(this.algoDimId, otherAlgorithmDimensions.algoDimId) &&
                Objects.equals(this.algoId, otherAlgorithmDimensions.algoId) &&
                Objects.equals(this.dimensionId, otherAlgorithmDimensions.dimensionId);
    }
}