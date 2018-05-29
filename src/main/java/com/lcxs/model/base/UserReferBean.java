package com.lcxs.model.base;
import java.util.*;

public class UserReferBean {
    private String userName = "";

    public String getUserName() {
        return userName;
    }

    public ArrayList<String> getRefers() {
        return refers;
    }

    private ArrayList<String> refers = new ArrayList<String>();

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRefers(ArrayList<String> refers) {
        this.refers = refers;
    }
}
