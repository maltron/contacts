package net.nortlam.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Mauricio "Maltron" Leal <maltron at gmail dot com> */
public class Login extends JFrame implements Serializable, ActionListener, KeyListener {

    private static final Logger LOG = Logger.getLogger(Login.class.getName());
    
    public static void main(String[] args) {
        Login app = new Login();
    }
    
    public Login() {
        super("Login");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception ex) {}
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
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
        setVisible(true);
    }
    
    private JPanel createPanel() {
        return new JPanel();
    }
    
    private void closeApplication() {
        setVisible(false);
        System.exit(0);
    }
    
    // ACTION LISTENER ACTION LISTENER ACTION LISTENER ACTION LISTENER ACTION LISTENER 
    //  ACTION LISTENER ACTION LISTENER ACTION LISTENER ACTION LISTENER ACTION LISTENER 
    @Override
    public void actionPerformed(ActionEvent e) {
            closeApplication();
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