package com.example.mycalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {
    private TextView button0;
    private TextView button1;
    private TextView button2;
    private TextView button3;
    private TextView button5;
    private TextView button4;
    private TextView button6;
    private TextView button7;
    private TextView button8;
    private TextView button9;
    private TextView valuesTv;
    private TextView resultTv;
    private TextView clearTv;
    private TextView divideTv;
    private TextView multiplyTv;
    private TextView subtractTv;
    private TextView equalsTv;
    private TextView addTv;
    private TextView delTv;
    private TextView decimalPointTv;
    private TextView percentTV;
    private Toast invalidArgument;
    private Set<String> opCodes;
    private static final String VALUE = "values";
    private static final String RESULT = "result";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));




        opCodes = new HashSet<>();
        opCodes.add("+");
        opCodes.add("-");
        opCodes.add("x");
        opCodes.add("÷");
        opCodes.add("%");


        initializeViews();

        if(savedInstanceState != null){

            valuesTv.setText(savedInstanceState.getString(VALUE));
            resultTv.setText(savedInstanceState.getString(RESULT));
        }
        onClickViews();
    }

    private void onClickViews() {
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valuesTv.setText(String.format("%s%s", valuesTv.getText(), getResources().getString(R.string.zero)));
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valuesTv.setText(String.format("%s%s", valuesTv.getText(), getResources().getString(R.string.one)));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valuesTv.setText(String.format("%s%s", valuesTv.getText(), getResources().getString(R.string.two)));
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valuesTv.setText(String.format("%s%s", valuesTv.getText(), getResources().getString(R.string.three)));
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valuesTv.setText(String.format("%s%s", valuesTv.getText(), getResources().getString(R.string.four)));
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valuesTv.setText(String.format("%s%s", valuesTv.getText(), getResources().getString(R.string.five)));
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valuesTv.setText(String.format("%s%s", valuesTv.getText(), getResources().getString(R.string.six)));
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valuesTv.setText(String.format("%s%s", valuesTv.getText(), getResources().getString(R.string.seven)));
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valuesTv.setText(String.format("%s%s", valuesTv.getText(), getResources().getString(R.string.eight)));
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valuesTv.setText(String.format("%s%s", valuesTv.getText(), getResources().getString(R.string.nine)));
            }
        });

        clearTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valuesTv.setText("");
                resultTv.setText("");
            }
        });

        divideTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valuesTv.getText().length() == 0 ||( valuesTv.getText().length()>2 && opCodes.contains(String.valueOf(valuesTv.getText().charAt(valuesTv.length()-2))))) {
                    showInvalidToast();
                } else {
                    valuesTv.setText(String.format("%s%s%s%s", valuesTv.getText(), " ", getResources().getString(R.string.divide), " "));
                }
            }
        });

        multiplyTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (valuesTv.getText().length() == 0 ||( valuesTv.getText().length()>2 && opCodes.contains(String.valueOf(valuesTv.getText().charAt(valuesTv.length()-2))))) {
                    showInvalidToast();
                } else {
                    valuesTv.setText(String.format("%s%s%s%s", valuesTv.getText(), " ", getResources().getString(R.string.multiply), " "));
                }
            }
        });

        addTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valuesTv.getText().length() == 0 ||( valuesTv.getText().length()>2 && opCodes.contains(String.valueOf(valuesTv.getText().charAt(valuesTv.length()-2))))) {
                    showInvalidToast();
                } else {
                    valuesTv.setText(String.format("%s%s%s%s", valuesTv.getText(), " ", getResources().getString(R.string.add), " "));
                }
            }
        });

        subtractTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valuesTv.getText().length() == 0 ||( valuesTv.getText().length()>2 && opCodes.contains(String.valueOf(valuesTv.getText().charAt(valuesTv.length()-2))))) {
                    showInvalidToast();
                } else {
                    valuesTv.setText(String.format("%s%s%s%s", valuesTv.getText(), " ", getResources().getString(R.string.subtract), " "));
                }
            }
        });

        decimalPointTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valuesTv.getText().length() == 0) {
                    valuesTv.setText(String.format("%s%s", getResources().getString(R.string.zero), getResources().getString(R.string.point)));
                } else {
                    valuesTv.setText(String.format("%s%s", valuesTv.getText(), getResources().getString(R.string.point)));
                }
            }
        });

        percentTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (valuesTv.getText().length() == 0 ||( valuesTv.getText().length()>2 && opCodes.contains(String.valueOf(valuesTv.getText().charAt(valuesTv.length()-2))))) {
                    showInvalidToast();
                } else {
                    valuesTv.setText(String.format("%s%s%s%s", valuesTv.getText(), " ", getResources().getString(R.string.percent), " "));
                }

            }
        });

        delTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valuesString = valuesTv.getText().toString();
                if (valuesString.length() != 0) {
                    String m = valuesString.substring(0, (valuesString.length() - 1));
                    if (m.length()-1 >0 && opCodes.contains(String.valueOf(m.charAt(m.length() - 1)))) {
                        valuesTv.setText(valuesString.substring(0, (valuesString.length() - 3)));


                    }  else {
                        valuesTv.setText(m);
                    }

                }
            }
        });



        equalsTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String statement = valuesTv.getText().toString();
                opCodes.remove("%");
                if (statement.length() >2 && !opCodes.contains(String.valueOf(statement.charAt(statement.length()-2)))) {

                    if(Calculator.processSuccesful(statement)) {
                        resultTv.setText(Calculator.getResult());
                    }
                    else {
                        showInvalidToast();
                    }
                }
                else {
                    showInvalidToast();
                }
            }
        });
    }

    private void showInvalidToast() {
        if (invalidArgument != null) {
            invalidArgument.cancel();
        }

        invalidArgument = Toast.makeText(this, "Bad Expression", Toast.LENGTH_SHORT);
        invalidArgument.show();
    }

    private void initializeViews() {
        button0 = findViewById(R.id.zero);
        button1 = findViewById(R.id.one);
        button2 = findViewById(R.id.two);
        button3 = findViewById(R.id.three);
        button4 = findViewById(R.id.four);
        button5 = findViewById(R.id.five);
        button6 = findViewById(R.id.six);
        button7 = findViewById(R.id.seven);
        button8 = findViewById(R.id.eight);
        button9 = findViewById(R.id.nine);
        valuesTv = findViewById(R.id.values_tv);
        resultTv = findViewById(R.id.result_tv);
        clearTv = findViewById(R.id.clear_tv);
        divideTv = findViewById(R.id.divide_tv);
        multiplyTv = findViewById(R.id.multiply_tv);
        subtractTv = findViewById(R.id.subtract_tv);
        equalsTv = findViewById(R.id.equals_tv);
        addTv = findViewById(R.id.add_tv);
        delTv = findViewById(R.id.delete_tv);
        decimalPointTv = findViewById(R.id.point_tv);
        percentTV = findViewById(R.id.percent_tv);

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(VALUE, valuesTv.getText().toString());
        outState.putString(RESULT, resultTv.getText().toString());
    }

}
