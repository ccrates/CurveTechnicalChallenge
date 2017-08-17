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
        List<Integer> values = new ArrayList<>();
        for(int i = 1; i < 6; i++){
            values.add(i);
        }

        SumModel model = new SumModel();
        int result = model.doCalculations(values);
        assertEquals(15, result);
    }

    @Test
    public void sumModelAddsDifferentNumberOfValuesCorrectlyWithNegatives(){
        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(-1);
        values.add(5);
        values.add(-2);

        SumModel model = new SumModel();
        int result = model.doCalculations(values);
        assertEquals(3, result);
    }
}