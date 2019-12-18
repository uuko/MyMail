package com.example.mymail;

public class ProductSpecifyModel {

    public static final int SPEFICATION_TITLE=0;
    public  static  final  int SPEFICATION_BODY=1;

    private  int type;
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

    //////////////title
    private  String title;

    public ProductSpecifyModel(int type,String title) {
        this.type=type;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    ///////////////body
    private String featureName;
    private String featureValue;

    public ProductSpecifyModel(int type, String featureName, String featureValue) {
        this.type = type;
        this.featureName = featureName;
        this.featureValue = featureValue;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getFeatureValue() {
        return featureValue;
    }

    public void setFeatureValue(String featureValue) {
        this.featureValue = featureValue;
    }
}
