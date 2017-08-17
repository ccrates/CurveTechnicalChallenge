package com.conradcrates.curvetechnicalchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer{

    private MainActivityViewModel viewModel;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridLayout layout = (GridLayout)findViewById(R.id.layout_grid);
        result = (TextView)findViewById(R.id.text_sum);

        List<Double> values = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            values.add(0d);
        }

        viewModel = new MainActivityViewModel(values, new SumModel());
        viewModel.addObserver(this);

        for(int i = 0; i < values.size(); i++){
            EditText et = new EditText(this);
            et.setInputType(InputType.TYPE_CLASS_NUMBER);
            et.addTextChangedListener(viewModel.getTextWatcher(i));

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.height = GridLayout.LayoutParams.WRAP_CONTENT;
            params.width = 500;
            et.setLayoutParams(params);
            layout.addView(et);
        }
    }

    @Override
    public void update(Observable observable, Object o) {
        if(observable instanceof MainActivityViewModel) {
            result.setText(o.toString());
        }
    }
}