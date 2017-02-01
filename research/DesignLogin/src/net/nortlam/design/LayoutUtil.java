package net.nortlam.design;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * A set of methods to easier laying out components 
 *
 * @author Mauricio "Maltron" Leal <maltron at gmail dot com> */
public class LayoutUtil {
    
    public static final int DEFAULT_SPACE_BETWEEN_COMPONENTS = 5;

    public static JPanel layoutButtons(Component ... components) {
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(1, components.length,  
                                            DEFAULT_SPACE_BETWEEN_COMPONENTS, 0);
        panel.setLayout(layout);
        
        for(Component scan: components) panel.add(scan);
        
        return panel;
    }
    
    /**
     * It's important the length of both labels and texts match */
    public static JPanel layoutLabelText(Component[] labels, Component[] texts) {
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        
        if(labels == null) {
            System.err.printf("### ERROR: LayoutUtil: Labels Cannot be NULL\n");
            return null;
        }
        
        if(texts == null) {
            System.err.printf("### ERROR: LayoutUtil: Texts Cannot be NULL\n");
            return null;
        }
        
        if(labels.length != texts.length) {
            System.err.printf("### ERROR: LayoutUtil. Number of Labels and Texts must match\n");
            return null;
        }
        
        GridBagConstraints gc = new GridBagConstraints();
        for(int i=0; i < labels.length; i++) {
            int position = 0;
            gc.gridx = position; gc.gridy = i; gc.gridwidth = 1; gc.gridheight = 1;
            gc.insets.right = DEFAULT_SPACE_BETWEEN_COMPONENTS;
            if(i == labels.length -1) gc.insets.bottom = 0;
            else gc.insets.bottom = DEFAULT_SPACE_BETWEEN_COMPONENTS;
            gc.anchor = GridBagConstraints.WEST; gc.fill = GridBagConstraints.NONE;
            gc.weightx = 0.0; gc.weighty = 0.0;
            layout.setConstraints(labels[i], gc); panel.add(labels[i]);
            
            position++;
            gc.gridx = position; gc.gridy = i; gc.gridwidth = 1; gc.gridheight = 1;
            gc.insets.right = 0;
            gc.anchor = GridBagConstraints.CENTER; gc.fill = GridBagConstraints.HORIZONTAL;
            gc.weightx = 1.0; gc.weighty = 0.0;
            layout.setConstraints(texts[i], gc); panel.add(texts[i]);
        }
        
        return panel;
    }
    
    public static JPanel layoutNorthSoutheast(JComponent north, JComponent southeast) {
        JPanel panel = new JPanel(new BorderLayout());
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        
        GridBagConstraints gc = new GridBagConstraints();
        if(north != null) {
            gc.gridx = 0; gc.gridy = 0; gc.gridwidth = 1; gc.gridheight = 1;
            gc.anchor = GridBagConstraints.NORTH; gc.fill = GridBagConstraints.HORIZONTAL;
            gc.weightx = 1.0; gc.weighty = 1.0;
            layout.setConstraints(north, gc); panel.add(north);
        }
        
        if(southeast != null) {
            gc.gridx = 0; gc.gridy = 1; gc.gridwidth = 1; gc.gridheight = 1;
            gc.anchor = GridBagConstraints.SOUTHEAST; gc.fill = GridBagConstraints.NONE;
            gc.weightx = 1.0; gc.weighty = 1.0;
            layout.setConstraints(southeast, gc); panel.add(southeast);
        }
        
        return panel;
    }
    
    public static JPanel layoutNorthSouthwestSoutheast(JComponent north, 
                                    JComponent southwest, JComponent southeast) {
        JPanel panel = new JPanel(new BorderLayout());
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0; gc.gridy = 0; gc.gridwidth = 2; gc.gridheight = 1;
        gc.anchor = GridBagConstraints.NORTH; gc.fill = GridBagConstraints.HORIZONTAL;
        gc.weightx = 1.0; gc.weighty = 1.0;
        layout.setConstraints(north, gc); panel.add(north);
        
        gc.gridx = 0; gc.gridy = 1; gc.gridwidth = 1; gc.gridheight = 1;
        gc.anchor = GridBagConstraints.SOUTHWEST; gc.fill = GridBagConstraints.NONE;
        gc.weightx = 1.0; gc.weighty = 1.0;
        layout.setConstraints(southwest, gc); panel.add(southwest);
        
        gc.gridx = 1; gc.gridy = 1; gc.gridwidth = 1; gc.gridheight = 1;
        gc.anchor = GridBagConstraints.SOUTHEAST; gc.fill = GridBagConstraints.NONE;
        gc.weightx = 1.0; gc.weighty = 1.0;
        layout.setConstraints(southeast, gc); panel.add(southeast);
        
        return panel;
    }
    
    public static JPanel layoutNorthSouthwestSouthSoutheast(JComponent north, 
                       JComponent southwest, JComponent south, JComponent southeast) {
        
        JPanel panel = new JPanel(new BorderLayout());
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        
        GridBagConstraints gc = new GridBagConstraints();
        if(north != null) {
            gc.gridx = 0; gc.gridy = 0; gc.gridwidth = 3; gc.gridheight = 1;
            gc.anchor = GridBagConstraints.NORTH; gc.fill = GridBagConstraints.HORIZONTAL;
            gc.weightx = 1.0; gc.weighty = 1.0;
            layout.setConstraints(north, gc); panel.add(north);
        }
        
        if(southwest != null) {
            gc.gridx = 0; gc.gridy = 1; gc.gridwidth = 1; gc.gridheight = 1;
            gc.anchor = GridBagConstraints.SOUTHWEST; gc.fill = GridBagConstraints.NONE;
            gc.weightx = 1.0; gc.weighty = 1.0;
            layout.setConstraints(southwest, gc); panel.add(southwest);
        } 
        
        if(south != null) {
            gc.gridx = 1; gc.gridy = 1; gc.gridwidth = 1; gc.gridheight = 1;
            gc.anchor = GridBagConstraints.SOUTH; gc.fill = GridBagConstraints.NONE;
            gc.weightx = 1.0; gc.weighty = 1.0;
            layout.setConstraints(south, gc); panel.add(south);
        }
        
        if(southeast != null) {
            gc.gridx = 2; gc.gridy = 1; gc.gridwidth = 1; gc.gridheight = 1;
            gc.anchor = GridBagConstraints.SOUTHEAST; gc.fill = GridBagConstraints.NONE;
            gc.weightx = 1.0; gc.weighty = 1.0;
            layout.setConstraints(southeast, gc); panel.add(southeast);
        }
        
        return panel;
    }
    
    public static JPanel layoutNorthwest(JComponent northwest) {
        return layoutNorthwestNorthNortheastSouth(northwest, null, null, null);
    }
    
    public static JPanel layoutNortheast(JComponent northeast) {
        return layoutNorthwestNorthNortheastSouth(null, null, northeast, null);
    }
    
    public static JPanel layoutNorthwestNorthNortheastSouth(JComponent northwest, 
                       JComponent north, JComponent northeast, JComponent south) {
        
        JPanel panel = new JPanel(new BorderLayout());
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        
        GridBagConstraints gc = new GridBagConstraints();
        if(northwest != null) {
            gc.gridx = 0; gc.gridy = 0; gc.gridwidth = 1; gc.gridheight = 1;
            gc.anchor = GridBagConstraints.NORTHWEST; gc.fill = GridBagConstraints.NONE;
            gc.weightx = 1.0; gc.weighty = 1.0;
            layout.setConstraints(northwest, gc); panel.add(northwest);
        }
        
        if(north != null) {
            gc.gridx = 1; gc.gridy = 0; gc.gridwidth = 1; gc.gridheight = 1;
            gc.anchor = GridBagConstraints.NORTH; gc.fill = GridBagConstraints.NONE;
            gc.weightx = 1.0; gc.weighty = 1.0;
            layout.setConstraints(north, gc); panel.add(north);
        }
        
        if(northeast != null) {
            gc.gridx = 2; gc.gridy = 0; gc.gridwidth = 1; gc.gridheight = 1;
            gc.anchor = GridBagConstraints.NORTHEAST; gc.fill = GridBagConstraints.NONE;
            gc.weightx = 1.0; gc.weighty = 1.0;
            layout.setConstraints(northeast, gc); panel.add(northeast);
        }
        
        if(south != null) {
            gc.gridx = 0; gc.gridy = 1; gc.gridwidth = 3; gc.gridheight = 1;
            gc.anchor = GridBagConstraints.SOUTH; gc.fill = GridBagConstraints.HORIZONTAL;
            gc.weightx = 1.0; gc.weighty = 1.0;
            layout.setConstraints(south, gc); panel.add(south);
        }
        
        return panel;
    }
    
    public static JPanel layoutVertical(Component ... components) {
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        
        GridBagConstraints gc = new GridBagConstraints(); 
        for(int i=0; i < components.length; i++) {
            gc.gridx = 0; gc.gridy = i; gc.gridwidth = 1; gc.gridheight = 1;
            gc.anchor = GridBagConstraints.CENTER; gc.fill = GridBagConstraints.HORIZONTAL;
            gc.weightx = 1.0; gc.weighty = 0.0;
            if(i == components.length -1) gc.insets.bottom = 0;
            else gc.insets.bottom = DEFAULT_SPACE_BETWEEN_COMPONENTS;
            layout.setConstraints(components[i], gc); panel.add(components[i]);
        }
        
        return panel;
    }
    
    
    public static Border borderEmpty() {
        return BorderFactory.createEmptyBorder(DEFAULT_SPACE_BETWEEN_COMPONENTS,
                DEFAULT_SPACE_BETWEEN_COMPONENTS, DEFAULT_SPACE_BETWEEN_COMPONENTS,
                                                DEFAULT_SPACE_BETWEEN_COMPONENTS);
    }
    
    public static Border borderEtched() {
        return BorderFactory.createEtchedBorder();
    }
}
