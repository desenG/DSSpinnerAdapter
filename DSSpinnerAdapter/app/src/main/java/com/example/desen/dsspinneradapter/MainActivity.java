package com.example.desen.dsspinneradapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CustomSpinner mSpinner;
    private DSSpinnerAdapter mAdapter;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        mSpinner = (CustomSpinner) findViewById(R.id.sensor_param_limit_spinner);

        ArrayList<ParameterThreshold> thresholds = new ArrayList<>();
        ParameterThreshold data1Item = new ParameterThreshold();
        data1Item.setName("xxx");
        data1Item.setUuid("nothinghere");
        data1Item.setTempLimitLower(25.0);
        data1Item.setStrengthLimit(25.0);

        ParameterThreshold data2Item = new ParameterThreshold();
        data2Item.setName("yyy");
        data2Item.setUuid("nothinghere");
        data1Item.setTempLimitLower(26.0);
        data1Item.setStrengthLimit(30.0);

        thresholds.add(data1Item);
        thresholds.add(data2Item);

        DSButton clearButton = new DSButton(this);
        clearButton.setText("Clear");
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DSAlert.showSimpleTextDialog(context,"hello","clear click");
                mSpinner.setSelection(mAdapter.getCount(),false);
                mSpinner.onDetachedFromWindow();
            }
        });
        mAdapter = new DSSpinnerAdapter(this,
                R.layout.custom_spinner_content,
                thresholds,"select a value", Arrays.asList(clearButton));

        mSpinner.setAdapter(mAdapter);

        mSpinner.setSelection(mAdapter.getCount(),false);
    }
}
