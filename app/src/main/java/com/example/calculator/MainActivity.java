package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView inputText, resultText;

    private String input, result, newResult;

    private Button button0, button1, button2, button3, button4, button5, button6, button7,
            button8, button9, add, subtract, multiply, division, dot, percent, power,equal, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.input_text);
        resultText = findViewById(R.id.output_text);

        button0 = findViewById(R.id.button_0);
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);
        button5 = findViewById(R.id.button_5);
        button6 = findViewById(R.id.button_6);
        button7 = findViewById(R.id.button_7);
        button8 = findViewById(R.id.button_8);
        button9 = findViewById(R.id.button_9);
        add = findViewById(R.id.plus);
        subtract = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        division = findViewById(R.id.divide);
        dot = findViewById(R.id.button_dot);
        equal = findViewById(R.id.button_equal);
        power = findViewById(R.id.button_power);
        percent = findViewById(R.id.button_percent);
        clear = findViewById(R.id.button_clear);

    }

    public void onButtonClicked(View view) {

        Button btn = (Button) view;
        String data = btn.getText().toString();
        switch (data) {
            case "C":
                input = null;
                result=null;
                newResult=null;
                resultText.setText("");
                break;

            case "%":
                input += "%";
                double ans = Double.parseDouble(inputText.getText().toString()) / 100;
                result = Double.toString(ans);
                newResult = removeDecimal(result);
                resultText.setText(newResult);
                input = newResult + "";
                break;

            case "÷":
                calculate();
                input += "÷";
                break;

            case "×":
                calculate();
                input += "*";
                break;


            case "=":
                calculate();
                break;


            default:
                if (input == null) {
                    input = "";
                }
                if (data.equals("+") || data.equals("-") || data.equals("^")) {
                    calculate();
                }
                input += data;
        }
        inputText.setText(input);
    }

    private void calculate() {
        if (input.split("\\+").length == 2) {
            String num[] = input.split("\\+");
            try {
                double ans = Double.parseDouble(num[0]) + Double.parseDouble(num[1]);
                result = Double.toString(ans);
                newResult = removeDecimal(result);
                resultText.setText(newResult);
                input = newResult +"";
            }catch (Exception e) {
                resultText.setText(e.getMessage().toString());
            }
        }
        if (input.split("\\-").length == 2) {
            String num[] = input.split("\\-");
            try {
                if (Double.parseDouble(num[0]) < Double.parseDouble(num[1])) {
                    double ans = Double.parseDouble(num[1]) - Double.parseDouble(num[0]);
                    result = Double.toString(ans);
                    newResult = removeDecimal(result);
                    resultText.setText("-" + newResult);
                    input = "-" + newResult + "";
                } else {
                    double ans = Double.parseDouble(num[0]) - Double.parseDouble(num[1]);
                    result = Double.toString(ans);
                    newResult = removeDecimal(result);
                    resultText.setText(newResult);
                    input = newResult + "";
                }
            } catch (Exception e) {
                resultText.setText(e.getMessage().toString());
            }
        }
        if (input.split("\\*").length == 2) {
            String num[] = input.split("\\*");
            try {
                double ans = Double.parseDouble(num[0]) * Double.parseDouble(num[1]);
                result = Double.toString(ans);
                newResult = removeDecimal(result);
                resultText.setText(newResult);
                input = newResult +"";
            }catch (Exception e){
                resultText.setText(e.getMessage().toString());
            }
        }
        if (input.split("\\÷").length == 2) {
            String num[] = input.split("\\÷");
            try {
                double ans = Double.parseDouble(num[0]) / Double.parseDouble(num[1]);
                result = Double.toString(ans);
                newResult = removeDecimal(result);
                resultText.setText(newResult);
                input = newResult +"";
            }catch (Exception e){
                resultText.setText(e.getMessage().toString());
            }
        }
        if (input.split("\\^").length == 2) {
            String num[] = input.split("\\^");
            try {
                double ans = Math.pow(Double.parseDouble(num[0]), Double.parseDouble(num[1]));
               result = Double.toString(ans);
               newResult = removeDecimal(result);
               resultText.setText(newResult);
                input = newResult +"";
            }catch (Exception e){
                resultText.setText(e.getMessage().toString());
            }
        }
    }
    private String removeDecimal(String number){
        String n [] = number.split("\\.");
        if (n.length >1){
            if (n[1].equals("0")){
                number = n[0];
            }
        }
        return number;
    }
}
