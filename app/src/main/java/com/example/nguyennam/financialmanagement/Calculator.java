package com.example.nguyennam.financialmanagement;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import static android.content.ContentValues.TAG;

/**
 * Created by NguyenNam on 1/7/2017.
 */

public class Calculator extends Fragment implements View.OnClickListener {

    Button btn0;
    Button btnDot;
    Button btn000;
    Button btnEqual;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btnMinus;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnPlus;
    Button btnC;
    Button btnMulti;
    Button btnDivide;
    ImageButton btnBack;
    EditText edtTinh;
    DataPassListener mCallback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (DataPassListener)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement DataPassListener");
        }
    }

    public interface DataPassListener{
        public void passData(String data);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calculator, container, false);

        edtTinh = (EditText) view.findViewById(R.id.edtDisplay);

        btn0 = (Button) view.findViewById(R.id.btnKey0);
        btn0.setOnClickListener(this);

        btnDot = (Button) view.findViewById(R.id.btnKeyDot);
        btnDot.setOnClickListener(this);

        btn000 = (Button) view.findViewById(R.id.btnKey000);
        btn000.setOnClickListener(this);

        btnEqual = (Button) view.findViewById(R.id.btnKeyEqual);
        btnEqual.setOnClickListener(this);

        btn1 = (Button) view.findViewById(R.id.btnKey1);
        btn1.setOnClickListener(this);

        btn2 = (Button) view.findViewById(R.id.btnKey2);
        btn2.setOnClickListener(this);

        btn3 = (Button) view.findViewById(R.id.btnKey3);
        btn3.setOnClickListener(this);

        btn4 = (Button) view.findViewById(R.id.btnKey4);
        btn4.setOnClickListener(this);

        btn5 = (Button) view.findViewById(R.id.btnKey5);
        btn5.setOnClickListener(this);

        btn6 = (Button) view.findViewById(R.id.btnKey6);
        btn6.setOnClickListener(this);

        btnMinus = (Button) view.findViewById(R.id.btnKeyMinus);
        btnMinus.setOnClickListener(this);

        btn7 = (Button) view.findViewById(R.id.btnKey7);
        btn7.setOnClickListener(this);

        btn8 = (Button) view.findViewById(R.id.btnKey8);
        btn8.setOnClickListener(this);

        btn9 = (Button) view.findViewById(R.id.btnKey9);
        btn9.setOnClickListener(this);

        btnPlus = (Button) view.findViewById(R.id.btnKeyPlus);
        btnPlus.setOnClickListener(this);

        btnC = (Button) view.findViewById(R.id.btnKeyC);
        btnC.setOnClickListener(this);

        btnMulti = (Button) view.findViewById(R.id.btnKeyMulti);
        btnMulti.setOnClickListener(this);

        btnDivide = (Button) view.findViewById(R.id.btnKeyDivide);
        btnDivide.setOnClickListener(this);

        btnBack = (ImageButton) view.findViewById(R.id.btnKeyBack);
        btnBack.setOnClickListener(this);
        
        return view;
    }

    @Override
    public void onClick(View v) {
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
                if (btnEqual.getText().toString().equals("=")){
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

                    btnEqual.setText(xong);
                    edtTinh.setText(result);
                }else {
                    String str = String.valueOf(edtTinh.getText());
                    mCallback.passData(str);
//                    Intent intent = new Intent(getActivity().getBaseContext(),
//                            MainActivity.class);
//                    intent.putExtra("message", str);
//                    getActivity().startActivity(intent);

//                    final Intent data = new Intent();
//                    String str = String.valueOf(edtTinh.getText());
//                    data.putExtra(EXTRA_DATA, str);
//                    setResult(RESULT_OK, data);
//                    finish();
                }
                break;
        }
        //doi phim = thanh chu xong
        String curText = String.valueOf(edtTinh.getText());
        if ((!curText.contains("+"))&&(!curText.contains("-"))&&(!curText.contains("*"))&&(!curText.contains("/"))){
            btnEqual.setText(xong);

        } else {
            btnEqual.setText(bang);
        }
        edtTinh.setSelection(edtTinh.length()); //set cursor cuoi text

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
