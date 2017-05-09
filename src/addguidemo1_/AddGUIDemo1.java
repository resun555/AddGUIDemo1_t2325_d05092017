/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addguidemo1_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.random;
import java.math.BigDecimal;
import java.util.Random;

/**
 *
 * @author gscomnquraut
 */
public class AddGUIDemo1 extends JFrame {
    private JLabel label;
    private final JButton button;
    private final JTextField textField1;
    private final JTextField textField2;
    private JTextField textField3;
    
    public AddGUIDemo1(String string) {
        Font font = new Font("", Font.BOLD, 32);
        JLabel label1 = new JLabel(" ");
        label1.setFont(font);
        label1.setEnabled(false);
        JLabel label2 = new JLabel("=");
        label2.setFont(font);
        label2.setEnabled(false);
        label = new JLabel("Please finish the expression: ");
        label.setFont(font);
        button = new JButton("OK");
        button.setFont(font);
        textField1 = new JTextField(3);
        textField1.setFont(font);
        textField2 = new JTextField(3);
        textField2.setFont(font);
        textField3 = new JTextField(5);
        textField3.setFont(font);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(textField1);
        panel.add(label1);
        panel.add(textField2);
        panel.add(label2);
        panel.add(textField3);
        this.setTitle(string);
        this.setLayout(new BorderLayout());
        this.add(label, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
        this.add(button, BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while (true) {
            double randomDouble = random() * 4.0;
            if (randomDouble >= 0.0 && randomDouble < 1.0) {
                label1.setText("+");
            } else if (randomDouble >= 1.0 && randomDouble < 2.0) {
                label1.setText("-");
            } else if (randomDouble >= 2.0 && randomDouble < 3.0) {
                label1.setText("×");
            } else {
                label1.setText("÷");
            }
        
            double d1 = new BigDecimal((new Random()).nextDouble() * 9.9).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            textField1.setEditable(true);
            textField1.setText("" + d1);
            textField1.setEditable(false);
            double d2 = new BigDecimal((new Random()).nextDouble() * 9.9).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            textField2.setEditable(true);
            textField2.setText("" + d2);
            textField2.setEditable(false);
            while (true) {
                button.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) throws NumberFormatException {
                            try {
                                double d3 = Double.valueOf(textField3.getText());
                                switch (label1.getText()) {
                                case "+":
                                    if (Arithmetic.add(d1, d2) == d3) {
                                        label.setText("Correct!");
                                        System.out.println("1." + label.getText());
                                    } else {
                                        label.setText("Wrong!");
                                        System.out.println("2." + label.getText());
                                    }
                                    break;
                                case "-":
                                    if (Arithmetic.subtract(d1, d2) == d3) {
                                        label.setText("Correct!");
                                        System.out.println("1." + label.getText());
                                    } else {
                                        label.setText("Wrong!");
                                        System.out.println("2." + label.getText());
                                    }
                                    break;
                                case "×":
                                    if (Arithmetic.multiply(d1, d2) == d3) {
                                        label.setText("Correct!");
                                        System.out.println("1." + label.getText());
                                    } else {
                                        label.setText("Wrong!");
                                        System.out.println("2." + label.getText());
                                    }
                                    break;
                                case "÷":
                                    if (Arithmetic.divide(d1, d2, label) == d3) {
                                        label.setText("Correct!");
                                        System.out.println("1." + label.getText());
                                    } else {
                                        label.setText("Wrong!");
                                        System.out.println("2." + label.getText());
                                    }
                                    break;
                                default:
                                    break;
                                } 
                            } catch (NumberFormatException numberFormatException) {
                                label.setText("Incorrect number format!" + numberFormatException.getClass().toString());
                            }
                        }
                    }
                );
                if (label.getText().equals("Correct!")) {
                    System.out.println("3." + label.getText());
                    break;
                }
            }
            
        }
        
    }
    
}
