package com.conradcrates.curvetechnicalchallenge;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import com.conradcrates.curvetechnicalchallenge.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private MainActivityViewModel viewModel;
    private TextView result;
    private ArrayList<Integer> values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding =  DataBindingUtil.setContentView(this, R.layout.activity_main);
        GridLayout layout = (GridLayout)findViewById(R.id.layout_grid);
        result = (TextView)findViewById(R.id.text_sum);

        if(savedInstanceState != null && savedInstanceState.containsKey("values")){
            values = savedInstanceState.getIntegerArrayList("values");
        } else {
            values = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                values.add(i);
            }
        }

        viewModel = new MainActivityViewModel(values, new SumModel());
        binding.setViewModel(viewModel);

        for(int i = 0; i < values.size(); i++){
            EditText et = new EditText(this);
            et.setInputType(InputType.TYPE_CLASS_NUMBER);
            et.setText("" + values.get(i));
            et.addTextChangedListener(viewModel.getTextWatcher(i));

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.height = GridLayout.LayoutParams.WRAP_CONTENT;
            params.width = 500;
            et.setLayoutParams(params);
            layout.addView(et);
        }

        viewModel.initialise();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList("values", values);
    }
}