package com.conradcrates.curvetechnicalchallenge;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.text.TextWatcher;

import java.util.List;

/**
 * Created by Conrad on 17/08/2017.
 */

public class MainActivityViewModel extends BaseObservable{

    private List<Integer> values;
    private CalculationModel model;
    private int result;

    public MainActivityViewModel(List<Integer> values, CalculationModel model){
        this.values = values;
        this.model = model;
    }

    public void initialise(){
        setResult(model.doCalculations(values));
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
                    setResult(model.doCalculations(values));
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
    }

    public void setResult(int result) {
        this.result = result;
        notifyPropertyChanged(BR.result);
    }

    @Bindable
    public String getResult(){
        return "" + result;
    }
}