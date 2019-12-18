package com.example.mymail;

public class CartItemModel {
    public  static  final  int CART_ITEM=0;
    public static  final  int TOTAL_AMOUNT=1;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private  int productimg;
    private String producttile;
    private  int freeCoupens;
    private String productPrice;
    private String cuttedPrice;
    private int proudctQuantitiy;
    private int offerApply;
    private  int coupensApply;

    public CartItemModel(int type, int productimg, String producttile, int freeCoupens, String productPrice, String cuttedPrice, int proudctQuantitiy, int offerApply, int coupensApply) {
        this.type = type;
        this.productimg = productimg;
        this.producttile = producttile;
        this.freeCoupens = freeCoupens;
        this.productPrice = productPrice;
        this.cuttedPrice = cuttedPrice;
        this.proudctQuantitiy = proudctQuantitiy;
        this.offerApply = offerApply;
        this.coupensApply = coupensApply;
    }

    public int getProductimg() {
        return productimg;
    }

    public void setProductimg(int productimg) {
        this.productimg = productimg;
    }

    public String getProducttile() {
        return producttile;
    }

    public void setProducttile(String producttile) {
        this.producttile = producttile;
    }

    public int getFreeCoupens() {
        return freeCoupens;
    }

    public void setFreeCoupens(int freeCoupens) {
        this.freeCoupens = freeCoupens;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getCuttedPrice() {
        return cuttedPrice;
    }

    public void setCuttedPrice(String cuttedPrice) {
        this.cuttedPrice = cuttedPrice;
    }

    public int getProudctQuantitiy() {
        return proudctQuantitiy;
    }

    public void setProudctQuantitiy(int proudctQuantitiy) {
        this.proudctQuantitiy = proudctQuantitiy;
    }

    public int getOfferApply() {
        return offerApply;
    }

    public void setOfferApply(int offerApply) {
        this.offerApply = offerApply;
    }

    public int getCoupensApply() {
        return coupensApply;
    }

    public void setCoupensApply(int coupensApply) {
        this.coupensApply = coupensApply;
    }

    private String totalItems;
    private  String totalItemsPrice;
    private String deliveryPrices;
    private  String saveAmnounts;
    private String totalAmounts;

    public CartItemModel(int type, String totalItems, String totalItemsPrice, String deliveryPrices,String totalAmounts, String saveAmnounts) {
        this.type = type;
        this.totalItems = totalItems;
        this.totalItemsPrice = totalItemsPrice;
        this.deliveryPrices = deliveryPrices;
        this.saveAmnounts = saveAmnounts;
        this.totalAmounts=totalAmounts;
    }

    public String getTotalAmounts() {
        return totalAmounts;
    }

    public void setTotalAmounts(String totalAmounts) {
        this.totalAmounts = totalAmounts;
    }


    public String getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(String totalItems) {
        this.totalItems = totalItems;
    }

    public String getTotalItemsPrice() {
        return totalItemsPrice;
    }

    public void setTotalItemsPrice(String totalItemsPrice) {
        this.totalItemsPrice = totalItemsPrice;
    }

    public String getDeliveryPrices() {
        return deliveryPrices;
    }

    public void setDeliveryPrices(String deliveryPrices) {
        this.deliveryPrices = deliveryPrices;
    }

    public String getSaveAmnounts() {
        return saveAmnounts;
    }

    public void setSaveAmnounts(String saveAmnounts) {
        this.saveAmnounts = saveAmnounts;
    }
}
