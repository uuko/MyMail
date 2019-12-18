package com.example.mymail;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HorizonalProductAdapter extends RecyclerView.Adapter<HorizonalProductAdapter.ViewHolder> {

    private List<HorizonalProductModel> horizonalProductModelList;
    @NonNull
    @Override
    public HorizonalProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.horizonal_scroll_item,parent,false);

        return new ViewHolder(view);
    }

    public HorizonalProductAdapter(List<HorizonalProductModel> horizonalProductModelList) {
        this.horizonalProductModelList = horizonalProductModelList;
    }

    @Override
    public void onBindViewHolder(@NonNull HorizonalProductAdapter.ViewHolder holder, int position) {
           int resource=horizonalProductModelList.get(position).getProduceImg();
           String price=horizonalProductModelList.get(position).getProducePrice();
           String des=horizonalProductModelList.get(position).getProduceDescript();
           String title=horizonalProductModelList.get(position).getProduceTitle();
           holder.setProductdes(des);
           holder.setProductimg(resource);
           holder.setProducttitle(title);
           holder.setProductprices(price);
    }

    @Override
    public int getItemCount() {
        return horizonalProductModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView productimg;
        private TextView producttitle;
        private TextView productdes;
        private TextView productprices;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            productimg=itemView.findViewById(R.id.h_s_product);
            productdes=itemView.findViewById(R.id.h_s_descipt);
            productprices=itemView.findViewById(R.id.h_s_product_price);
            producttitle=itemView.findViewById(R.id.h_s_product_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productdetailontent=new Intent(itemView.getContext(),ProductDetailsActivity.class);
                    itemView.getContext().startActivity(productdetailontent);
                }
            });
        }
        private void setProductimg(int resource){
            productimg.setImageResource(resource);
        }
        private void  setProducttitle(String title){
            producttitle.setText(title);
        }
        private void  setProductdes(String des){
            productdes.setText(des);
        }
        private void  setProductprices(String price){
            productprices.setText(price);
        }

    }
}
