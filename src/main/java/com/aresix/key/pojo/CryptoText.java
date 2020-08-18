package com.aresix.key.pojo;

import com.aresix.key.utils.AES256;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CryptoText {
    private String context;

    public CryptoText(String context) {
        this.context = context;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public static String answer(String origin) throws Exception {
        String rep = AES256.decryptAES(origin).trim();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date()) + ":\t==========\n" + rep + "\n//===========Aresix已读===========";
    }
}
