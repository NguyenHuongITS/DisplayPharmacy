package com.example.nguyenhuongit.displaypharmacy.View.Activity;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.nguyenhuongit.displaypharmacy.Adapter.ViewPagerAdapter;
import com.example.nguyenhuongit.displaypharmacy.R;
import com.example.nguyenhuongit.displaypharmacy.View.Fragment.FragmentItem1;
import com.example.nguyenhuongit.displaypharmacy.View.Fragment.FragmentItem2;
import com.example.nguyenhuongit.displaypharmacy.View.Fragment.FragmentItem3;
import com.example.nguyenhuongit.displaypharmacy.View.Fragment.FragmentItem4;

public class MainActivity extends AppCompatActivity {

    //Layout
    public TabLayout tab_layout_main;
    public ViewPager view_pager_main;
    public AppBarLayout app_bar_layout_main;
    public ViewPagerAdapter viewPagerAdapter;
    public Context context;

    //fragment
    public FragmentItem1 fragmentItem1 = new FragmentItem1();
    public FragmentItem2 fragmentItem2 = new FragmentItem2();
    public FragmentItem3 fragmentItem3 = new FragmentItem3();
    public FragmentItem4 fragmentItem4 = new FragmentItem4();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //ẩn thanh trạng thái
        HideActionBar();
        //ánh xạ
        Mapping();
        //Add fragment
        AddFragment();
    }

    private void HideActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    private void Mapping() {
        app_bar_layout_main = (AppBarLayout) findViewById(R.id.app_bar_layout_main);
        view_pager_main = (ViewPager) findViewById(R.id.view_pager_main);
        tab_layout_main = (TabLayout) findViewById(R.id.tab_layout_main);
    }

    private void AddFragment() {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        //add fragment adapter
        viewPagerAdapter.AddFragment(fragmentItem1, "Home");
        viewPagerAdapter.AddFragment(fragmentItem2, "Wishlist ");
        viewPagerAdapter.AddFragment(fragmentItem3, "My Order");
        viewPagerAdapter.AddFragment(fragmentItem4, "Profile");
        view_pager_main.setAdapter(viewPagerAdapter);
        tab_layout_main.setupWithViewPager(view_pager_main);

        //set icon
        tab_layout_main.getTabAt(0).setIcon(R.drawable.icon_32_home);
        tab_layout_main.getTabAt(1).setIcon(R.drawable.icon_32_like);
        tab_layout_main.getTabAt(2).setIcon(R.drawable.icon_32_bag);
        tab_layout_main.getTabAt(3).setIcon(R.drawable.icon_32_user);

        //set color icon
        tab_layout_main.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.tablayout_select), PorterDuff.Mode.SRC_IN);
        tab_layout_main.getTabAt(1).getIcon().setColorFilter(getResources().getColor(R.color.tablayout_noselect), PorterDuff.Mode.SRC_IN);
        tab_layout_main.getTabAt(2).getIcon().setColorFilter(getResources().getColor(R.color.tablayout_noselect), PorterDuff.Mode.SRC_IN);
        tab_layout_main.getTabAt(3).getIcon().setColorFilter(getResources().getColor(R.color.tablayout_noselect), PorterDuff.Mode.SRC_IN);

        tab_layout_main.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.tablayout_select), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.tablayout_noselect), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
