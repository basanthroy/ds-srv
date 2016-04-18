package com.radiumone.datasciservices.adpred.dimension;


import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by broy on 4/18/16.
 */
@XmlRootElement(name = "DimensionType")
@Entity
@Table(name = "DIMENSION_TYPES")
public class DimensionTypes {

    @Id
    @Column(name = "dimension_id")
    private Integer dimensionId;

    @Column(name = "dimension_name")
    private String dimensionName;

    private DimensionTypes() {
        // To satisfy hibernate
    }

    public DimensionTypes(Integer dimensionId, String dimensionName) {
        this.dimensionId = dimensionId;
        this.dimensionName = dimensionName;
    }

    public Integer getDimensionId() {
        return dimensionId;
    }

    public String getDimensionName() {
        return dimensionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DimensionTypes that = (DimensionTypes) o;
        return Objects.equal(dimensionId, that.dimensionId) &&
                Objects.equal(dimensionName, that.dimensionName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dimensionId, dimensionName);
    }

    @Override
    public String toString() {
        return "DimensionTypes{" +
                "dimensionId=" + dimensionId +
                ", dimensionName='" + dimensionName + '\'' +
                '}';
    }
}