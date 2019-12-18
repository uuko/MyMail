package com.example.mymail;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
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
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_specify_item_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductSpecifyAdapter.ViewHolder holder, int position) {
        String featureTitle=productSpecifyModelList.get(position).getFeatureName();
        String featuredetail=productSpecifyModelList.get(position).getFeatureValue();
        holder.SetFeatures(featureTitle,featuredetail);
    }

    @Override
    public int getItemCount() {
        Log.d("478", "getItemCount: "+productSpecifyModelList.size());
        return productSpecifyModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView featureName;
        private TextView featureValue;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            featureName=itemView.findViewById(R.id.feature_name);
            featureValue=itemView.findViewById(R.id.feature_value);
        }
        private void  SetFeatures(String featureTitle,String featuredetail){
            featureName.setText(featureTitle);
            featureValue.setText(featuredetail);
        }
    }
}
