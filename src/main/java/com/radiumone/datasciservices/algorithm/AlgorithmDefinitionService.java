package com.radiumone.datasciservices.algorithm;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by broy on 4/13/16.
 */
@Controller
@RequestMapping("/algorithm")
public class AlgorithmDefinitionService {

    @RequestMapping( method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody Algorithm create(@RequestBody Algorithm payload) {

        System.out.println("Request received. Payload=" + payload);
        payload.setAlgoType("GOTIT2222");

        return payload;
    }




    public static void main(String[] args) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();

        Algorithm algorithm = new Algorithm();
        algorithm.setAlgoName("rm_pixel_opti");
        algorithm.setAlgoType("plus_1_dimensional");
        List<Integer> dimensionTypeIds = new ArrayList<>();
        dimensionTypeIds.add(1);
        dimensionTypeIds.add(2);
        algorithm.setDimensionTypeIds(dimensionTypeIds);
        algorithm.setRollupEntityType(RollupEntityType.ADVERTISER);

        String algoString = objectMapper.writeValueAsString(algorithm);
        System.out.println("algoString=" + algoString);
    }



}
