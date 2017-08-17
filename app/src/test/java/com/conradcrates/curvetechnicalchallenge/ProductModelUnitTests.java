package com.conradcrates.curvetechnicalchallenge;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Conrad on 17/08/2017.
 */

public class ProductModelUnitTests {

    @Test
    public void productModelMultipliesValuesCorrectly(){
        List<Double> values = new ArrayList<>();
        for(double i = 0; i < 5; i++){
            values.add(i+1);
        }

        ProductModel model = new ProductModel();
        double result = model.doCalculations(values);
        assertEquals(120,result,0);
    }
}
