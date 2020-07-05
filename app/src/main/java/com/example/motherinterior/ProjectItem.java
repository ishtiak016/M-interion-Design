package com.example.motherinterior;

public class ProjectItem {


    private String[] allImages;

    private String mimage;
    private String mproject_name;
    private String mdescription;
    private String mlocation;


    public ProjectItem(String mimage, String mproject_name, String mdescription, String mlocation) {
        this.mimage = mimage;
        this.mproject_name = mproject_name;
        this.mdescription = mdescription;
        this.mlocation = mlocation;
    }


    public ProjectItem() {
    }

    public String getMimage() {
        return mimage;
    }

    public void setMimage(String mimage) {
        this.mimage = mimage;
    }

    public String getMproject_name() {
        return mproject_name;
    }

    public void setMproject_name(String mproject_name) {
        this.mproject_name = mproject_name;
    }

    public String getMdescription() {
        return mdescription;
    }

    public void setMdescription(String mdescription) {
        this.mdescription = mdescription;
    }

    public String getMlocation() {
        return mlocation;
    }

    public void setMlocation(String mlocation) {
        this.mlocation = mlocation;
    }

    public String[] getAllImages() {
        return allImages;
    }

    public void setAllImages(String[] allImages) {
        this.allImages = allImages;
    }
}
