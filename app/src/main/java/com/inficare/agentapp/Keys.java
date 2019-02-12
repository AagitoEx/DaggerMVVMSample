package com.inficare.agentapp;

public class Keys {

    static {
        System.loadLibrary("keys");
    }

    private native String getAPIKEY();

    private native String getAPISECRET();

    private static Keys INSTANCE;

    public static Keys getInstance() {

        if (INSTANCE == null)
            INSTANCE = new Keys();

        return INSTANCE;
    }

    public String getApiKey() {
        return getAPIKEY();
    }
}
