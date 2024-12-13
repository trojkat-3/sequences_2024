package gui;

import sequences.*;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JButton quitButton;
    private JButton resetButton;
    private JButton creditsButton;
    private JPanel sequencePanel;
    private JButton selectButton;
    private JTextField limitTextField;
    private JButton changeButton;
    private JPanel firstRow;
    private JPanel secondRow;
    private JPanel centralPanel;
    private JButton showElementsButton;
    private JButton saveToFileButton;
    private JButton decomposeButton;
    private JComboBox comboBox1;
    private JTextField decomposeTextField;
    private JTextField sumTextField;
    private JButton sumButton;
    private JLabel limitLabel;

    private Sequence sequence=null;

    public MainFrame(){
        super();
        this.setContentPane(mainPanel);
        quitButton.addActionListener(this::exitAction);
        creditsButton.addActionListener(this::creditsAction);
        selectButton.addActionListener(this::selectAction);
        changeButton.addActionListener(this::changeAction);
        init();
    }

    private void init(){
        Sequence[] sq={new Primes(),new Squares(), new Fibonacci(), new Integers(),
        new Arithmetic(1,3)};
        comboBox1.setModel(new DefaultComboBoxModel<Sequence>(sq));
        limitLabel.setText("---");
        limitTextField.setColumns(6);
        decomposeTextField.setColumns(8);
        sumTextField.setColumns(8);
    }

    private void changeAction(ActionEvent e){
        int limit= Integer.parseInt(limitTextField.getText());
        sequence.setMax(limit);
        limitLabel.setText(Integer.toString(sequence.getMax()));
    }

    private void selectAction(ActionEvent e){
        sequence= (Sequence) comboBox1.getSelectedItem();
        limitLabel.setText(Integer.toString(sequence.getMax()));
    }

    private void exitAction(ActionEvent e){
        this.dispose();
    }

    private void creditsAction(ActionEvent e){
        JOptionPane.showMessageDialog(this,
                "Developed by MS" , "Credits",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
