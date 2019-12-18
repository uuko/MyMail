package com.example.mymail;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter {

    private List<CartItemModel> cartItemModelList;

    public CartAdapter(List<CartItemModel> cartItemModelList) {
        this.cartItemModelList=cartItemModelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (cartItemModelList.get(position).getType()){
            case 0:
                return CartItemModel.CART_ITEM;
            case 1:
                return CartItemModel.TOTAL_AMOUNT;
                default:return -1;
        }

    }

    @NonNull
    //加載view 並生成viewholder綁定view
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType){
            case CartItemModel.CART_ITEM:
                View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_layout,parent,false);
                return  new CartItemViewholder(view);
            case CartItemModel.TOTAL_AMOUNT:
                View view1= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_total_item_layout,parent,false);
                return new CartAmountViewholder(view1);
            default:
            return  null;
        }

    }
    //更新view 綁數據(model) 點擊事件
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (cartItemModelList.get(position).getType()){
            case  CartItemModel.CART_ITEM:
                int resource=cartItemModelList.get(position).getProductimg();
                String title=cartItemModelList.get(position).getProducttile();
                int freeCoupen=cartItemModelList.get(position).getFreeCoupens();
                String productPricest=cartItemModelList.get(position).getProductPrice();
                String cuttedPrice=cartItemModelList.get(position).getCuttedPrice();
                int offerAppply=cartItemModelList.get(position).getOfferApply();
                Log.d("999", "onBindViewHolder: "+cuttedPrice);
            ((CartItemViewholder)holder).setDetails(resource,title,freeCoupen,productPricest,cuttedPrice,offerAppply);
                break;
            case CartItemModel.TOTAL_AMOUNT:
                String totalitem=cartItemModelList.get(position).getTotalItems();
                String totalitemprice=cartItemModelList.get(position).getTotalItemsPrice();
                String deliveryprice=cartItemModelList.get(position).getDeliveryPrices();
                String totalamount=cartItemModelList.get(position).getTotalAmounts();
                String saveAmount=cartItemModelList.get(position).getSaveAmnounts();
                ((CartAmountViewholder)holder).setTotalAmount(totalitem,totalitemprice,deliveryprice,totalamount,saveAmount);
                break;
                default:
                    return;
        }
    }
    //  MODEL長度 (數據多少)
    @Override
    public int getItemCount() {
        return cartItemModelList.size();
    }

    class  CartItemViewholder extends RecyclerView.ViewHolder{
        private ImageView prouctImg;
        private ImageView freeCoupenIcon;
        private TextView productTitle;
        private TextView freeCoupen;
        private TextView productPrice;
        private TextView cuttedPrice;
        private TextView offerApply;
        private TextView coupenApply;
        private TextView productQuantity;
        public CartItemViewholder(@NonNull View itemView) {
            super(itemView);
            prouctImg=itemView.findViewById(R.id.product_image);
            productTitle=itemView.findViewById(R.id.product_title);
            freeCoupenIcon=itemView.findViewById(R.id.free_coupen_icon);
            freeCoupen=itemView.findViewById(R.id.tv_free_coupen);
            productPrice=itemView.findViewById(R.id.product_price);
            cuttedPrice=itemView.findViewById(R.id.cuted_price);
            offerApply=itemView.findViewById(R.id.ofers_apply);
            coupenApply=itemView.findViewById(R.id.coupen_apply);
            productQuantity=itemView.findViewById(R.id.product_quanity);

        }
        private void setDetails(int resource,String title,int freeCoupensNo,
                                String productPricetext,String cuttedPriceText,
                                int offersApplyNo){
            prouctImg.setImageResource(resource);
            productTitle.setText(title);
            if (freeCoupensNo>0){
                freeCoupen.setVisibility(View.VISIBLE);
                freeCoupenIcon.setVisibility(View.VISIBLE);
                if (freeCoupensNo==1){
                    freeCoupen.setText("free"+freeCoupensNo+"Coupen");
                }else {
                    freeCoupen.setText("free"+freeCoupensNo+"Coupen");
                }

            } else {
                freeCoupen.setVisibility(View.INVISIBLE);
                freeCoupenIcon.setVisibility(View.INVISIBLE);
            }
            productPrice.setText(productPricetext);
            cuttedPrice.setText(cuttedPriceText);


            if (offersApplyNo >0){
                offerApply.setVisibility(View.VISIBLE);
                offerApply.setText(offersApplyNo+"offersApply");
            }else {
                offerApply.setVisibility(View.INVISIBLE);
            }
        }
    }
    class  CartAmountViewholder extends RecyclerView.ViewHolder {
        private TextView totalitems;
        private TextView totalitemsprices;
        private TextView deliveryPrice;
        private TextView totalAmount;
        private TextView saveAmount;
        public CartAmountViewholder(@NonNull View itemView) {
            super(itemView);
            totalitems=itemView.findViewById(R.id.total_items);
            totalitemsprices=itemView.findViewById(R.id.total_items_price);
            deliveryPrice=itemView.findViewById(R.id.delivory_prcie);
            totalAmount=itemView.findViewById(R.id.total_price);
            saveAmount=itemView.findViewById(R.id.saved_amount);
        }
        private void setTotalAmount(String totalitemsText,String totalitemsprice,
                                    String deliverypricetext,String totalamounttext,
                                    String saveamounttext
        ){
            totalitems.setText(totalitemsText);
            totalitemsprices.setText(totalitemsprice);
            deliveryPrice.setText(deliverypricetext);
            totalAmount.setText(totalamounttext);
            saveAmount.setText(saveamounttext);
        }
    }
}
