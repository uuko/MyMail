package com.example.mymail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity {
    private ViewPager ProductImgviewPager;
    private TabLayout viewPagerTablayout;

    private TabLayout ProductDesTablayout;
    private ViewPager DesviewPager;
    private FloatingActionButton addwishBtn;
    private static  boolean Alredy_addedtowishlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addwishBtn=findViewById(R.id.add_to_wish_btn);
        ProductImgviewPager=findViewById(R.id.product_items_viewpager);
        viewPagerTablayout=findViewById(R.id.view_pager_indicater);
        DesviewPager=findViewById(R.id.product_des_viewpager);
        ProductDesTablayout=findViewById(R.id.product_des_tablayout);

        List<Integer> productimges=new ArrayList<>();
        productimges.add(R.drawable.common_google_signin_btn_text_dark_focused);
        productimges.add(R.drawable.ic_menu_manage);
        productimges.add(R.drawable.ic_email_black_24dp);

        ProductImagesAdapter productImagesAdapter=new ProductImagesAdapter(productimges);
        ProductImgviewPager.setAdapter(productImagesAdapter);
        viewPagerTablayout.setupWithViewPager(ProductImgviewPager,true);

        addwishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Alredy_addedtowishlist){
                    Alredy_addedtowishlist=false;
                    addwishBtn.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#9e9e9e")));
                }else {
                    Alredy_addedtowishlist=true;
                    addwishBtn.setSupportImageTintList(getResources().getColorStateList(R.color.red));
                }
            }
        });


        DesviewPager.setAdapter(new ProductDesAdapter(getSupportFragmentManager(),ProductDesTablayout.getTabCount()));
        DesviewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(ProductDesTablayout));
        ProductDesTablayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                DesviewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_and_cart, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id==android.R.id.home){
            finish();
            return true;
        }else if (id==R.id.main_notification_icon){
            return true;
        }else if (id==R.id.main_cart_icon){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
