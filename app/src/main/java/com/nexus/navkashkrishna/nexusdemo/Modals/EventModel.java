package com.nexus.navkashkrishna.nexusdemo.Modals;


import java.util.ArrayList;

/**
 * Created by Aditya on 02-02-2017.
 */

public class EventModel {

    public String about;
    public String details;
    public String rules;

    public EventModel(String about, String details, String rules) {
        this.about=about;
        this.rules = rules;
        this.details=details;
    }
    public EventModel()
    {

    }


    public String getAbout() { return about;
    }

    public String getDetails() {
        return details;
    }

    public String getRules() {
        return rules;
    }

}

