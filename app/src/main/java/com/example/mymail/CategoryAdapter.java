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

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private List<CategoryModel> categoryModelList;

    public CategoryAdapter(List<CategoryModel> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);
        return new ViewHolder(view);
    }

    @NonNull


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String icon=categoryModelList.get(position).getCategoryIconlink();
        String name=categoryModelList.get(position).getCategoryName();
        holder.setCategoryName(name);
        Log.d("test","name"+name);
    }




    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }

    public  class  ViewHolder extends  RecyclerView.ViewHolder{


        private ImageView categoryicon;
        private TextView categoryName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryicon=itemView.findViewById(R.id.category_home);
            categoryName=itemView.findViewById(R.id.category_name);
        }
        private void setCategoryicon( ){

        }
        private void setCategoryName(String name){
            categoryName.setText(name);
        }

    }
}
