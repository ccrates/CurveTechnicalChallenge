package com.conradcrates.curvetechnicalchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridLayout layout = (GridLayout)findViewById(R.id.layout_grid);

        List<Integer> values = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            values.add(0);
        }

        viewModel = new MainActivityViewModel(values, new SumModel());

        for(int i = 0; i < values.size(); i++){
            EditText et = new EditText(this);
            et.setInputType(InputType.TYPE_CLASS_NUMBER);
            et.addTextChangedListener(viewModel.getTextWatcher(i));

            GridLayout.LayoutParams params =new GridLayout.LayoutParams();
            params.height = GridLayout.LayoutParams.WRAP_CONTENT;
            params.width = 500;
            et.setLayoutParams(params);
            layout.addView(et);
        }
    }
}