package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
  JFrame frame;
  JTextField textField;
  JButton[] numberButtons = new JButton[10];
  JButton[] functionButtons = new JButton[8];
  JButton addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton;

  double firstNum = 0, secondNum = 0, result = 0;
  char operator;

  Calculator() {
    frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(420, 550);
    frame.setLayout(null);

    textField = new JTextField();
    textField.setBounds(50, 25, 300, 50);
    textField.setEditable(false);
    textField.setFocusable(false);

    initializeFunctionButtons();

    initializeNumberButtons();

    JPanel numberPanel = initializeNumberPanel();

    frame.add(numberPanel);
    frame.add(delButton);
    frame.add(clrButton);
    frame.add(textField);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    Calculator calc = new Calculator();
  }

  public void actionPerformed(ActionEvent e) {
    Object current = e.getSource();
    String currentText = textField.getText();

    for (int i = 0; i < numberButtons.length; i++) {
      if (current == numberButtons[i]) {
        setText(currentText.concat(String.valueOf(i)));
      }
    }

    if (current == decButton) {
      setText(currentText.concat("."));
    }

    if (current == addButton) {
      firstNum = Double.parseDouble(currentText);
      operator = '+';
      setText("");
    }
    if (current == subButton) {
      firstNum = Double.parseDouble(currentText);
      operator = '-';
      setText("");
    }
    if (current == mulButton) {
      firstNum = Double.parseDouble(currentText);
      operator = '*';
      setText("");
    }
    if (current == divButton) {
      firstNum = Double.parseDouble(currentText);
      operator = '/';
      setText("");
    }

    if (current == equButton) {
      secondNum = Double.parseDouble(currentText);

      switch (operator) {
        case '+':
          result = firstNum + secondNum;
          break;
        case '-':
          result = firstNum - secondNum;
          break;
        case '*':
          result = firstNum * secondNum;
          break;
        case '/':
          result = firstNum / secondNum;
          break;
      }
      setText(String.valueOf(result));
      firstNum = result;
    }

    if (current == delButton) {
      clearText();

      for (int i = 0; i < currentText.length() - 1; i++) {
        setText(textField.getText() + currentText.charAt(i));
      }
    }

    if (current == clrButton) {
      clearText();
    }
  }

  public JPanel initializeNumberPanel() {
    JPanel panel = new JPanel();
    panel.setBounds(50, 100, 300, 300);
    panel.setLayout(new GridLayout(4, 4, 10, 10));

    panel.add(numberButtons[1]);
    panel.add(numberButtons[2]);
    panel.add(numberButtons[3]);
    panel.add(addButton);
    panel.add(numberButtons[4]);
    panel.add(numberButtons[5]);
    panel.add(numberButtons[6]);
    panel.add(subButton);
    panel.add(numberButtons[7]);
    panel.add(numberButtons[8]);
    panel.add(numberButtons[9]);
    panel.add(mulButton);
    panel.add(decButton);
    panel.add(numberButtons[0]);
    panel.add(equButton);
    panel.add(divButton);

    return panel;
  }

  public void initializeNumberButtons() {
    for (int i = 0; i < numberButtons.length; i++) {
      numberButtons[i] = new JButton(String.valueOf(i));
      numberButtons[i].addActionListener(this);
      numberButtons[i].setFocusable(false);
    }
  }

  public void initializeFunctionButtons() {
    addButton = new JButton("+");
    subButton = new JButton("-");
    mulButton = new JButton("*");
    divButton = new JButton("/");
    decButton = new JButton(".");
    equButton = new JButton("=");
    delButton = new JButton("Del");
    clrButton = new JButton("Clear");

    functionButtons[0] = addButton;
    functionButtons[1] = subButton;
    functionButtons[2] = mulButton;
    functionButtons[3] = divButton;
    functionButtons[4] = decButton;
    functionButtons[5] = equButton;
    functionButtons[6] = delButton;
    functionButtons[7] = clrButton;

    for (int i = 0; i < functionButtons.length; i++) {
      functionButtons[i].addActionListener(this);
      functionButtons[i].setFocusable(false);
    }

    delButton.setBounds(50, 430, 145, 50);
    clrButton.setBounds(205, 430, 145, 50);
  }

  public void setText(String text) {
    textField.setText(text);
  }

  public void clearText() {
    textField.setText("");
  }
}
