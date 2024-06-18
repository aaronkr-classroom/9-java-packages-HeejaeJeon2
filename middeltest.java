import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Calculator extends JFrame {

   private JTextField inputSpace;
   private String num = "";
   private String prev_operation = "";
   private ArrayList<String> equation = new ArrayList<String>();

   public Calculator() {
      setLayout(null);

      inputSpace = new JTextField();
      inputSpace.setEditable(false);
      inputSpace.setBackground(Color.WHITE);
      inputSpace.setHorizontalAlignment(JTextField.RIGHT);
      inputSpace.setFont(new Font("함초롬돋움", Font.BOLD, 50));
      inputSpace.setBounds(8, 10, 270, 70);

      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));
      buttonPanel.setBounds(8, 90, 270, 235);

      String button_names[] = { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", "AC", "=", "/" };
      JButton buttons[] = new JButton[button_names.length];

      for (int i = 0; i < button_names.length; i++) {
         buttons[i] = new JButton(button_names[i]);
         buttons[i].setFont(new Font("Arial", Font.BOLD, 18));
         if (button_names[i].equals("AC")) {
            buttons[i].setBackground(Color.GRAY);
         } else {
            buttons[i].setBackground(Color.LIGHT_GRAY);
         }
         buttons[i].setForeground(Color.BLACK);
         buttons[i].setBorderPainted(false);
         buttons[i].addActionListener(new PadActionListener());
         buttonPanel.add(buttons[i]);
      }

      add(inputSpace);
      add(buttonPanel);

      setTitle("계산기");
      setVisible(true);
      setSize(300, 390);
      setLocationRelativeTo(null);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      JMenuBar menuBar = new JMenuBar();
      JMenu m1 = new JMenu("File");
      JMenu m2 = new JMenu("Edit");
      JMenu m3 = new JMenu("Help");

      JMenuItem mf1 = new JMenuItem("New");
      JMenuItem mf2 = new JMenuItem("Open");
      m1.add(mf1);
      m1.add(mf2);

      JMenuItem me1 = new JMenuItem("Copy");
      JMenuItem me2 = new JMenuItem("Paste");
      m2.add(me1);
      m2.add(me2);

      menuBar.add(m1);
      menuBar.add(m2);
      menuBar.add(m3);

      setJMenuBar(menuBar);
      
      setLayout(null);
      setVisible(true);
   }

   class PadActionListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         String operation = e.getActionCommand();

         if (operation.equals("AC")) {
            inputSpace.setText("");
            num = "";
            equation.clear();
         } else if (operation.equals("=")) {
            String result = Double.toString(calculate(inputSpace.getText()));
            inputSpace.setText(result);
            num = "";
            equation.clear();
         } else if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/")) {
            if (inputSpace.getText().isEmpty() && operation.equals("-")) {
               inputSpace.setText(inputSpace.getText() + e.getActionCommand());
            } else if (!inputSpace.getText().isEmpty() && !prev_operation.equals("+") && !prev_operation.equals("-") && !prev_operation.equals("*") && !prev_operation.equals("/")) {
               inputSpace.setText(inputSpace.getText() + e.getActionCommand());
            }
         } else {
            inputSpace.setText(inputSpace.getText() + e.getActionCommand());
         }
         prev_operation = e.getActionCommand();
      }
   }

   private void fullTextParsing(String inputText) {
      equation.clear();
      num = "";

      for (int i = 0; i < inputText.length(); i++) {
         char ch = inputText.charAt(i);

         if (ch == '-' || ch == '+' || ch == '*' || ch == '/') {
            equation.add(num);
            num = "";
            equation.add(ch + "");
         } else {
            num += ch;
         }
      }
      equation.add(num);
      equation.remove("");
   }

   public double calculate(String inputText) {
      fullTextParsing(inputText);

      ArrayList<String> tempEquation = new ArrayList<>(equation);

      for (int i = 0; i < tempEquation.size(); i++) {
         String s = tempEquation.get(i);

         if (s.equals("*") || s.equals("/")) {
            double one = Double.parseDouble(tempEquation.get(i - 1));
            double two = Double.parseDouble(tempEquation.get(i + 1));
            double result = s.equals("*") ? one * two : one / two;
            tempEquation.set(i - 1, Double.toString(result));
            tempEquation.remove(i);
            tempEquation.remove(i);
            i--;
         }
      }

      double result = 0;
      String mode = "";
      for (String s : tempEquation) {
         if (s.equals("+")) {
            mode = "add";
         } else if (s.equals("-")) {
            mode = "sub";
         } else {
            double current = Double.parseDouble(s);
            if (mode.equals("add")) {
               result += current;
            } else if (mode.equals("sub")) {
               result -= current;
            } else {
               result = current;
            }
         }
      }
      return Math.round(result * 100000) / 100000.0;
   }
   JMenuBar menuBar = new JMenuBar();
   JMenu m1 = new JMenu("File");
   JMenu m2 = new JMenu("Edit");
   JMenu m3 = new JMenu("Help");
   
   public static void main(String[] args) {
      new Calculator();
   }
}
