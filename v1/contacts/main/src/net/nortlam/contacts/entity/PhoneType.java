package net.nortlam.contacts.entity;

/**
 *
 * @author Mauricio "Maltron" Leal <maltron at gmail dot com> */
public enum PhoneType  {
    HOME("Home"), WORK("Work"), MOBILE("Mobile"), OTHER("Other");
    
    private String value;
    
    PhoneType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
