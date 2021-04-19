package com.example.myapplication11;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText firstNum, secondNum;
    Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9;
    Button plus, minus, multi, div, result, reset;
    String sign;
    String Fn = "", Sn = "";
    Integer reInt;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNum = findViewById(R.id.firstNum);
        secondNum = findViewById(R.id.secondNum);

        num0 = findViewById(R.id.num0);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        num5 = findViewById(R.id.num5);
        num6 = findViewById(R.id.num6);
        num7 = findViewById(R.id.num7);
        num8 = findViewById(R.id.num8);
        num9 = findViewById(R.id.num9);

        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multi = findViewById(R.id.multi);
        div = findViewById(R.id.div);

        result = findViewById(R.id.result);
        reset = findViewById(R.id.reset);

        findViewById(R.id.firstNum).setOnClickListener(click);
        findViewById(R.id.secondNum).setOnClickListener(click);

        findViewById(R.id.num0).setOnClickListener(click);
        findViewById(R.id.num1).setOnClickListener(click);
        findViewById(R.id.num2).setOnClickListener(click);
        findViewById(R.id.num3).setOnClickListener(click);
        findViewById(R.id.num4).setOnClickListener(click);
        findViewById(R.id.num5).setOnClickListener(click);
        findViewById(R.id.num6).setOnClickListener(click);
        findViewById(R.id.num7).setOnClickListener(click);
        findViewById(R.id.num8).setOnClickListener(click);
        findViewById(R.id.num9).setOnClickListener(click);

        findViewById(R.id.plus).setOnClickListener(click);
        findViewById(R.id.minus).setOnClickListener(click);
        findViewById(R.id.multi).setOnClickListener(click);
        findViewById(R.id.div).setOnClickListener(click);

        findViewById(R.id.result).setOnClickListener(click);
        findViewById(R.id.reset).setOnClickListener(click);
        firstNum.setShowSoftInputOnFocus(false);
        secondNum.setShowSoftInputOnFocus(false);
    }
    Button.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.num0:firstNum.setText(firstNum.getText().toString() + 0); break;
                case R.id.num1:firstNum.setText(firstNum.getText().toString() + 1); break;
                case R.id.num2:firstNum.setText(firstNum.getText().toString() + 2); break;
                case R.id.num3:firstNum.setText(firstNum.getText().toString() + 3); break;
                case R.id.num4:firstNum.setText(firstNum.getText().toString() + 4); break;
                case R.id.num5:firstNum.setText(firstNum.getText().toString() + 5); break;
                case R.id.num6:firstNum.setText(firstNum.getText().toString() + 6); break;
                case R.id.num7:firstNum.setText(firstNum.getText().toString() + 7); break;
                case R.id.num8:firstNum.setText(firstNum.getText().toString() + 8); break;
                case R.id.num9:firstNum.setText(firstNum.getText().toString() + 9); break;
            } switch (view.getId()){
                case R.id.plus:
                    Fn = firstNum.getText().toString();
                    if(Fn.isEmpty()){
                        Toast.makeText(getApplicationContext(), "숫자를 먼저 입력해 주세요", Toast.LENGTH_SHORT).show();
                        secondNum.setText("");
                    }else{
                        sign = "+";
                        firstNum.setText("");
                        secondNum.setText(Fn +" "+sign);
                    }
                    break;

                case R.id.minus:
                    Fn = firstNum.getText().toString();
                    if(Fn.isEmpty()){
                        Toast.makeText(getApplicationContext(), "숫자를 먼저 입력해 주세요", Toast.LENGTH_SHORT).show();
                        secondNum.setText("");
                    }else{
                        sign = "-";
                        firstNum.setText("");
                        secondNum.setText(Fn +" "+sign);
                    }
                    break;
                case R.id.multi:
                    Fn = firstNum.getText().toString();
                    if(Fn.isEmpty()){
                        Toast.makeText(getApplicationContext(), "숫자를 먼저 입력해 주세요", Toast.LENGTH_SHORT).show();
                        secondNum.setText("");
                    }else{
                        sign = "*";
                        firstNum.setText("");
                        secondNum.setText(Fn +" "+sign);
                    }
                    break;
                case R.id.div:
                    Fn = firstNum.getText().toString();
                    if(Fn.isEmpty()){
                        Toast.makeText(getApplicationContext(), "숫자를 먼저 입력해 주세요", Toast.LENGTH_SHORT).show();
                        secondNum.setText("");
                    }else{
                        sign = "/";
                        firstNum.setText("");
                        secondNum.setText(Fn +" "+sign);
                    }
                    break;
                case R.id.result:
                    Sn = firstNum.getText().toString();
                    if(Fn.isEmpty()||Sn.isEmpty()){
                        Toast.makeText(getApplicationContext(), "숫자를 입력해 주세요", Toast.LENGTH_SHORT).show();
                        firstNum.setText("");
                        secondNum.setText("");
                    } else{
                        switch (sign){
                            case "+":
                                reInt = Integer.parseInt(Fn) + Integer.parseInt(Sn);
                                secondNum.setText(""+reInt);
                                firstNum.setText("");
                                break;
                            case "-":
                                reInt = Integer.parseInt(Fn) - Integer.parseInt(Sn);
                                secondNum.setText(""+reInt);
                                firstNum.setText("");
                                break;
                            case "*":
                                reInt = Integer.parseInt(Fn) * Integer.parseInt(Sn);
                                secondNum.setText(""+reInt);
                                firstNum.setText("");
                                break;
                            case "/":
                                if (Sn.equals("0")||Fn.equals("0")) {
                                    Toast.makeText(getApplicationContext(), "연산오류입니다.", Toast.LENGTH_SHORT).show();
                                    firstNum.setText("");
                                    secondNum.setText("");
                                } else{
                                    reInt = Integer.parseInt(Fn) / Integer.parseInt(Sn);
                                    secondNum.setText(""+reInt);
                                    firstNum.setText("");
                                    break;
                                }
                        }
                    }
                    break;
                case R.id.reset:
                    firstNum.setText("");
                    secondNum.setText("");
                    Fn = "";
                    Sn = "";
            }
        }
    };
}
