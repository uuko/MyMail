package com.example.mymail;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class ProductImagesAdapter extends PagerAdapter {

    private List<Integer> productImage;

    public ProductImagesAdapter(List<Integer> productImage) {
        this.productImage = productImage;
    }

    @Override
    public int getCount() {
        return productImage.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView productImgView = new ImageView(container.getContext());
        productImgView.setImageResource(productImage.get(position));
        container.addView(productImgView,0);
        return productImgView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((ImageView)object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
}
