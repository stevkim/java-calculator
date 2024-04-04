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

        JPanel buttonPanel = panel();

        frame.add(buttonPanel);
        frame.add(del);
        frame.add(clr);

        frame.add(display);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new Calculator();
    }

    public void actionPerformed(ActionEvent e) {
        Object current = e.getSource();
        String text = display.getText();

        for (int i = 0; i < numbers.length; i++) {
            if (current == numbers[i]) {
                display.setText(text.concat(String.valueOf(i)));
            }
        }

        if (current == dec) {
            display.setText(text.concat("."));
        }

        if (current == add) {
            inputOne = Double.parseDouble(text);
            op = '+';
            display.setText("");
        }

        if (current == sub) {
            inputOne = Double.parseDouble(text);
            op = '-';
            display.setText("");
        }

        if (current == mul) {
            inputOne = Double.parseDouble(text);
            op = '*';
            display.setText("");
        }

        if (current == div) {
            inputOne = Double.parseDouble(text);
            op = '/';
            display.setText("");
        }

        if (current == equ) {
            inputTwo = Double.parseDouble(text);
            switch (op) {
                case '+':
                    result = inputOne + inputTwo;
                    break;
                case '-':
                    result = inputOne - inputTwo;
                    break;
                case '*':
                    result = inputOne * inputTwo;
                    break;
                case '/':
                    result = inputOne / inputTwo;
                    break;
            }
            display.setText(String.valueOf(result));
            inputOne = result;
        }

        if (current == del) {
            display.setText("");

            for (int i = 0; i < text.length() - 1; i++) {
                display.setText(display.getText() + text.charAt(i));
            }
        }

        if (current == clr) {
            display.setText("");
        }
    }

    private JPanel panel() {
        JPanel panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(add);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(sub);
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(mul);
        panel.add(dec);
        panel.add(numbers[0]);
        panel.add(equ);
        panel.add(div);

        return panel;
    }

    private void numberButtons() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFocusable(false);
        }
    }

    private void functionButtons() {
        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        dec = new JButton("+");
        equ = new JButton("=");
        del = new JButton("Delete");
        clr = new JButton("Clear");

        functions[0] = add;
        functions[1] = sub;
        functions[2] = mul;
        functions[3] = div;
        functions[4] = dec;
        functions[5] = equ;
        functions[6] = del;
        functions[7] = clr;

        for (int i = 0; i < functions.length; i++) {
            functions[i].addActionListener(this);
            functions[i].setFocusable(false);
        }

        del.setBounds(50, 430, 145, 50);
        clr.setBounds(205, 430, 145, 50);
    }
}
