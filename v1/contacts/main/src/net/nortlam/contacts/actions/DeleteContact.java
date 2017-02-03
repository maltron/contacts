package net.nortlam.contacts.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import net.nortlam.contacts.entity.Contact;

/**
 *
 * @author Mauricio "Maltron" Leal <maltron at gmail dot com> */
public class DeleteContact implements ActionListener {

    private List<Contact> contacts;

    public DeleteContact(List<Contact> contacts) {
        this.contacts = contacts;
    }

    // ACTION LISTENER ACTION LISTENER ACTION LISTENER ACTION LISTENER ACTION LISTENER 
    //  ACTION LISTENER ACTION LISTENER ACTION LISTENER ACTION LISTENER ACTION LISTENER 

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.printf(">>> DeleteContact\n");
        for(Contact contact: contacts) {
            
        }
    }
}
