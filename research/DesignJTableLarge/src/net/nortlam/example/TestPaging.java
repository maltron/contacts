package net.nortlam.example;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import static net.nortlam.design.LayoutUtil.*;

/**
 *
 * @author Mauricio "Maltron" Leal <maltron at gmail dot com> */
public class TestPaging extends JFrame implements Serializable, ActionListener, KeyListener {

    private static final Logger LOG = Logger.getLogger(TestPaging.class.getName());
    
    private JTable table;
    private JScrollPane scrollPane;
    private JButton buttonExit;
    
    public static void main(String[] args) {
        TestPaging app = new TestPaging();
    }
    
    public TestPaging() {
        super("TestPaging");
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
        PagingModel model = new PagingModel();
        table = new JTable(model);
        scrollPane = PagingModel.createPagingScrollPaneForTable(table);
        
        buttonExit = createButton("Exit");
        buttonExit.requestFocus();
    }
    
    private JPanel createPanel() {
        JPanel panelButtons = layoutButtons(buttonExit);
        
        JPanel panelTable = new JPanel(new BorderLayout());
        panelTable.setBorder(borderEmpty());
        panelTable.add(scrollPane, BorderLayout.CENTER);
        panelTable.add(layoutNortheast(panelButtons), BorderLayout.SOUTH);
        
        return panelTable;
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