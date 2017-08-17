package com.conradcrates.curvetechnicalchallenge;

import java.util.List;

/**
 * Created by Conrad on 17/08/2017.
 */

public class SumModel implements CalculationModel{

    @Override
    public int doCalculations(List<Integer> values){
        int total = 0;
        for(int value : values){
            total += value;
        }
        return total;
    }
}