package com.example.nguyennam.financialmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by NguyenNam on 1/7/2017.
 */

public class Calculator extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_DATA = "EXTRA_DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        Button btn0 = (Button) findViewById(R.id.btnKey0);
        btn0.setOnClickListener(this);

        Button btnPhay = (Button) findViewById(R.id.btnKeyDot);
        btnPhay.setOnClickListener(this);

        Button btn30 = (Button) findViewById(R.id.btnKey000);
        btn30.setOnClickListener(this);

        Button btnBang = (Button) findViewById(R.id.btnKeyEqual);
        btnBang.setOnClickListener(this);

        Button btn1 = (Button) findViewById(R.id.btnKey1);
        btn1.setOnClickListener(this);

        Button btn2 = (Button) findViewById(R.id.btnKey2);
        btn2.setOnClickListener(this);

        Button btn3 = (Button) findViewById(R.id.btnKey3);
        btn3.setOnClickListener(this);

        Button btn4 = (Button) findViewById(R.id.btnKey4);
        btn4.setOnClickListener(this);

        Button btn5 = (Button) findViewById(R.id.btnKey5);
        btn5.setOnClickListener(this);

        Button btn6 = (Button) findViewById(R.id.btnKey6);
        btn6.setOnClickListener(this);

        Button btnTru = (Button) findViewById(R.id.btnKeyMinus);
        btnTru.setOnClickListener(this);

        Button btn7 = (Button) findViewById(R.id.btnKey7);
        btn7.setOnClickListener(this);

        Button btn8 = (Button) findViewById(R.id.btnKey8);
        btn8.setOnClickListener(this);

        Button btn9 = (Button) findViewById(R.id.btnKey9);
        btn9.setOnClickListener(this);

        Button btnPlus = (Button) findViewById(R.id.btnKeyPlus);
        btnPlus.setOnClickListener(this);

        Button btnC = (Button) findViewById(R.id.btnKeyC);
        btnC.setOnClickListener(this);

        Button btnMulti = (Button) findViewById(R.id.btnKeyMulti);
        btnMulti.setOnClickListener(this);

        Button btnDivide = (Button) findViewById(R.id.btnKeyDivide);
        btnDivide.setOnClickListener(this);

        ImageButton btnBack = (ImageButton) findViewById(R.id.btnKeyBack);
        btnBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        EditText edtTinh = (EditText) findViewById(R.id.edtDisplay);
        Button btnChangeBang = (Button) findViewById(R.id.btnKeyEqual);
        String text;
        String xong = "OK";
        String bang = "=";

        switch (v.getId()){
            case R.id.btnKey0:
                text = edtTinh.getText().toString() + "0";
                edtTinh.setText(text);
                break;

            case R.id.btnKey1:
                text = edtTinh.getText().toString() + "1";
                edtTinh.setText(text);
                break;

            case R.id.btnKey2:
                text = edtTinh.getText().toString() + "2";
                edtTinh.setText(text);
                break;

            case R.id.btnKey3:
                text = edtTinh.getText().toString() + "3";
                edtTinh.setText(text);
                break;

            case R.id.btnKey4:
                text = edtTinh.getText().toString() + "4";
                edtTinh.setText(text);
                break;

            case R.id.btnKey5:
                text = edtTinh.getText().toString() + "5";
                edtTinh.setText(text);
                break;

            case R.id.btnKey6:
                text = edtTinh.getText().toString() + "6";
                edtTinh.setText(text);
                break;

            case R.id.btnKey7:
                text = edtTinh.getText().toString() + "7";
                edtTinh.setText(text);
                break;

            case R.id.btnKey8:
                text = edtTinh.getText().toString() + "8";
                edtTinh.setText(text);
                break;

            case R.id.btnKey9:
                text = edtTinh.getText().toString() + "9";
                edtTinh.setText(text);
                break;

            case R.id.btnKey000:
                text = edtTinh.getText().toString() + "000";
                edtTinh.setText(text);
                break;

            case R.id.btnKeyDot:
                text = edtTinh.getText().toString() + ".";
                edtTinh.setText(text);
                break;

            case R.id.btnKeyC:
                edtTinh.setText("");
                break;

            case R.id.btnKeyBack:
                edtTinh.setText(catKyTuCuoi(String.valueOf(edtTinh.getText())));
                break;

            case R.id.btnKeyPlus:
                text = edtTinh.getText().toString() + "+";
                edtTinh.setText(text);
                break;

            case R.id.btnKeyMinus:
                text = edtTinh.getText().toString() + "-";
                edtTinh.setText(text);
                break;

            case R.id.btnKeyMulti:
                text = edtTinh.getText().toString() + "*";
                edtTinh.setText(text);
                break;

            case R.id.btnKeyDivide:
                text = edtTinh.getText().toString() + "/";
                edtTinh.setText(text);
                break;

            case R.id.btnKeyEqual:
                if (btnChangeBang.getText().toString().equals("=")){
                    String result = Double.toString((double)Math.round(eval(String.valueOf(edtTinh.getText()))*10)/10);
                    String s;
                    //cat .0
                    for (int i=0; i<result.length(); i++){
                        if(".".equals(String.valueOf(result.charAt(i)))){
                            s = result.substring(i+1,result.length());
                            if("0".equals(s)) {
                                result = result.substring(0, i);
                            }
                        }
                    }

                    btnChangeBang.setText(xong);
                    edtTinh.setText(result);
                }else {
                    final Intent data = new Intent();
                    String str = String.valueOf(edtTinh.getText());
                    data.putExtra(EXTRA_DATA, str);
                    setResult(RESULT_OK, data);
                    finish();
                }

                break;
        }
        //doi phim = thanh chu xong
        String curText = String.valueOf(edtTinh.getText());
        if ((!curText.contains("+"))&&(!curText.contains("-"))&&(!curText.contains("*"))&&(!curText.contains("/"))){
            btnChangeBang.setText(xong);

        } else {
            btnChangeBang.setText(bang);
        }
        edtTinh.setSelection(edtTinh.length()); //set cursor cuoi text

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(RESULT_CANCELED);
    }

    private String catKyTuCuoi(String str) {
        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length()-1);
        }
        return str;
    }

    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x = 0;
                int startPos = this.pos;
                if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                }

//                if (eat('(')) { // parentheses
//                    x = parseExpression();
//                    eat(')');
//                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
//                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
//                    x = Double.parseDouble(str.substring(startPos, this.pos));
//                } else if (ch >= 'a' && ch <= 'z') { // functions
//                    while (ch >= 'a' && ch <= 'z') nextChar();
//                    String func = str.substring(startPos, this.pos);
//                    x = parseFactor();
//                    if (func.equals("sqrt")) x = Math.sqrt(x);
//                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
//                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
//                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
//                    else throw new RuntimeException("Unknown function: " + func);
//                } else {
//                    throw new RuntimeException("Unexpected: " + (char)ch);
//                }
//
//                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}
