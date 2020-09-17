package org.tensorflow.lite.examples.classification.models;

public class Library {

     private String TreeName;
     private String ScientificName;
     private String TreeImage;
     private String Description;

    public Library(String treeName, String scientificName, String treeImage, String description) {
        TreeName = treeName;
        ScientificName = scientificName;
        TreeImage = treeImage;
        Description = description;
    }

    public String getTreeName() {
        return TreeName;
    }

    public String getScientificName() {
        return ScientificName;
    }

    public String getTreeImage() {
        return TreeImage;
    }

    public String getDescription() {
        return Description;
    }

    public void setTreeName(String treeName) {
        TreeName = treeName;
    }

    public void setScientificName(String scientificName) {
        ScientificName = scientificName;}

    public void setTreeImage(String treeImage) {
        TreeImage = treeImage;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Library(){


    }
}
