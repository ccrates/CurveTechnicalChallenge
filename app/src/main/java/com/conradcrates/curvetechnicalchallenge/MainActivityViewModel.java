package com.conradcrates.curvetechnicalchallenge;

import android.text.Editable;
import android.text.TextWatcher;

import java.util.List;
import java.util.Observable;

/**
 * Created by Conrad on 17/08/2017.
 */

public class MainActivityViewModel extends Observable{

    private List<Integer> values;
    private CalculationModel model;

    public MainActivityViewModel(List<Integer> values, CalculationModel model){
        this.values = values;
        this.model = model;
    }

    public void initialise(){
        setChanged();
        notifyObservers(model.doCalculations(values));
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
                    int newValue = 0;
                    if(editable != null && !editable.toString().isEmpty()) {
                        newValue = Integer.parseInt(editable.toString());
                    }
                    values.set(index, newValue);
                    setChanged();
                    notifyObservers(model.doCalculations(values));
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
    }
}