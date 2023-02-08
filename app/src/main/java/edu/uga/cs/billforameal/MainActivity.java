package edu.uga.cs.billforameal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText totalBill;
    private EditText diners;
    private TextView dividedBill;
    private Button compute10;
    private Button compute15;
    private Button compute18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dividedBill= findViewById(R.id.textView);
        totalBill= findViewById(R.id.editTextNumber);
        diners= findViewById(R.id.editTextNumber2);
        compute10= findViewById(R.id.button);
        compute15= findViewById(R.id.button3);
        compute18= findViewById(R.id.button4);

        compute10.setOnClickListener( new ButtonClickListener10() );
        compute15.setOnClickListener( new ButtonClickListener15() );
        compute18.setOnClickListener( new ButtonClickListener18() );
    }
    private class ButtonClickListener10 implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            double bill;
            int dins;
            double divs;
            try{
                bill = Double.parseDouble(totalBill.getText().toString());
                dins = Integer.parseInt(diners.getText().toString());
            }
            catch(NumberFormatException nfe){
                Toast toast = Toast.makeText( getApplicationContext(),
                        "Enter valid numbers",
                        Toast.LENGTH_SHORT );
                toast.show();
                dividedBill.setText( "$0.00" );
                return;
            }
            if(dins<=0){
                dins=1;
            }

            divs = (bill + bill * 0.10) / dins;
            DecimalFormat dataf = new DecimalFormat( "####0.00" );
            dividedBill.setText("$"+dataf.format(divs));

        }
    }
    private class ButtonClickListener15 implements View.OnClickListener
    {
        @Override
        public void onClick(View v){
        double bill;
        int dins;
        double divs;

            try{
                bill = Double.parseDouble(totalBill.getText().toString());
                dins = Integer.parseInt(diners.getText().toString());
            }
            catch(NumberFormatException nfe){
                Toast toast = Toast.makeText( getApplicationContext(),
                        "Enter valid numbers",
                        Toast.LENGTH_SHORT );
                toast.show();
                dividedBill.setText( "$0.00" );
                return;
            }
            if(dins<=0){
                dins=1;
            }
        divs= (bill+bill*0.15)/dins;
        DecimalFormat dataf = new DecimalFormat( "####0.00" );
        dividedBill.setText("$"+dataf.format(divs));
            }
    }
    private class ButtonClickListener18 implements View.OnClickListener
    {
        @Override
        public void onClick(View v){
            double bill;
            int dins;
            double divs;

            try{
                bill = Double.parseDouble(totalBill.getText().toString());
                dins = Integer.parseInt(diners.getText().toString());
            }
            catch(NumberFormatException nfe){
                Toast toast = Toast.makeText( getApplicationContext(),
                        "Enter valid numbers",
                        Toast.LENGTH_SHORT );
                toast.show();
                dividedBill.setText( "$0.00" );
                return;
            }
            if(dins<=0){
                dins=1;
            }
            divs= (bill+bill*0.18)/dins;
            DecimalFormat dataf = new DecimalFormat( "####0.00" );
            dividedBill.setText("$"+dataf.format(divs));
            }
    }
}