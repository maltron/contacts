package net.nortlam.example;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import net.nortlam.design.LayoutUtil;

/**
 *
 * @author Mauricio "Maltron" Leal <maltron at gmail dot com> */
public class TestInputContacts extends JFrame implements Serializable, ActionListener, KeyListener {

    private static final Logger LOG = Logger.getLogger(TestInputContacts.class.getName());
    
    private DialogContact dialog;
    private JButton buttonContacts;
    private JButton buttonExit;
    
    public static void main(String[] args) {
        TestInputContacts app = new TestInputContacts();
    }
    
    public TestInputContacts() {
        super("TestInputContacts");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception ex) {}
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initComponents();
                setContentPane(createPanel());
            }
        });
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeApplication();
            }
        });

        setSize(800, 600);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width/2 - getSize().width/2,
                screenSize.height/2 - getSize().height/2);
        setVisible(true);
    }

    private void initComponents() {
        buttonContacts = createButton("Contacts");
        dialog = new DialogContact(this);
        
        buttonExit = createButton("Exit");
        buttonExit.requestFocus();
    }
    
    private JPanel createPanel() {
        JPanel mainPanel = LayoutUtil.layoutNorthSoutheast(null, 
                LayoutUtil.layoutButtons(buttonContacts, buttonExit));
        mainPanel.setBorder(LayoutUtil.borderEmpty());
        
        return mainPanel;
    }
    
    private void closeApplication() {
        setVisible(false);
        dispose();
        System.gc();
        System.exit(0);
    }
    
    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.addActionListener(this);
        button.addKeyListener(this);
        
        return button;
    }

    // ACTION LISTENER ACTION LISTENER ACTION LISTENER ACTION LISTENER ACTION LISTENER 
    //  ACTION LISTENER ACTION LISTENER ACTION LISTENER ACTION LISTENER ACTION LISTENER 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonExit) {
            closeApplication();
        } else if(e.getSource() == buttonContacts) {
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
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