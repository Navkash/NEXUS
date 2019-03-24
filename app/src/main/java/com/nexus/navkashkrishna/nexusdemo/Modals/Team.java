package com.nexus.navkashkrishna.nexusdemo.Modals;

public class Team {

    private String name, desg, phone, imageSrc,whatsApp,gitHub;
    private int image;

    public Team(String name, String desg, String phone, String imageSrc,String whatsApp) {
        this.imageSrc = imageSrc;
        this.name = name;
        this.desg = desg;
        this.phone = phone;
        this.whatsApp= whatsApp;
    }

    public Team(String name, String desg, String phone, int image,String whatsApp) {
        this.image=image;
        this.name = name;
        this.desg = desg;
        this.phone = phone;
        this.whatsApp= whatsApp;
    }

    public Team(String name, String desg, String phone, String gitHub, String imageSrc,String whatsApp) {
        this.imageSrc = imageSrc;
        this.name = name;
        this.desg = desg;
        this.gitHub = gitHub;
        this.phone = phone;
        this.whatsApp= whatsApp;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public String getName() {
        return name;
    }

    public String getDesg() {
        return desg;
    }

    public String getPhone() {
        return phone;
    }

    public String getWhatsApp() {
        return whatsApp;
    }

    public String getGitHub() { return gitHub; }

    public int getImage() { return  image; }
}
