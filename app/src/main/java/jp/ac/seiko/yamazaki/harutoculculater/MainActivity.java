package jp.ac.seiko.yamazaki.harutoculculater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView editText;
    TextView textView;
    EditText textView2;
    EditText textView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.textView);
        textView = findViewById(R.id.textViewAnswer);
        textView2 = findViewById(R.id.edittext);
        textView3 = findViewById(R.id.edittext2);
        findViewById(R.id.button1).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button2).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button3).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button4).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button5).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button6).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button7).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button8).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button9).setOnClickListener(buttonNumberListener);
        findViewById(R.id.button0).setOnClickListener(buttonNumberListener);
        findViewById(R.id.buttontasu).setOnClickListener(buttonOperatorListener);
        findViewById(R.id.buttonhiku).setOnClickListener(buttonOperatorListener);
        findViewById(R.id.buttonkakeru).setOnClickListener(buttonOperatorListener);
        findViewById(R.id.perpush).setOnClickListener(buttonOperatorListener);
        findViewById(R.id.buttonwa).setOnClickListener(buttonOperatorListener);
        findViewById(R.id.Cpush).setOnClickListener(buttonListener);

    }
    boolean isOperatorKeyPushed = true;
    double calc(int operator, double value1, double value2) {
        switch (operator) {
            case R.id.buttontasu:
                return value1 + value2;
            case R.id.buttonhiku:
                return value1 - value2;
            case R.id.buttonkakeru:
                return value1 * value2;
            case R.id.perpush:
                return value1 / value2;
            default:
                return value1;
        }
    }
    View.OnClickListener buttonNumberListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button button = (Button) view;

            if (isOperatorKeyPushed == true) {
                textView2.setText(button.getText());
                editText.append(button.getText());

            } else {
                textView2.append(button.getText());
                editText.append(button.getText());
            }

            isOperatorKeyPushed = false;
        }
    };

    int recentOperator = R.id.buttonwa;
    double result;


    View.OnClickListener buttonOperatorListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button operatorButton = (Button) view;
            double value = Double.parseDouble(textView2.getText().toString());
            if (recentOperator == R.id.buttonwa) {
                result = value;
            } else if (recentOperator == R.id.perpush){
                if(result % value == 0){
                    result = calc(recentOperator, result, value);
                    textView.setText(String.valueOf((int) result));
                }else{
                result = calc(recentOperator, result, value);
                textView.setText(String.valueOf(result));}
            }else {
                result = calc(recentOperator, result, value);
                textView.setText(String.valueOf((int) result));
            }

            recentOperator = operatorButton.getId();
            editText.append(operatorButton.getText());
            isOperatorKeyPushed = true;
        }
    };
    View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            recentOperator = R.id.buttonwa;
            result = 0;
            isOperatorKeyPushed = false;

            textView.setText("");
            editText.setText("");
            textView2.setText("");
        }
    };


}