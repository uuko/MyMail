package com.example.mymail;

public class HorizonalProductModel {

    private int produceImg;
    private String produceTitle;
    private String produceDescript;
    private String producePrice;

    public HorizonalProductModel(int produceImg, String produceTitle, String produceDescript, String producePrice) {
        this.produceImg = produceImg;
        this.produceTitle = produceTitle;
        this.produceDescript = produceDescript;
        this.producePrice = producePrice;
    }

    public int getProduceImg() {
        return produceImg;
    }

    public void setProduceImg(int produceImg) {
        this.produceImg = produceImg;
    }

    public String getProduceTitle() {
        return produceTitle;
    }

    public void setProduceTitle(String produceTitle) {
        this.produceTitle = produceTitle;
    }

    public String getProduceDescript() {
        return produceDescript;
    }

    public void setProduceDescript(String produceDescript) {
        this.produceDescript = produceDescript;
    }

    public String getProducePrice() {
        return producePrice;
    }

    public void setProducePrice(String producePrice) {
        this.producePrice = producePrice;
    }
}
