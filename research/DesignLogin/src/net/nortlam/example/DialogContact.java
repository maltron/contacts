package net.nortlam.example;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import static net.nortlam.design.LayoutUtil.*;

/**
 *
 * @author Mauricio "Maltron" Leal <maltron at gmail dot com> */
public class DialogContact extends JDialog implements ActionListener, KeyListener, DocumentListener {

    private static final Logger LOG = Logger.getLogger(DialogContact.class.getName());
    
    private JLabel labelEmail, labelTitle, labelFirstName, labelLastName, labelPhone;
    private JTextField textEmail, textTitle, textFirstName, textLastName, textPhone;
    private JButton buttonSave, buttonCancel;

    public DialogContact(JFrame owner) {
        super(owner, "Contact", true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        
        initComponents();
        setContentPane(createPanel());
        revalidate(); repaint(); pack();
    }
    
    private void initComponents() {
        labelEmail = new JLabel("Email");
        textEmail = new JTextField(20);
        textEmail.getDocument().addDocumentListener(this);
        textEmail.addKeyListener(this);
        
        labelTitle = new JLabel("Title");
        textTitle = new JTextField(20);
        textTitle.getDocument().addDocumentListener(this);
        
        labelFirstName = new JLabel("First");
        textFirstName = new JTextField(20);
        textFirstName.getDocument().addDocumentListener(this);
        
        labelLastName = new JLabel("Last");
        textLastName = new JTextField(20);
        textLastName.getDocument().addDocumentListener(this);
        
        labelPhone = new JLabel("Phone");
        textPhone = new JTextField(20);
        textPhone.getDocument().addDocumentListener(this);
        
        buttonSave = new JButton("Save");
        buttonSave.addActionListener(this);
        buttonSave.addKeyListener(this);
        
        buttonCancel = new JButton("Cancel");
        buttonCancel.addActionListener(this);
        buttonCancel.addKeyListener(this);
    }
    
    private JPanel createPanel() {
        JPanel panelForm = layoutLabelText(
                new Component[] {labelEmail, labelTitle, labelFirstName, 
                        labelLastName, labelPhone, Box.createVerticalBox()},
                new Component[] {textEmail, textTitle, textFirstName, 
                        textLastName, textPhone, Box.createVerticalBox()});
        
        JPanel panelButtons = layoutButtons(buttonSave, buttonCancel);
        
        JPanel mainPanel = layoutNorthSoutheast(panelForm, panelButtons);
        mainPanel.setBorder(borderEmpty());
        
        return mainPanel;
    }
    
    private void closeDialog() {
        setVisible(false); dispose(); System.gc();
    }
    
    // ACTION LISTENER ACTION LISTENER ACTION LISTENER ACTION LISTENER ACTION LISTENER 
    //  ACTION LISTENER ACTION LISTENER ACTION LISTENER ACTION LISTENER ACTION LISTENER 

    @Override
    public void actionPerformed(ActionEvent e) {
        closeDialog();
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
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }
}
