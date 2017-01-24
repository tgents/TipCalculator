package edu.uw.tgents.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // declare our UI elements
    public EditText input;
    public TextView answer;
    public Button ten;
    public Button fifteen;
    public Button twenty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Retrieve them from the content view
        input = (EditText) findViewById(R.id.input);
        answer = (TextView) findViewById(R.id.answer);
        ten = (Button) findViewById(R.id.ten);
        fifteen = (Button) findViewById(R.id.fifteen);
        twenty = (Button) findViewById(R.id.twenty);

        // Set Listeners for our buttons
        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(input.getText().toString());
                answer.setText("Tip: " + (num * .1));
            }
        });
//        ten.setOnClickListener(new MyListener(.1));
        fifteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(input.getText().toString());
                answer.setText("Tip: " + (num * .15));
            }
        });
//        fifteen.setOnClickListener(new MyListener(.15));


        // both setOnClickListeners should work for twenty
        // this demos the custom listener I made
        twenty.setOnClickListener(new MyListener(.2));
        
//        twenty.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int num = Integer.parseInt(input.getText().toString());
//                answer.setText("Tip: " + (num * .2));
//            }
//        });
    }

    // custom listener
    public class MyListener implements View.OnClickListener{
        // specify tip amount
        public double tip;

        // constructor to set tip
        public MyListener(double num){
            tip = num;
        }

        @Override
        public void onClick(View v) {
            int num = Integer.parseInt(input.getText().toString());
            answer.setText("Tip: " + (num * tip));
        }
    }
}
