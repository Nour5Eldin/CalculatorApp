package com.noureldin.calculatorapp;


import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;




public class MainActivity extends AppCompatActivity {
    private TextView previousCalculation;
    private EditText display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCalculation = findViewById(R.id.previousCalculationView);
        display = findViewById(R.id.displayEditText);
        display.setShowSoftInputOnFocus(false);

    }
private void updateText(String stringToAdd) {

    if (display.getText().toString().length() <15){
        String Text = display.getText().toString();
        int numbers = display.getSelectionStart();
        String LHS = Text.substring(0,numbers);
        String RHS = Text.substring(numbers);


            display.setText(String.format("%s%s%s",LHS,stringToAdd,RHS));
            display.setSelection(numbers + stringToAdd.length());



    }

}



    public void zeroButton(View view){
        updateText("");
        updateText(getResources().getString(R.string.zeroText));

    }
    public void oneButton(View view){
        updateText(getResources().getString(R.string.oneText));
    }
    public void twoButton(View view){
        updateText(getResources().getString(R.string.twoText));
    }
    public void threeButton(View view){
        updateText(getResources().getString(R.string.threeText));
    }
    public void fourButton(View view){
        updateText(getResources().getString(R.string.fourText));
    }
    public void fiveButton(View view){
        updateText(getResources().getString(R.string.fiveText));
    }
    public void sixButton(View view){
        updateText(getResources().getString(R.string.sixText));
    }
    public void sevenButton(View view){
        updateText(getResources().getString(R.string.sevenText));
    }
    public void eightButton(View view){
        updateText(getResources().getString(R.string.eightText));
    }
    public void nineButton(View view){
        updateText(getResources().getString(R.string.nineText));
    }
    public void clearButton(View view){
        display.setText("");
        previousCalculation.setText("");
    }
    public void backspaceButton(View view){
        int numbers = display.getSelectionStart();
        int textLen = display.getText().length();

        if (numbers != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(numbers-1, numbers, "");
            display.setText(selection);
            display.setSelection(numbers-1);
        }
    }
     //operators
    public void divideButton(View view){
        if (display.getText().toString().isEmpty()){

            return;
        }     updateText(getResources().getString(R.string.divideText));

    }
    public void multiplyButton(View view){
        if (display.getText().toString().isEmpty()) {
            // If EditText is empty, do nothing
            return;
        }
        updateText(getResources().getString(R.string.multiplyText));
    }
    public void subtractButton(View view){
        if (display.getText().toString().isEmpty()){

            return;
        }
        updateText(getResources().getString(R.string.subtractText));
    }
    public void addButton(View view){
        if (display.getText().toString().isEmpty()){

            return;
        }
        updateText(getResources().getString(R.string.addText));

     //Equals
    }
    public void equalButton(View view) {

        String userExp = display.getText().toString();

        previousCalculation.setText(userExp);

        userExp = userExp.replaceAll(getResources().getString(R.string.divideText), "/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiplyText), "*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());

    }
    public void decimalButton(View view) {
          updateText(getResources().getString(R.string.decimalText));





    }
    public void parButton(View view){
        int numbers= display.getSelectionStart();
        int openPar = 0;
        int closePar =0;
        int textLen = display.getText().length();
        for (int i =0; i <numbers; i++){
            if (display.getText().toString().substring(i,i+1).equals("(")){
                openPar+= 1;
            }
            if (display.getText().toString().substring(i,i+1).equals(")")){
                closePar+= 1;
            }
        }
        if (openPar == closePar || display.getText().toString().substring(textLen-1,textLen).equals("(")){
            updateText("(");
        }
        else if (closePar < openPar &&  !display.getText().toString().substring(textLen-1,textLen).equals("(")){
            updateText(")");
        }
        display.setSelection(numbers + 1);
        //updateText(getResources().getString(R.string.parenthesesText));
    }
    public void Module(View view){
        updateText(getResources().getString(R.string.Module));
    }

    public void SinButton(View view){
        updateText("sin(");
    }

    public void CosButton(View view){
        updateText("cos(");
    }

    public void TanButton(View view){
        updateText("tan(");
    }

    public void ArcSinButton(View view){
        updateText("arcSin(");
    }

    public void ArcCosButton(View view){
        updateText("arcCos(");
    }

    public void ArcTanButton(View view){
        updateText("arcTan(");
    }

    public void naturalLogButton(View view){
        updateText("ln(");
    }

    public void logButton(View view){
        updateText("log(");
    }

    public void sqrtButton(View view){
        updateText("sqrt(");
    }

    public void absButton(View view){
        updateText("abs(");
    }

    public void piButton(View view){
        updateText("pi");
    }

    public void eButton(View view){
        updateText("e");
    }

    public void xSquaredButton(View view){
        updateText("^(2)");
    }

    public void xPowerYButton(View view){
        updateText("^(");
    }

    public void primeButton(View view){
        updateText("isPr(");
    }



}