package net.nortlam.example;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

import static net.nortlam.design.LayoutUtil.*;

/**
 *
 * @author Mauricio "Maltron" Leal <maltron at gmail dot com> */
public class DialogLogin extends JDialog implements ActionListener, KeyListener, DocumentListener {

    private JComboBox comboLanguages;
    private JLabel labelError;
    private JLabel labelUsername, labelPassword;
    private JTextField textUsername;
    private JPasswordField password;
    private JButton buttonRegister, buttonForgetPassword, buttonSignIn, buttonCancel;
    
    public DialogLogin(JFrame owner) {
        super(owner, "Login", true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        setUndecorated(true);
        setResizable(false);
        
        initComponents();
        setContentPane(createPanel());
        revalidate(); repaint(); pack();
    }
    
    private void initComponents() {
        comboLanguages = new JComboBox(new String[] {"English", "Español", "Deutsch", "Português"});
        comboLanguages.addKeyListener(this);
        
        labelError = new JLabel(" Invalid Login ", JLabel.CENTER);
        labelError.setBorder(borderEmpty());
        
        buttonRegister = createButton("Register");
        buttonForgetPassword = createButton("Forgot Password");
        buttonForgetPassword.setEnabled(false);
        buttonSignIn = createButton("Sign In");
        buttonSignIn.setEnabled(false);
        buttonCancel = createButton("Cancel");
        
        labelUsername = new JLabel("Username");
        labelPassword = new JLabel("Password");
        textUsername = new JTextField(15); 
        textUsername.getDocument().addDocumentListener(this);
        textUsername.addKeyListener(this);
        password = new JPasswordField(15);
        password.getDocument().addDocumentListener(this);
        password.addKeyListener(this);
    }
    
    private JPanel createPanel() {
        JPanel panelError = new JPanel(new BorderLayout());
        panelError.setBorder(borderEtched());
        panelError.add(labelError, BorderLayout.CENTER);
        
//        JPanel topPanel = new JPanel(new BorderLayout(0, 10 ));
//        topPanel.add(layoutNortheast(comboLanguages), BorderLayout.NORTH);
//        topPanel.add(panelError, BorderLayout.CENTER);
//        topPanel.add(layoutLabelText(new JLabel[] {labelUsername, labelPassword},
//                new JTextComponent[] {textUsername, password}), BorderLayout.SOUTH);

        JPanel topPanel = layoutVertical(
                layoutNortheast(comboLanguages), panelError,
                layoutLabelText(new JLabel[] {labelUsername, labelPassword},
                new JTextComponent[] {textUsername, password}),
                Box.createVerticalStrut(40));
        
        JPanel mainPanel = layoutNorthSouthwestSouthSoutheast(
                // North
                topPanel,
                // Southwest
                layoutButtons(buttonRegister, Box.createHorizontalStrut(10)),
                // South
                layoutButtons(buttonForgetPassword),
                // Southeast
                layoutButtons(Box.createHorizontalStrut(10), buttonSignIn, buttonCancel));
        mainPanel.setBorder(borderEmpty());
                            
        return mainPanel;
    }
    
    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.addActionListener(this);
        button.addKeyListener(this);
        
        return button;
    }
    
    @Override
    public void setVisible(boolean visible) {
        textUsername.requestFocusInWindow();
        super.setVisible(visible);
    }
    
    /**
    * Fecha este Dialog */
    public void closeDialog() {
        setVisible(false); dispose(); System.gc();
    }
    
    // ACTION LISTENER ACTION LISTENER ACTION LISTENER ACTION LISTENER ACTION LISTENER 
    //  ACTION LISTENER ACTION LISTENER ACTION LISTENER ACTION LISTENER ACTION LISTENER 

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
    // KEY LISTENER KEY LISTENER KEY LISTENER KEY LISTENER KEY LISTENER KEY LISTENER 
    //  KEY LISTENER KEY LISTENER KEY LISTENER KEY LISTENER KEY LISTENER KEY LISTENER 
    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent event) {
        if (event.getKeyChar() == KeyEvent.VK_ESCAPE) {
            closeDialog();
        }
    }
    
    // DOCUMENT LISTENER DOCUMENT LISTENER DOCUMENT LISTENER DOCUMENT LISTENER DOCUMENT LISTENER 
    // DOCUMENT LISTENER DOCUMENT LISTENER DOCUMENT LISTENER DOCUMENT LISTENER DOCUMENT LISTENER 
    @Override
    public void insertUpdate(DocumentEvent e) {
        buttonSignIn.setEnabled(hasUsernamePassword());
        buttonForgetPassword.setEnabled(hasUsername());
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        buttonSignIn.setEnabled(hasUsernamePassword());
        buttonForgetPassword.setEnabled(hasUsername());
        
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        buttonSignIn.setEnabled(hasUsernamePassword());
        buttonForgetPassword.setEnabled(hasUsername());
    }
    
    private boolean hasUsernamePassword() {
        return hasUsername() &&
                password.getPassword().length > 0;
    }
    
    private boolean hasUsername() {
        return textUsername.getText().length() > 0;
    }
}
