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
public class ExampleUnitTest {

    @Test
    public void sumModelAddsValuesCorrectly(){
        List<Integer> values = new ArrayList<>();
        for(int i = 1; i < 6; i++){
            values.add(i);
        }

        SumModel model = new SumModel();
        int result = model.sum(values);
        assertEquals(15, result);
    }
}