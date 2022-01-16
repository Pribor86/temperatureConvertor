package com.example.temperatureconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText text;
    private TextView result;
    RadioButton celsiusButton;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.inputTemp);
        result = findViewById(R.id.result);
        celsiusButton = findViewById(R.id.radioButton1);
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                String str = text.getText().toString();
                if(str.length() == 0){
                    Toast.makeText(getApplicationContext(), "Enter number", Toast.LENGTH_LONG).show();
                    return;
                }
                double temp = Double.parseDouble(str);
                double x = 0d;
                String resultTemp = "";
                switch (checkedId){
                    case R.id.radioButton1:
                        x = ConvertTemperature.convertFahrenheitToCelsius(temp);
                        resultTemp = "°C";
                        break;
                    case R.id.radioButton2:
                        x = ConvertTemperature.convertCelsiusToFahrenheit(temp);
                        resultTemp = "°F";
                        break;
                }
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String decTemp = decimalFormat.format(x);
                result.setText("Result: " + decTemp + resultTemp);

            }
        });

    }

//    public void calcTemp(View view) {
//        String str = text.getText().toString();
//        if(str.length() == 0){
//            Toast.makeText(this, "Enter number", Toast.LENGTH_LONG).show();
//            return;
//        }
//
//        double tempFromText = Double.parseDouble(str);
//        double x;
//        switch (view.getId()){
//            case R.id.button:
//                //RadioButton celsiusButton = findViewById(R.id.radioButton1);
//                if(celsiusButton.isChecked())
//                   x = ConvertTemperature.convertFahrenheitToCelsius(tempFromText);
//                    else
//                        x = ConvertTemperature.convertCelsiusToFahrenheit(tempFromText);
//                DecimalFormat decimalFormat = new DecimalFormat("#.##");
//                String decTemp = decimalFormat.format(x);
//                text.setText(decTemp);
//                break;
//        }
//    }
}