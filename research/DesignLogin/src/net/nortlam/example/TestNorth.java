package net.nortlam.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import static net.nortlam.design.LayoutUtil.layoutNorthwestNorthNortheastSouth;
import static net.nortlam.design.LayoutUtil.layoutButtons;

/**
 *
 * @author Mauricio "Maltron" Leal <maltron at gmail dot com> */
public class TestNorth extends JFrame implements Serializable, ActionListener, KeyListener {

    private static final Logger LOG = Logger.getLogger(TestNorth.class.getName());
    
    private JButton buttonOne, buttonTwo, buttonMiddle, buttonAlpha, buttonBravo, buttonSouth;
    
    public static void main(String[] args) {
        TestNorth app = new TestNorth();
    }
    
    public TestNorth() {
        super("TestNorth");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setContentPane(createPanel());
        
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
        buttonOne = createButton("One");
        buttonTwo = createButton("Two");
        buttonMiddle = createButton("Middle");
        buttonAlpha = createButton("Alpha");
        buttonBravo = createButton("Bravo");
        buttonSouth = createButton("South");

        JPanel mainPanel = layoutNorthwestNorthNortheastSouth(
                layoutButtons(new JComponent[] {buttonOne, buttonTwo}),
                null,
//                layoutButtons(new JComponent[] {buttonMiddle}),
                layoutButtons(new JComponent[] {buttonAlpha, buttonBravo}),
                layoutButtons(new JComponent[] {buttonSouth}));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

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