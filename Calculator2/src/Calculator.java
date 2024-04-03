import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField display;
    JButton[] numbers = new JButton[10];
    JButton[] functions = new JButton[8];
    JButton add, sub, mul, div, dec, equ, del, clr;

    double inputOne = 0, inputTwo = 0, result = 0;
    char op;

    Calculator() {
        // create a new frame for the application
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        // create the number display
        display = new JTextField();
        display.setBounds(50, 25, 300, 50);
        display.setEditable(false);
        display.setFocusable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT);

        // create function buttons
        functionButtons();
        // create number buttons
        numberButtons();

        frame.add(display);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new Calculator();
    }

    public void actionPerformed(ActionEvent e) {

    }

    private void panel() {
        JPanel panel = new JPanel();
    }

    private void numberButtons() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFocusable(false);
        }
    }

    private void functionButtons() {
        String[] operators = { "+", "-", "*", "/", ".", "=", "Del", "Clear" };

        for (int i = 0; i < operators.length; i++) {
            switch (operators[i]) {
                case "+":
                    add = new JButton("+");
                    add.addActionListener(this);
                    add.setFocusable(false);
                    functions[i] = add;
                    break;
                case "-":
                    sub = new JButton("-");
                    sub.addActionListener(this);
                    sub.setFocusable(false);
                    functions[i] = sub;
                    break;
                case "*":
                    mul = new JButton("*");
                    mul.addActionListener(this);
                    mul.setFocusable(false);
                    functions[i] = mul;
                    break;
                case "/":
                    div = new JButton("/");
                    div.addActionListener(this);
                    div.setFocusable(false);
                    functions[i] = div;
                    break;
                case ".":
                    dec = new JButton("+");
                    dec.addActionListener(this);
                    dec.setFocusable(false);
                    functions[i] = dec;
                    break;
                case "=":
                    equ = new JButton("=");
                    equ.addActionListener(this);
                    equ.setFocusable(false);
                    functions[i] = equ;
                    break;
                case "Del":
                    del = new JButton("Delete");
                    del.addActionListener(this);
                    del.setFocusable(false);
                    functions[i] = del;
                    break;
                case "Clear":
                    clr = new JButton("Clear");
                    clr.addActionListener(this);
                    clr.setFocusable(false);
                    functions[i] = clr;
                    break;
            }
        }
        del.setBounds(50, 430, 145, 50);
        clr.setBounds(205, 430, 145, 50);
    }
}