package com.conradcrates.curvetechnicalchallenge;

import java.util.List;

/**
 * Created by Conrad on 17/08/2017.
 */

public class SumModel implements CalculationModel{

    public double doCalculations(List<Double> values){
        int total = 0;
        for(double value : values){
            total += value;
        }
        return total;
    }
}