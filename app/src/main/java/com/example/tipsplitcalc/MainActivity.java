package com.example.tipsplitcalc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.math.*;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {
    private EditText billTotal;
    private EditText numPeople;
    private TextView tipAmount;
    private TextView totalWTip;
    private TextView totalPerPerson;
    private TextView overage;
    private RadioGroup radioGroup1;
    private double total;
    private Button Go;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        billTotal = findViewById(R.id.billTotal);
        numPeople = findViewById(R.id.numPeople);
        tipAmount = findViewById(R.id.tipAmount);
        totalWTip = findViewById(R.id.totalWTip);
        totalPerPerson = findViewById(R.id.totalPerPerson);
        overage = findViewById(R.id.overage);
        radioGroup1 = findViewById(R.id.radioGroup1);

    }

    public void radioClicked(View v){
        if(billTotal.getText().toString().matches("")){
            radioGroup1.clearCheck();
            return;
        }
        double x = Double.parseDouble(billTotal.getText().toString());
        if(v.getId() == R.id.option1){
             double y = x * .12;
             total = y+x;
            tipAmount.setText("$"+ String.format("%.2f",y));
            totalWTip.setText("$"+ String.format("%.2f",total));
        } else if(v.getId() == R.id.option2){
            double y = x * .15;
            total = y+x;
            tipAmount.setText("$"+ String.format("%.2f",y));
            totalWTip.setText("$"+ String.format("%.2f",total));

        } else if(v.getId() == R.id.option3){
            double y = x * .18;
            total = y+x;
            tipAmount.setText("$"+ String.format("%.2f",y));
            totalWTip.setText("$"+ String.format("%.2f",total));

        } else if(v.getId() == R.id.option4){
            double y = x * .20;
            total = y+x;
            tipAmount.setText("$"+ String.format("%.2f",y));
            totalWTip.setText("$"+ String.format("%.2f",total));

        }
    } // take total with you :)

    public void buttonClicked(View v){
        if(numPeople.getText().toString().matches("")){
            return;
        }
        if(numPeople.getText().toString().matches("0")){
            totalPerPerson.setText("$"+ String.format("%.2f",total));
            overage.setText("$0.00");
        }
        double x = Double.parseDouble(numPeople.getText().toString());
        double perPerson = (total/x);
        double y =Math.ceil(perPerson*100)/100;
        double over = (y*x) - total;
        totalPerPerson.setText("$"+ String.format("%.2f",y));
        overage.setText("$"+ String.format("%.2f",over));



    }

    public void buttonClicked2(View v){
        radioGroup1.clearCheck();
        totalPerPerson.setText("$0.00");
        overage.setText("$0.00");
        totalWTip.setText("$0.00");
        tipAmount.setText("$0.00");
        total = 0.0;
        billTotal.getText().clear();
        numPeople.getText().clear();


    }
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("TIP", tipAmount.getText().toString());
        outState.putString("TotalT", totalWTip.getText().toString());
        outState.putString("TotalP", totalPerPerson.getText().toString());
        outState.putString("OVER", overage.getText().toString());
        outState.putDouble("Total", total);


        // Call super last
        super.onSaveInstanceState(outState);
    }

    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        // Call super first
        super.onRestoreInstanceState(savedInstanceState);
        tipAmount.setText(savedInstanceState.getString("TIP"));
        totalWTip.setText(savedInstanceState.getString("TotalT"));
        totalPerPerson.setText(savedInstanceState.getString("TotalP"));
        overage.setText(savedInstanceState.getString("OVER"));
        total = savedInstanceState.getDouble("Total");
    }

}