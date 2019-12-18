package com.example.mymail;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ProductDesAdapter extends FragmentPagerAdapter {
    private int totalpages;
    public ProductDesAdapter(FragmentManager fm,int totalpages) {
        super(fm);
        this.totalpages=totalpages;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ProductDesFragment productDesFragment=new ProductDesFragment();
                return  productDesFragment;
                case 1:
                    ProductSpefiFragment productSpefiFragment=new ProductSpefiFragment();
                    return  productSpefiFragment;
            case 2:
                ProductDesFragment productDesFragment1=new ProductDesFragment();
                return  productDesFragment1;
        }
        return null;
    }

    @Override
    public int getCount() {
        return totalpages;
    }
}
