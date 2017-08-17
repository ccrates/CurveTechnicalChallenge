package com.conradcrates.curvetechnicalchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout layout = (GridLayout)findViewById(R.id.layout_grid);
        for(int i = 0; i < 6; i++){
            EditText et = new EditText(this);
            et.setInputType(InputType.TYPE_CLASS_NUMBER);

            GridLayout.LayoutParams params =new GridLayout.LayoutParams();
            params.height = GridLayout.LayoutParams.WRAP_CONTENT;
            params.width = 500;
            et.setLayoutParams(params);
            layout.addView(et);
        }
    }
}
