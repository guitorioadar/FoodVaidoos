package com.vaidoos.foodvaidoos.model;

public class ViewPagerWizardModel {

    public int images;
    public String title;
    public String slogan;

    public ViewPagerWizardModel() {
    }

    public ViewPagerWizardModel(int images, String title, String slogan) {
        this.images = images;
        this.title = title;
        this.slogan = slogan;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }
}
