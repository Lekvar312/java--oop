package org.example;

import java.net.SocketOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Double> operands;

    public String menu() {
        System.out.println("=".repeat(10));
        System.out.println("1.) Продовжити");
        System.out.println("2.) Повторити");
        System.out.println("3.) Вихід");
        System.out.println("=".repeat(10));

        String choice = "";

        while (true) {
            try {
                choice = scan.nextLine();
                switch (choice) {

                    case "1":
                    case "2":
                        return choice;
                    case "3":
                        System.exit(0);
                    default:
                        throw new Exception();

                }
            } catch (Exception e) {
                System.out.println("значення введено не коректно");
            }

        }

    }
    public static void main(String[] args) {
        Main main = new Main();
        double result = 0;
        String choice = "";
        double x;

        while (true) {
            operands = new ArrayList<>();
            System.out.println("Введіть перший операнд");
            if(choice.equals("1")){
                x = result;
                operands.add(x);
                System.out.println(result);
            }else {
                x = main.getOperand(true);
            }
            System.out.println("Введіть другий операнд");
            double y = main.getOperand(false);
            result = operands.size() == 1 ? main.getUnaryOperation(x)
                    : main.getBinaryOperation(x,y);
            System.out.println("Ваш результат = " + result);
            scan.nextLine();

            choice = main.menu();

        }
    }
    public double getOperand(boolean isFirst) {
        double operand;
        String inputValue;
        while (true) {
            inputValue = scan.nextLine();
            try {
                if (isFirst) {
                    if(!inputValue.isBlank()){
                        operand = Double.parseDouble(inputValue);
                        operands.add(operand);
                    } else{
                       throw new Exception();
                    }
                }else {
                    if(!inputValue.isBlank()){
                        operand = Double.parseDouble(inputValue);
                        operands.add(operand);
                    } else{
                        operand = 0;
                    }
                }
                return operand;
            } catch (Exception e) {
                System.out.println("Неправильно введений операнд");
            }
        }
    }

    public double getBinaryOperation(double x, double y) {


        double result;

        while (true){
            try {
                System.out.println("Оберіть оператор (+, -, *, /)");
                char operator = scan.next().charAt(0);
                switch (operator) {

                    case '+':
                        result = x + y;
                        break;
                    case '-':
                        result = x - y;
                        break;
                    case '*':
                        result = x * y;
                        break;
                    case '/':
                        if (y == 0) {
                            throw new Exception("Ділення на нуль неможливе");
                        }
                        result = x / y;
                        break;
                    default:
                        throw new Exception("Операції не існує");
                }
              return result;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public double getUnaryOperation(double x) {


        double result;

        while (true){
            try {
                System.out.println("Оберіть оператор (cos, sin, tg, ctg, abs, sqrt)");
                String operator = scan.next();
                switch (operator) {

                    case "cos":
                        result = Math.cos(x);
                        break;
                    case "sin":
                        result = Math.sin(x);
                        break;
                    case "tg":
                        result = Math.tan(x);
                        break;
                    case "ctg":
                        result = 1/Math.tan(x);
                        break;
                    case "abs":
                        result = Math.abs(x);
                        break;
                    case "sqrt":
                        if(x <= 0){
                            throw new Exception("Не можливо взяти корінь");
                        }
                        result = Math.sqrt(x);
                        break;
                    default:
                        throw new Exception("Операції не існує");
                }
                return result;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


}