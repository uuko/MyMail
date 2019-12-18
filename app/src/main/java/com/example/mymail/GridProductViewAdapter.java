package com.example.mymail;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GridProductViewAdapter extends BaseAdapter {
    List<HorizonalProductModel> horizonalProductModelList;

    public GridProductViewAdapter(List<HorizonalProductModel> horizonalProductModelList) {
        this.horizonalProductModelList = horizonalProductModelList;
    }
    //取得項目(Item)的數量。通常數量就是從建構子傳入的陣列或是集合大小。
    @Override
    public int getCount() {
        return 4;
    }
    //取得在這個position位置上的項目(Item)。position通常是資料在陣列或是集合上的位置。
    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        View view;

        TextView producttitle;
         TextView productdes;
        TextView productprices;
        if (convertView==null){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.horizonal_scroll_item,null);
           view.setElevation(0);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productDetailsintent=new Intent(parent.getContext(),ProductDetailsActivity.class);
                    parent.getContext().startActivity(productDetailsintent);
                }
            });
            ImageView productimg=view.findViewById(R.id.h_s_product);
            productdes=view.findViewById(R.id.h_s_descipt);
            productprices=view.findViewById(R.id.h_s_product_price);
            producttitle=view.findViewById(R.id.h_s_product_title);
            productimg.setImageResource(horizonalProductModelList.get(position).getProduceImg());
            productdes.setText(horizonalProductModelList.get(position).getProduceDescript());
            productprices.setText(horizonalProductModelList.get(position).getProducePrice());
            producttitle.setText(horizonalProductModelList.get(position).getProduceTitle());
        }else {
            view=convertView;
        }
        return view;
    }
}
