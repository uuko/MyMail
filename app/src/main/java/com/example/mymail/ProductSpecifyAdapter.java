package com.example.mymail;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductSpecifyAdapter extends RecyclerView.Adapter<ProductSpecifyAdapter.ViewHolder> {

   private List<ProductSpecifyModel> productSpecifyModelList;

    public ProductSpecifyAdapter(List<ProductSpecifyModel> productSpecifyModelList) {
        this.productSpecifyModelList=productSpecifyModelList;
    }

    @NonNull
    @Override
    public ProductSpecifyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       switch (viewType){
           case  ProductSpecifyModel.SPEFICATION_TITLE:
               TextView title=new TextView(parent.getContext());
               title.setTypeface(null, Typeface.BOLD);
               title.setTextColor(Color.BLACK);
               LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
               layoutParams.setMargins(setDp(16,parent.getContext()),
                       setDp(16,parent.getContext()),setDp(16,parent.getContext()),
                       setDp(16,parent.getContext()));
               title.setLayoutParams(layoutParams);
               return new ViewHolder(title);

           case  ProductSpecifyModel.SPEFICATION_BODY:
               View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_specify_item_layout,parent,false);
               return new ViewHolder(view);
               default:
                   return null;
       }


    }
    private  int setDp(int dp, Context context){
        return (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,context.getResources().getDisplayMetrics());
    }
    @Override
    public int getItemViewType(int position) {
        switch (productSpecifyModelList.get(position).getType()){
            case 0:
                return  ProductSpecifyModel.SPEFICATION_TITLE;
            case 1:
                return  ProductSpecifyModel.SPEFICATION_BODY;
                default:
                    return -1;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ProductSpecifyAdapter.ViewHolder holder, int position) {
        switch (productSpecifyModelList.get(position).getType()){
            case ProductSpecifyModel.SPEFICATION_TITLE:
                holder.setTitle(productSpecifyModelList.get(position).getTitle());
            case ProductSpecifyModel.SPEFICATION_BODY:
                String featureTitle=productSpecifyModelList.get(position).getFeatureName();
                String featuredetail=productSpecifyModelList.get(position).getFeatureValue();
                Log.d("959", "onBindViewHolder: "+featureTitle);
                holder.SetFeatures(featureTitle,featuredetail);
                break;
                default:return ;
    }



    }

    @Override
    public int getItemCount() {
        Log.d("478", "getItemCount: "+productSpecifyModelList.size());
        return productSpecifyModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView featureName;
        private TextView featureValue;
        private TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            featureName=itemView.findViewById(R.id.feature_name);
            featureValue=itemView.findViewById(R.id.feature_value);
        }
        private void setTitle(String titleText){
            title=(TextView) itemView;
            title.setText(titleText);
        }
        private void  SetFeatures(String featureTitle,String featuredetail){
            if (featureTitle==null){

            }else {
                featureName.setText(featureTitle);
                featureValue.setText(featuredetail);
            }

        }
    }
}
