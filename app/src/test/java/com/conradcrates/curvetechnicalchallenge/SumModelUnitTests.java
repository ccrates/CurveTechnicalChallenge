package com.conradcrates.curvetechnicalchallenge;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SumModelUnitTests {

    @Test
    public void sumModelAddsValuesCorrectly(){
        List<Double> values = new ArrayList<>();
        for(double i = 1; i < 6; i++){
            values.add(i);
        }

        SumModel model = new SumModel();
        double result = model.doCalculations(values);
        assertEquals(15, result, 0);
    }

    @Test
    public void sumModelAddsDifferentNumberOfValuesCorrectlyWithNegatives(){
        List<Double> values = new ArrayList<>();
        values.add(1d);
        values.add(-1d);
        values.add(5d);
        values.add(-2d);

        SumModel model = new SumModel();
        double result = model.doCalculations(values);
        assertEquals(3, result, 0);
    }
}