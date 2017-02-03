package net.nortlam.contacts.actions;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauricio "Maltron" Leal <maltron at gmail dot com> */
public class DeleteContactAction implements Serializable {

    private static final Logger LOG = Logger.getLogger(DeleteContactAction.class.getName());

    public DeleteContactAction() {
        LOG.log(Level.INFO, ">>> DeleteContactAction()");
    }


}
