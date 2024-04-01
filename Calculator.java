package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
  JFrame frame;
  JTextField textField;
  JButton[] numberButtons = new JButton[10];
  JButton[] functionButtons = new JButton[8];

  Calculator() {

  }

  public static void main(String[] args) {
    Calculator calc = new Calculator();
  }

  public void actionPerformed(ActionEvent e) {

  }
}
