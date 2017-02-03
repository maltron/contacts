package net.nortlam.contacts.actions;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauricio "Maltron" Leal <maltron at gmail dot com> */
public class EditContactAction implements Serializable {

    private static final Logger LOG = Logger.getLogger(EditContactAction.class.getName());

    public EditContactAction() {
        LOG.log(Level.INFO, ">>> EditContactAction()");
    }


}
