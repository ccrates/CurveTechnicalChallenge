package com.conradcrates.curvetechnicalchallenge;

import android.text.Editable;
import android.text.TextWatcher;

import java.util.List;

/**
 * Created by Conrad on 17/08/2017.
 */

public class MainActivityViewModel {

    private List<Integer> values;
    private SumModel model;

    public MainActivityViewModel(List<Integer> values, SumModel model){
        this.values = values;
        this.model = model;
    }

    public TextWatcher getTextWatcher(final int index){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try{
                    int newValue = Integer.parseInt(editable.toString());
                    values.set(index, newValue);
                    model.sum(values);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
    }
}