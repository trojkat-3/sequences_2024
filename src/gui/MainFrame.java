package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JButton quitButton;
    private JButton resetButton;
    private JButton creditsButton;
    private JPanel sequencePanel;
    private JTextField textField1;
    private JButton button1;
    private JTextField textField2;
    private JButton button2;
    private JPanel firstRow;
    private JPanel secondRow;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;

    public MainFrame(){
        super();
        this.setContentPane(mainPanel);
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitAction();
            }
        });
        creditsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                creditsAction();
            }
        });
    }

    private void exitAction(){
        this.dispose();
    }

    private void creditsAction(){
        new JOptionPane().createDialog(this,"Credits").setVisible(true);
    }
}
