package net.nortlam.contacts;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauricio "Maltron" Leal <maltron at gmail dot com> */
public interface CRUD<T> extends Serializable {

    public void create(T t);
    public void read(T t);
    public void delete(T t);
}
