package net.nortlam.example;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
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
public class Login extends JFrame implements Serializable, ActionListener, KeyListener, DocumentListener {

    private static final Logger LOG = Logger.getLogger(Login.class.getName());

    private JComboBox comboLanguages;
    private JLabel labelError;
    private JLabel labelUsername, labelPassword;
    private JTextField textUsername;
    private JPasswordField password;
    private JButton buttonRegister, buttonForgetPassword, buttonSignIn, buttonCancel;
    
    public static void main(String[] args) {
        Login app = new Login();
    }
    
    public Login() {
        super("Login");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        new Runnable() {
            @Override
            public void run() {
                setContentPane(createPanel());
            }
        }.run();
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeApplication();
            }
        });
        setSize(800, 600);
        setVisible(true);
        
        textUsername.requestFocus(true);
    }
    
    private JPanel createPanel() {
        comboLanguages = new JComboBox(new String[] {"English", "Español", "Deutsch", "Português"});
        comboLanguages.addKeyListener(this);
        
        labelError = new JLabel(" Invalid Login ", JLabel.CENTER);
        labelError.setBorder(borderEmpty());
        JPanel panelError = new JPanel(new BorderLayout());
        panelError.setBorder(borderEtched());
        panelError.add(labelError, BorderLayout.CENTER);
        
        buttonRegister = createButton("Register");
        buttonForgetPassword = createButton("Forgot Password");
        buttonSignIn = createButton("Sign In");
        buttonSignIn.setEnabled(false);
        buttonCancel = createButton("Cancel");
        
        labelUsername = new JLabel("Username");
        labelPassword = new JLabel("Password");
        textUsername = new JTextField(); 
        textUsername.getDocument().addDocumentListener(this);
        textUsername.addKeyListener(this);
        password = new JPasswordField();
        password.getDocument().addDocumentListener(this);
        password.addKeyListener(this);
        
        JPanel topPanel = new JPanel(new BorderLayout(0, 10 ));
        topPanel.add(layoutNortheast(comboLanguages), BorderLayout.NORTH);
        topPanel.add(panelError, BorderLayout.CENTER);
        topPanel.add(layoutLabelText(new JLabel[] {labelUsername, labelPassword},
                new JTextComponent[] {textUsername, password}), BorderLayout.SOUTH);
        
        JPanel mainPanel = layoutNorthSouthwestSouthSoutheast(
                // North
                topPanel,
                // Southwest
                layoutButtons(new JComponent[] {buttonRegister}),
                // South
                layoutButtons(new JComponent[] {buttonForgetPassword}),
                // Southeast
                layoutButtons(new JComponent[] {buttonSignIn, buttonCancel}));
        mainPanel.setBorder(borderEmpty());
                            
        return mainPanel;
    }
    
    private void closeApplication() {
        setVisible(false);
        System.exit(0);
    }
    
    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.addActionListener(this);
        button.addKeyListener(this);
        
        return button;
    }
    
    // DOCUMENT LISTENER DOCUMENT LISTENER DOCUMENT LISTENER DOCUMENT LISTENER 
    //  DOCUMENT LISTENER DOCUMENT LISTENER DOCUMENT LISTENER DOCUMENT LISTENER 

    @Override
    public void insertUpdate(DocumentEvent e) {
        buttonSignIn.setEnabled(hasUsernamePassword());
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        buttonSignIn.setEnabled(hasUsernamePassword());
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        buttonSignIn.setEnabled(hasUsernamePassword());
    }
    
    private boolean hasUsernamePassword() {
        return textUsername.getText().length() > 0 &&
                password.getPassword().length > 0;
    }
    
    // ACTION LISTENER ACTION LISTENER ACTION LISTENER ACTION LISTENER ACTION LISTENER 
    //  ACTION LISTENER ACTION LISTENER ACTION LISTENER ACTION LISTENER ACTION LISTENER 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonCancel) {
            closeApplication();
        }
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
            closeApplication();
        }
    }
}