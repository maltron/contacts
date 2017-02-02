package net.nortlam.contacts.extra;

import java.io.Serializable;

/**
 *
 * @author Mauricio "Maltron" Leal <maltron at gmail dot com> */
public class Record implements Serializable {

    static String[] headers = {"Record Number", "Batch Number", "Reserved"};
    static int counter;
    private String[] data;

    public Record() {
        data = new String[]{"" + (counter++),
            "" + System.currentTimeMillis(), "Reserved"};
    }

    public String getValueAt(int i) {
        return data[i];
    }

    public static String getColumnName(int i) {
        return headers[i];
    }

    public static int getColumnCount() {
        return headers.length;
    }
}
