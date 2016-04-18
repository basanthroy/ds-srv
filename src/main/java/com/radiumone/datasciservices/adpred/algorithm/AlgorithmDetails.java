package com.radiumone.datasciservices.adpred.algorithm;


import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by broy on 4/14/16.
 */
@XmlRootElement(name = "AlgorithmDetails")
@Entity
@Table(name = "ALGORITHM_DETAILS")
public class AlgorithmDetails {

    @Id
    @Column(name = "algo_id")
    private Integer algoId;

    @Column(name = "algo_name")
    private String algoName;

    @Column(name = "algo_type")
    private String algoType;

    @Column(name = "rollup_entity_type")
    @Enumerated(value = EnumType.STRING)
    private RollupEntityType rollupEntityType;

    @Transient
    private List<Integer> dimensionTypeIds;

    public Integer getAlgoId() {
        return algoId;
    }

    public String getAlgoName() {
        return algoName;
    }

    public RollupEntityType getRollupEntityType() {
        return rollupEntityType;
    }

    public String getAlgoType() {
        return algoType;
    }

    public List<Integer> getDimensionTypeIds() {
        return dimensionTypeIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlgorithmDetails that = (AlgorithmDetails) o;
        return Objects.equal(algoId, that.algoId) &&
                Objects.equal(algoName, that.algoName) &&
                Objects.equal(algoType, that.algoType) &&
                rollupEntityType == that.rollupEntityType &&
                Objects.equal(dimensionTypeIds, that.dimensionTypeIds);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(algoId, algoName, algoType, rollupEntityType, dimensionTypeIds);
    }

    @Override
    public String toString() {
        return "AlgorithmDetails{" +
                "algoId=" + algoId +
                ", algoName='" + algoName + '\'' +
                ", algoType='" + algoType + '\'' +
                ", rollupEntityType=" + rollupEntityType +
                ", dimensionTypeIds=" + dimensionTypeIds +
                '}';
    }
}