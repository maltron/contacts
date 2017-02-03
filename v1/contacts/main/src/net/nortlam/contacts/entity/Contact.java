package net.nortlam.contacts.entity;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauricio "Maltron" Leal <maltron at gmail dot com> */
public class Contact implements Serializable {

    private static final Logger LOG = Logger.getLogger(Contact.class.getName());
    
    private Title title;
    private String email;
    private String firstName;
    private String lastName;
    private PhoneType phoneType;
    private String phone;

    public Contact() {
        LOG.log(Level.INFO, ">>> Contact()");
    }


}
