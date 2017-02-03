package net.nortlam.contacts;

import java.awt.BorderLayout;
import java.util.Properties;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.nortlam.contacts.extra.PagingModel;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;

import static net.nortlam.design.LayoutUtil.*;

/**
 *
 * @author Mauricio "Maltron" Leal <maltron at gmail dot com> */
@ConvertAsProperties(dtd = "-//net.nortlam.contacts//Contacts//EN", autostore = false)
public class ContactsTopComponent extends TopComponent {

    private static ContactsTopComponent instance;
    /** path to the icon used by the component and its open action */
//    static final String ICON_PATH = "SET/PATH/TO/ICON/HERE";
    private static final String PREFERRED_ID = "ContactsTopComponent";
    
    private JTable table;
    private JScrollPane scrollPane;
    
    private InstanceContent ic = new InstanceContent();
    
    public ContactsTopComponent() {
        initComponents();
        setName("Contacts");
//        setToolTipText(Bundle.HINT_ExampleTopComponent());
        
        associateLookup(new AbstractLookup(ic));
    }
    
    private void initComponents() {
        PagingModel model = new PagingModel();
        table = new JTable(model);
        
        scrollPane = PagingModel.createPagingScrollPaneForTable(table);
        
        // Laying Out
        setLayout(new BorderLayout());
        setBorder(borderEmpty());
        add(scrollPane);
    }
    
    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link #findInstance}.
     */
    public static synchronized ContactsTopComponent getDefault() {
        if (instance == null) {
            instance = new ContactsTopComponent();
        }
        return instance;
    }

    /**
     * Obtain the ContactsTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized ContactsTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            Logger.getLogger(ContactsTopComponent.class.getName()).warning(
                    "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof ContactsTopComponent) {
            return (ContactsTopComponent) win;
        }
        Logger.getLogger(ContactsTopComponent.class.getName()).warning(
                "There seem to be multiple components with the '" + PREFERRED_ID
                + "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }

    @Override
    public int getPersistenceType() {
        //return TopComponent.PERSISTENCE_ALWAYS;
        return TopComponent.PERSISTENCE_NEVER;
    }

    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    private void writeProperties(Properties properties) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        properties.setProperty("version", "1.0");
        // TODO store your settings
    }

    private Object readProperties(Properties properties) {
        if (instance == null) {
            instance = this;
        }
        instance.readPropertiesImpl(properties);
        return instance;
    }

    private void readPropertiesImpl(Properties properties) {
        String version = properties.getProperty("version");
        // TODO read your settings according to their version
    }

    @Override
    protected String preferredID() {
        return PREFERRED_ID;
    }
}
