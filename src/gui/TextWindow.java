package gui;

import javax.swing.*;
import java.awt.event.*;

public class TextWindow extends JDialog {
    private JPanel contentPane;
    private JButton buttonClose;
    private JTextArea textArea1;

    public TextWindow() {
        setContentPane(contentPane);
        setModal(false);

        buttonClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onClose();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
//        addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                onCancel();
//            }
//        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onClose();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onClose() {
        // add your code here if necessary
        dispose();
    }

    public void setText(String str){
        textArea1.setText(str);
    }
}
