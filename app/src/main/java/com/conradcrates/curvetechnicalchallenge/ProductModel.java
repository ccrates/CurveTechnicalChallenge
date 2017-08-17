package com.conradcrates.curvetechnicalchallenge;

import java.util.List;

/**
 * Created by Conrad on 17/08/2017.
 */

public class ProductModel implements CalculationModel{

    @Override
    public double doCalculations(List<Double> values) {
        double total = values.get(0);
        for(int i = 1; i < values.size(); i++){
            total = total * values.get(i);
        }
        return total;
    }
}