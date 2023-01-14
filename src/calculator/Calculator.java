package calculator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Calculator extends JFrame {
    private static final int WINDOW_WIDTH = 420;
    private static final int WINDOW_HEIGHT = 500;
    static Double[] stack = new Double[500];
    static String[] strs;
    static boolean isOperatorEndFlag = false;
    static boolean isZeroDivisionFlag = false;
    static boolean flag = false;
    static boolean squareFlag = false;
    static int numberOfLeftBrackets = 0;
    static int numberOfRightBrackets = 0;

    public Calculator() {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH - 115, WINDOW_HEIGHT - 30);
        setLocationRelativeTo(null);
        initComponents();
        setLayout(null);
        setVisible(true);
    }

    private void initComponents() {
        JLabel ResultLabel = new JLabel();
        ResultLabel.setName("ResultLabel");
        ResultLabel.setBounds(10, 20, 230, 50);
        ResultLabel.setText("0");
        ResultLabel.setFont(new Font("Roboto", Font.BOLD, 50));
        ResultLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        add(ResultLabel);

        JLabel EquationLabel = new JLabel();
        EquationLabel.setName("EquationLabel");
        EquationLabel.setBounds(10, 90, 230, 15);
        EquationLabel.setFont(new Font("Roboto", Font.BOLD, 15));
        EquationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        EquationLabel.setForeground(Color.GREEN);
        add(EquationLabel);


        JButton Zero = new JButton("0");
        Zero.setName("Zero");
        Zero.setBackground(Color.WHITE);
        Zero.setBorder(null);
        JButton One = new JButton("1");
        One.setName("One");
        One.setBackground(Color.WHITE);
        One.setBorder(null);
        JButton Two = new JButton("2");
        Two.setName("Two");
        Two.setBackground(Color.WHITE);
        Two.setBorder(null);
        JButton Three = new JButton("3");
        Three.setName("Three");
        Three.setBackground(Color.WHITE);
        Three.setBorder(null);
        JButton Four = new JButton("4");
        Four.setName("Four");
        Four.setBackground(Color.WHITE);
        Four.setBorder(null);
        JButton Five = new JButton("5");
        Five.setName("Five");
        Five.setBackground(Color.WHITE);
        Five.setBorder(null);
        JButton Six = new JButton("6");
        Six.setName("Six");
        Six.setBackground(Color.WHITE);
        Six.setBorder(null);
        JButton Seven = new JButton("7");
        Seven.setName("Seven");
        Seven.setBackground(Color.WHITE);
        Seven.setBorder(null);
        JButton Eight = new JButton("8");
        Eight.setName("Eight");
        Eight.setBackground(Color.WHITE);
        Eight.setBorder(null);
        JButton Nine = new JButton("9");
        Nine.setName("Nine");
        Nine.setBackground(Color.WHITE);
        Nine.setBorder(null);
        JButton Divide = new JButton("\u00F7");
        Divide.setName("Divide");
        Divide.setBackground(Color.lightGray);
        Divide.setBorder(null);
        JButton Multiply = new JButton("\u00D7");
        Multiply.setName("Multiply");
        Multiply.setBackground(Color.lightGray);
        Multiply.setBorder(null);
        JButton Add = new JButton("\u002B");
        Add.setName("Add");
        Add.setBackground(Color.lightGray);
        Add.setBorder(null);
        JButton Subtract = new JButton("\u2212");
        Subtract.setName("Subtract");
        Subtract.setBackground(Color.lightGray);
        Subtract.setBorder(null);
        JButton Equals = new JButton("=");
        Equals.setName("Equals");
        Equals.setBackground(Color.CYAN.brighter());
        JButton Clear = new JButton("C");
        Clear.setName("Clear");
        Clear.setBackground(Color.lightGray);
        Clear.setBorder(null);
        JButton Delete = new JButton("Del");
        Delete.setName("Delete");
        Delete.setBackground(Color.lightGray);
        Delete.setBorder(null);
        JButton Dot = new JButton(".");
        Dot.setName("Dot");
        Dot.setBackground(Color.WHITE);
        Dot.setBorder(null);
        JButton Parentheses = new JButton("( )");
        Parentheses.setName("Parentheses");
        Parentheses.setBackground(Color.lightGray);
        Parentheses.setBorder(null);
        JButton SquareRoot = new JButton("\u221A");
        SquareRoot.setName("SquareRoot");
        SquareRoot.setBackground(Color.lightGray);
        SquareRoot.setBorder(null);
        JButton PowerTwo = new JButton("x\u00B2");
        PowerTwo.setName("PowerTwo");
        PowerTwo.setBackground(Color.lightGray);
        PowerTwo.setBorder(null);
        JButton PowerY = new JButton("x\u207F");
        PowerY.setName("PowerY");
        PowerY.setBackground(Color.lightGray);
        PowerY.setBorder(null);
        JButton PlusMinus = new JButton("\u00B1");
        PlusMinus.setName("PlusMinus");
        PlusMinus.setBackground(Color.WHITE);
        PlusMinus.setBorder(null);
        JButton CE = new JButton("CE");
        CE.setName("CE");
        CE.setBackground(Color.lightGray);
        CE.setBorder(null);

        One.setBounds(30, 280, WINDOW_WIDTH - 365, 35);
        Two.setBounds(90, 280, WINDOW_WIDTH - 365, 35);
        Three.setBounds(150, 280, WINDOW_WIDTH - 365, 35);
        Four.setBounds(30, 240, WINDOW_WIDTH - 365, 35);
        Five.setBounds(90, 240, WINDOW_WIDTH - 365, 35);
        Six.setBounds(150, 240, WINDOW_WIDTH - 365, 35);
        Seven.setBounds(30, 200, WINDOW_WIDTH - 365, 35);
        Eight.setBounds(90, 200, WINDOW_WIDTH - 365, 35);
        Nine.setBounds(150, 200, WINDOW_WIDTH - 365, 35);
        Zero.setBounds(90, 320, WINDOW_WIDTH - 365, 35);
        Divide.setBounds(210, 160, WINDOW_WIDTH - 365, 35);
        Multiply.setBounds(210, 200, WINDOW_WIDTH - 365, 35);
        Add.setBounds(210, 280, WINDOW_WIDTH - 365, 35);
        Subtract.setBounds(210, 240, WINDOW_WIDTH - 365, 35);
        Equals.setBounds(210, 320, WINDOW_WIDTH - 365, 35);
        Clear.setBounds(150, 120, WINDOW_WIDTH - 365, 35);
        Delete.setBounds(210, 120, WINDOW_WIDTH - 365, 35);
        Dot.setBounds(150, 320, WINDOW_WIDTH - 365, 35);
        Parentheses.setBounds(30, 120, WINDOW_WIDTH - 365, 35);
        PowerTwo.setBounds(30, 160, WINDOW_WIDTH - 365, 35);
        PowerY.setBounds(90, 160, WINDOW_WIDTH - 365, 35);
        SquareRoot.setBounds(150, 160, WINDOW_WIDTH - 365, 35);
        PlusMinus.setBounds(30, 320, WINDOW_WIDTH - 365, 35);
        CE.setBounds(90, 120, WINDOW_WIDTH - 365, 35);
        add(One);
        add(Two);
        add(Three);
        add(Four);
        add(Five);
        add(Six);
        add(Seven);
        add(Eight);
        add(Nine);
        add(Zero);
        add(Multiply);
        add(Divide);
        add(Add);
        add(Subtract);
        add(Equals);
        add(Clear);
        add(Delete);
        add(Dot);
        add(Parentheses);
        add(SquareRoot);
        add(PowerTwo);
        add(PowerY);
        add(PlusMinus);
        add(CE);

        Zero.addActionListener(e -> {
            EquationLabel.setText(EquationLabel.getText() + "0");
        });
        One.addActionListener(e -> {
            EquationLabel.setText(EquationLabel.getText() + "1");
        });
        Two.addActionListener(e -> {
            EquationLabel.setText(EquationLabel.getText() + "2");
        });
        Three.addActionListener(e -> {
            EquationLabel.setText(EquationLabel.getText() + "3");
        });
        Four.addActionListener(e -> {
            EquationLabel.setText(EquationLabel.getText() + "4");
        });
        Five.addActionListener(e -> {
            EquationLabel.setText(EquationLabel.getText() + "5");
        });
        Six.addActionListener(e -> {
            EquationLabel.setText(EquationLabel.getText() + "6");
        });
        Seven.addActionListener(e -> {
            EquationLabel.setText(EquationLabel.getText() + "7");
        });
        Eight.addActionListener(e -> {
            EquationLabel.setText(EquationLabel.getText() + "8");
        });
        Nine.addActionListener(e -> {
            EquationLabel.setText(EquationLabel.getText() + "9");
        });
        Add.addActionListener(e -> {
            EquationLabel.setText(EquationLabel.getText() + "+");
            if (EquationLabel.getText().length() == 1) {
                EquationLabel.setText("");
            } else {
                if (!Character.isDigit(EquationLabel.getText().charAt(EquationLabel.getText().length() - 2))) {
                    if (EquationLabel.getText().charAt(EquationLabel.getText().length() - 2) == '.') {
                        EquationLabel.setText(EquationLabel.getText().substring(0, EquationLabel.getText().length() - 2) + ".0+");
                    } else {
                        EquationLabel.setText(EquationLabel.getText().substring(0, EquationLabel.getText().length() - 2) + "+");
                    }
                }
            }
        });
        Subtract.addActionListener(e -> {
            EquationLabel.setText(EquationLabel.getText() + "-");

            if (EquationLabel.getText().length() == 1) {
                EquationLabel.setText("");
            } else {
                if (!Character.isDigit(EquationLabel.getText().charAt(EquationLabel.getText().length() - 2))) {
                    if (EquationLabel.getText().charAt(EquationLabel.getText().length() - 2) == '.') {
                        EquationLabel.setText(EquationLabel.getText().substring(0, EquationLabel.getText().length() - 2) + ".0-");
                    } else {
                        EquationLabel.setText(EquationLabel.getText().substring(0, EquationLabel.getText().length() - 2) + "-");
                    }
                }
            }
        });
        Multiply.addActionListener(e -> {
            EquationLabel.setText(EquationLabel.getText() + "\u00D7");

            if (EquationLabel.getText().length() == 1) {
                EquationLabel.setText("");
            } else {
                if (!Character.isDigit(EquationLabel.getText().charAt(EquationLabel.getText().length() - 2))) {
                    if (EquationLabel.getText().charAt(EquationLabel.getText().length() - 2) == '.') {
                        EquationLabel.setText(EquationLabel.getText().substring(0, EquationLabel.getText().length() - 2) + ".0\u00D7");
                    } else {
                        EquationLabel.setText(EquationLabel.getText().substring(0, EquationLabel.getText().length() - 2) + "\u00D7");
                    }
                }
            }
        });
        Divide.addActionListener(e -> {
            EquationLabel.setText(EquationLabel.getText() + "\u00F7");
            if (EquationLabel.getText().length() == 1) {
                EquationLabel.setText("");
            } else {
                String text = EquationLabel.getText();
                if (!Character.isDigit(text.charAt(text.length() - 2))) {
                    if (text.charAt(text.length() - 2) == '.') {
                        EquationLabel.setText(text.substring(0, text.length() - 2) + ".0\u00F7");
                    } else {
                        EquationLabel.setText(text.substring(0, text.length() - 2) + "\u00F7");
                    }
                }
            }
        });
        Delete.addActionListener(e -> {
            String text = EquationLabel.getText();
            if (text.length() - 1 <= 0)
                EquationLabel.setText("");
            else {
                if (text.charAt(text.length() - 1) == ')') {
                    numberOfRightBrackets--;
                } else if (text.charAt(text.length() - 1) == '(') {
                    numberOfLeftBrackets--;
                }
                EquationLabel.setText(text.substring(0, text.length() - 1));
            }

        });
        Clear.addActionListener(e -> {
            EquationLabel.setText("");
            ResultLabel.setText("0");
            numberOfLeftBrackets = 0;
            numberOfRightBrackets = 0;
            EquationLabel.setForeground(Color.GREEN);
        });
        Dot.addActionListener(e -> {
            if (!EquationLabel.getText().contains(".")) {
                EquationLabel.setText(EquationLabel.getText() + ".");
                if (EquationLabel.getText().length() == 1) {
                    if (!flag) {
                        EquationLabel.setText(".");
                        flag = true;
                    } else {
                        EquationLabel.setText("0.");
                    }
                } else {
                    if (!Character.isDigit(EquationLabel.getText().charAt(EquationLabel.getText().length() - 2))) {
                        EquationLabel.setText(EquationLabel.getText().substring(0, EquationLabel.getText().length() - 2) + ".");
                    }
                }
            } else {

            }

        });

        SquareRoot.addActionListener(e -> {
            EquationLabel.setText(EquationLabel.getText() + "\u221A(");
            numberOfLeftBrackets++;
        });
        PowerTwo.addActionListener(e -> {
            EquationLabel.setText(EquationLabel.getText() + "^(2)");
            if (EquationLabel.getText().length() == 1) {
                EquationLabel.setText("");
            }
        });
        PowerY.addActionListener(e -> {
            EquationLabel.setText(EquationLabel.getText() + "^(");
            numberOfLeftBrackets++;
            if (EquationLabel.getText().length() == 1) {
                EquationLabel.setText("");
                numberOfLeftBrackets = 0;
            }
        });
        PlusMinus.addActionListener(e -> {
            String text = EquationLabel.getText();
            if (text.length() >= 2 && text.substring(0, 2).equals("(-")) {
                EquationLabel.setText("" + text.substring(2, text.length()));
                System.out.println(text.substring(2, text.length()));
                numberOfLeftBrackets--;
            } else {
                EquationLabel.setText("(-" + text);
                numberOfLeftBrackets += 1;
            }

        });
        Parentheses.addActionListener(e -> {
            String text = EquationLabel.getText();
            if (numberOfLeftBrackets == numberOfRightBrackets) {
                EquationLabel.setText(text + "(");
                numberOfLeftBrackets++;
            } else if ("(+-×÷".contains(String.valueOf(text.charAt(text.length() - 1)))) {
                EquationLabel.setText(text + "(");
                numberOfLeftBrackets++;
            } else {
                EquationLabel.setText(text + ")");
                numberOfRightBrackets++;
            }
        });
        Equals.addActionListener(e -> {
            strs = (Calculator.infixToPostfix(EquationLabel.getText()).split(" "));
            for (int i = 0; i < stack.length; i++) {
                stack[i] = 0.0;
            }
            System.out.println(Arrays.toString(strs));
            if (isOperatorEndFlag) {
                EquationLabel.setForeground(Color.RED.darker());
            } else {
                EquationLabel.setForeground(Color.GREEN);
                for (String elem : strs) {
                    Character first = elem.charAt(0);
                    if (Character.isDigit(first) || elem.length() > 1) {
                        push(Double.parseDouble(elem));
                    } else if (first == '+') {
                        push(pop() + pop());
                    } else if (first == '-') {
                        double op2 = pop();
                        push(pop() - op2);
                    } else if (first == '\u00D7') {
                        push(pop() * pop());
                    } else if (first == '\u00F7') {
                        double op2 = pop();
                        if (op2 == 0.0) {
                            System.out.println("Dividing by zero is undefined\n");
                            EquationLabel.setForeground(Color.RED.darker());
                            isZeroDivisionFlag = true;
                        } else {
                            push(pop() / op2);
                            isZeroDivisionFlag = false;
                        }
                    }
                }
                if (!isZeroDivisionFlag) {
                    String ans = (String.valueOf(pop()).toUpperCase());
                    if (ans.charAt(ans.indexOf('.') + 1) == '0' && (ans.length() - ans.indexOf('.') - 1 == 1)) {
                        ResultLabel.setText(String.valueOf(Integer.parseInt(ans.substring(0, ans.length() - 2))));
                    } else {
                        ResultLabel.setText(ans);
                    }
                } else {
                    ResultLabel.setText("0");
                }
            }
        });
    }

    static int sp = 0;         // next free  position in stack

    static void push(double f) // puts a number on the stack
    {
        stack[sp++] = f;
    }

    static double pop() // retrieves a number from the stack
    {
        if (sp > 0)
            return stack[--sp];
        else {
            System.out.printf("Error : stack empty\n");
            return 0.0;
        }
    }

    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '×':
            case '÷':
                return 2;
        }
        return -1;
    }

    static String infixToPostfix(String exp) {
        // initializing empty String for result
        String result = new String("");

        // initializing empty stack
        Deque<Character> stack
                = new ArrayDeque<Character>();

        if ("+-×÷(\u221A^".contains(String.valueOf(exp.charAt(exp.length() - 1))) || numberOfLeftBrackets != numberOfRightBrackets) {
            isOperatorEndFlag = true;
        } else {
            isOperatorEndFlag = false;
        }


        for (int i = 0; i < exp.length(); i++) {
            if (!isOperatorEndFlag && exp.charAt(i) == '\u221A') {
                String c = "\u221A(";
                if (exp.charAt(i + 2) == ')') {             // sqrt ()
                    isOperatorEndFlag = true;
                }
                for (int j = i + 2; exp.charAt(j) != ')'; j++) {
                    if (!isOperatorEndFlag && exp.charAt(j) == '^') {
                        String base = "", pow = "";
                        for (int k = j - 1; k >= 0 && Character.isDigit(exp.charAt(k)); k--) {
                            base = exp.charAt(k) + base;
                        }
                        for (int k = j + 2; exp.charAt(k) != ')'; k++) {
                            pow += exp.charAt(k);
                        }
                        exp = exp.substring(0, j - base.length()) + String.valueOf(Math.pow(Double.parseDouble(base), Double.parseDouble(pow))) + exp.substring(j + pow.length() + 3, exp.length());
                    }
                    c += exp.charAt(j);
                }
                c += ")";
                int len = exp.length();
                exp = exp.substring(0, i) + String.valueOf(Math.sqrt(Double.parseDouble(c.substring(2, c.length() - 1)))) + exp.substring(i + c.length(), len);
                System.out.println(exp);
            }
        }


        for (int i = 0; i < exp.length(); i++) {
            if (!isOperatorEndFlag && exp.charAt(i) == '^') {
                String base = "", pow = "";
                for (int j = i - 1; j >= 0 && Character.isDigit(exp.charAt(j)) || exp.charAt(j) == '.'; j--) {
                    base = exp.charAt(j) + base;
                }
                System.out.println("HERE" + base);
                for (int j = i + 2; exp.charAt(j) != ')'; j++) {
                    if (!isOperatorEndFlag && exp.charAt(j) == '\u221A') {
                        String c = "\u221A(";
                        System.out.println("FOUND");
                        if (exp.charAt(j + 2) == ')') {             // sqrt ()
                            isOperatorEndFlag = true;
                        }
                        for (int k = j + 2; exp.charAt(k) != ')'; k++) {
                            c += exp.charAt(k);
                        }
                        c += ")";
                        System.out.println(exp);
                        exp = exp.substring(0, j) + String.valueOf(Math.sqrt(Double.parseDouble(c.substring(2, c.length() - 1)))) + exp.substring(j + c.length(), exp.length());
                        System.out.println(exp);
                    }
                    pow += exp.charAt(j);
                }
                int len = exp.length();
                exp = exp.substring(0, i - base.length()) + "(" + String.valueOf(Math.pow(Double.parseDouble(base), Double.parseDouble(pow))) + exp.substring(i + pow.length() + 2, len);
                System.out.println(exp);
            }
        }


        for (int i = 0; i < exp.length(); i++) {
            if (!isOperatorEndFlag && exp.charAt(i) == '(' && exp.charAt(i + 1) == '-') {
                exp = exp.substring(0, i) + "(0" + exp.substring(i + 1, exp.length());
            }
            System.out.println(exp);
        }
        int i = 0;
        boolean flag = false; // is minus
        while (i < exp.length()) {
            String c = "";
            if (i == 0 && exp.charAt(i) == '-') {
                flag = true;
                while (Character.isLetterOrDigit(exp.charAt(i)) || i == 0) {
                    c += exp.charAt(i);
                    i++;
                }
            } else {
                c += exp.charAt(i);
                i++;
                if (i != exp.length() && Character.isLetterOrDigit(exp.charAt(i - 1))) {
                    while (i != exp.length() && ((Character.isLetterOrDigit(exp.charAt(i))) || exp.charAt(i) == '.')) {
                        c += exp.charAt(i);
                        i++;
                    }
                }
            }
            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c.charAt(0)) || flag) {
                result += c + " ";
                if (flag)
                    flag = false;
            }
            // If the scanned character is an '(',
            // push it to the stack.
            else if (c.charAt(0) == '(')
                stack.push(c.charAt(0));

                //  If the scanned character is an ')',
                // pop and output from the stack
                // until an '(' is encountered.
            else if (c.charAt(0) == ')') {
                while (!stack.isEmpty()
                        && stack.peek() != '(') {
                    result += stack.peek() + " ";
                    stack.pop();
                }

                stack.pop();
            } else // an operator is encountered
            {
                while (!stack.isEmpty()
                        && Prec(c.charAt(0)) <= Prec(stack.peek())) {

                    result += stack.peek() + " ";
                    stack.pop();
                }
                stack.push(c.charAt(0));
            }
        }

        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";

            result += stack.peek() + " ";
            stack.pop();
        }

        return result;
    }


}
