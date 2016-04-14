package com.radiumone.datasciservices.algorithm;


import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by broy on 4/13/16.
 */
@XmlRootElement(name = "Algorithm")
public class Algorithm {

    private int algoId;

    private String algoName;

    private String algoType;

    private RollupEntityType rollupEntityType;

    private List<Integer> dimensionTypeIds;

    public int getAlgoId() {
        return algoId;
    }

    public void setAlgoId(int algoId) {
        this.algoId = algoId;
    }

    public String getAlgoName() {
        return algoName;
    }

    public void setAlgoName(String algoName) {
        this.algoName = algoName;
    }

    public List<Integer> getDimensionTypeIds() {
        return dimensionTypeIds;
    }

    public void setDimensionTypeIds(List<Integer> dimensionTypeIds) {
        this.dimensionTypeIds = dimensionTypeIds;
    }

    public RollupEntityType getRollupEntityType() {
        return rollupEntityType;
    }

    public void setRollupEntityType(RollupEntityType rollupEntityType) {
        this.rollupEntityType = rollupEntityType;
    }

    public String getAlgoType() {
        return algoType;
    }

    public void setAlgoType(String algoType) {
        this.algoType = algoType;
    }

}