package com.example.mycalculator;

import java.text.DecimalFormat;
import java.util.ArrayList;

class Calculator {

    private static final char ADD_SYMBOL = '+';
    private static final char SUBTRACT_SYMBOL = '-';
    private static final char MULTIPLY_SYMBOL = 'x';
    private static final char DIVIDE_SYMBOL = '÷';
    private static final char PERCENT_SYMBOL= '%';
    private static ArrayList<Double> numbers;
    private static ArrayList<Character> operators;
    private static double result;
    private static final DecimalFormat dm = new DecimalFormat("#.####");

    static String getResult() {

        return dm.format(result);
    }

    static boolean processSuccesful(String statement) {
        numbers = new ArrayList<>();
        operators = new ArrayList<>();

        String[] splittedStatement = statement.split(" ");

        if(splittedStatement.length==1){
            result = Double.parseDouble(splittedStatement[0]);
        }

        try {
            for (String arg : splittedStatement
            ) {

                if (isNumeric(arg)) {
                    Double number = Double.parseDouble(arg);

                    numbers.add(number);

                } else if (arg.length()== 1 & !isNumeric(arg)){
                    Character character = arg.charAt(0);
                    operators.add(character);
                }

            }

            calculate();
        } catch (NumberFormatException e) {
            return false;
        }

        return true;


    }

    private static void calculate(){

        if(operators.get(0)== PERCENT_SYMBOL){
            execute(operators.get(0), numbers.get(0),1.0);
        }
        
        else {


            for (int i = 0; i < (numbers.size() - 1); i++) {

                Double firstValue = numbers.get(i);
                Double secondValue = numbers.get(i + 1);
                Character opCode = operators.get(i);

                execute(opCode, firstValue, secondValue);
                numbers.set((i + 1), result);
            }
        }

    }

    private static void execute(Character opCode, Double leftValue, Double rightValue){
        switch (opCode) {
            case ADD_SYMBOL:
                result = leftValue + rightValue;
                break;
            case SUBTRACT_SYMBOL:
                result = leftValue - rightValue;
                break;
            case DIVIDE_SYMBOL:
                result = rightValue != 0 ? leftValue / rightValue : 0.0d;
                break;
            case MULTIPLY_SYMBOL:
                result = leftValue * rightValue;
                break;
            case PERCENT_SYMBOL:
                result = (leftValue)/100;
                break;
        }

    }

    private static boolean isNumeric(String strNumb) {
        if (strNumb == null) {
            return false;
        }

        try {
            //noinspection unused
            double d = Double.parseDouble(strNumb);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }


}
