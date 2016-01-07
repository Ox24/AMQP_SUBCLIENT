package com.company;

/**
 * Created by Timur on 03.01.2016.
 */
public class SubscribeManager {
    private static SubscribeManager ourInstance = new SubscribeManager();

    public static SubscribeManager getInstance() {
        return ourInstance;
    }

    private SubscribeManager() {
    }

    public void init(String host){

    }
}
