package gui;

import exceptions.CantDecomposeException;
import exceptions.OutOfBoundsException;
import printers.Printer;
import printers.PrinterDummy;
import sequences.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private JLabel changeLabel;
    private JLabel upperLimitLabale;

    private Sequence sequence=null;
    private Printer printer=new PrinterDummy();

    public MainFrame(){
        super();
        this.setContentPane(mainPanel);
        quitButton.addActionListener(this::exitAction);
        creditsButton.addActionListener(this::creditsAction);
        selectButton.addActionListener(this::selectAction);
        changeButton.addActionListener(this::changeAction);
        decomposeButton.addActionListener(this::decomposeAction);
        sumButton.addActionListener(this::sumAction);
        resetButton.addActionListener(this::resetAction);
        showElementsButton.addActionListener(this::showElementsAction);
        init();
    }

    private void lockSequenceChoice(boolean lock){
        //to lock
        comboBox1.setEnabled(!lock);
        selectButton.setEnabled(!lock);
        //to unlock
        JComponent[] lst= {
                resetButton,
                limitTextField,
                changeButton,
                showElementsButton,
                saveToFileButton,
                decomposeButton,
                sumButton,
                decomposeTextField,
                sumTextField,
                changeLabel,
                upperLimitLabale,
                limitLabel
        };
        for (JComponent cmp:lst){
            cmp.setEnabled(lock);
        }
        if (lock){
            limitLabel.setText(Integer.toString(sequence.getMax()));
        }else {
            limitLabel.setText("---");
        }
    }

    private void init(){
        Sequence[] sq={new Primes(), new Squares(), new Fibonacci(), new Integers(),
        new Arithmetic(1,3)};
        comboBox1.setModel(new DefaultComboBoxModel<Sequence>(sq));
        lockSequenceChoice(false);
        limitTextField.setColumns(6);
        decomposeTextField.setColumns(8);
        sumTextField.setColumns(8);
    }

    private void showElementsAction(ActionEvent e){
        showDialog(printer.print(sequence), "Sequence");
    }

    private void showDialog(String str, String title){
        TextWindow dialog = new TextWindow();
        dialog.pack();
        dialog.setTitle(title);
        dialog.setSize(800,600);
        dialog.setText(str);
        dialog.setVisible(true);
    }

    private void resetAction(ActionEvent e){
        sequence=null;
        lockSequenceChoice(false);
    }

    private void sumAction(ActionEvent e){
        Integer n=parseInt(sumTextField);
        if (n!=null){
            try {
                int sum=sequence.getSum(n);
                showDialog("Sum: "+sum, "Sum");
            } catch (OutOfBoundsException ex){
                showError(ex.getMessage());
            }
        }
    }

    private void decomposeAction(ActionEvent e){
        Integer n=parseInt(decomposeTextField);
        if (n!=null){
            try {
                ArrayList<Integer> list=sequence.decompose(n);
                showDialog(printer.printDecomposition(list), "Decomposition of "+n);
            } catch (CantDecomposeException ex){
                showError(ex.getMessage());
            }
        }
    }

    private Integer parseInt(JTextField tf) {
        Integer ret=null;
        try {
            ret = Integer.parseInt(tf.getText());
        } catch (NumberFormatException ex){
            showError("Invalid number!");
        }
        return ret;
    }

    private void changeAction(ActionEvent e){
        Integer limit=parseInt(limitTextField);
        if (limit!=null){
            sequence.setMax(limit);
        }
        limitTextField.setText("");
        lockSequenceChoice(true);
    }

    private void selectAction(ActionEvent e){
        sequence= (Sequence) comboBox1.getSelectedItem();
        lockSequenceChoice(true);
    }

    private void exitAction(ActionEvent e){
        this.dispose();
    }

    private void creditsAction(ActionEvent e){
        JOptionPane.showMessageDialog(this,
                "Developed by MS" , "Credits",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void showError(String msg){
        JOptionPane.showMessageDialog(this,
                msg,"Error", JOptionPane.ERROR_MESSAGE);
    }
}
