package com.archit.inchestometers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText editTextInches;
    private Button convertButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setUpConvertButton();
    }

    private void findViews() {
        editTextInches=findViewById(R.id.inchesEditTextId);
        convertButton=findViewById(R.id.convertButtonId);
        resultText=findViewById(R.id.resultTextViewId);
    }
    private void setUpConvertButton() {
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextInches.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please input a value.", Toast.LENGTH_LONG).show();
                }else{
                    double result=convertToMeters();
                    displayResult(result);
                }

            }
        });
    }

    private double convertToMeters() {
        String inchesEntered=editTextInches.getText().toString();
        return Integer.parseInt(inchesEntered) * 0.0254;
    }
    private void displayResult(double result) {
        DecimalFormat a=new DecimalFormat("0.00");
        String resultRoundOff=a.format(result);
        String finalResult= editTextInches.getText().toString() + " inches is equal to "+resultRoundOff+" meters.";
        resultText.setText(finalResult);
    }
}