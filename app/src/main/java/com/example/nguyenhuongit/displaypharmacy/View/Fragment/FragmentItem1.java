package com.example.nguyenhuongit.displaypharmacy.View.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nguyenhuongit.displaypharmacy.Adapter.LookingAdapter;
import com.example.nguyenhuongit.displaypharmacy.Adapter.SellingAdapter;
import com.example.nguyenhuongit.displaypharmacy.Adapter.SlideShowAdapter;
import com.example.nguyenhuongit.displaypharmacy.Data.Looking;
import com.example.nguyenhuongit.displaypharmacy.Data.Selling;
import com.example.nguyenhuongit.displaypharmacy.Data.SlideShow;
import com.example.nguyenhuongit.displaypharmacy.R;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class FragmentItem1 extends Fragment {

    //khai báo đối tượng cho slideshow
    private static ViewPager view_pager_slideshow;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private ArrayList<SlideShow> slideShowArrayList;

    //khai báo list image slideshow
    private int[] myImageList = new int[]{R.drawable.image_slideshow_1, R.drawable.image_slideshow_2,
            R.drawable.image_slideshow_3,R.drawable.image_slideshow_4};

    //recycleview 1
    RecyclerView recycleview_looking;
    LookingAdapter lookingAdapter;
    List<Looking> lookingList = new ArrayList<>();

    //recycleview 2
    RecyclerView recycleview_selling;
    SellingAdapter sellingAdapter;
    List<Selling> sellingList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_item_1,container, false);
        //tạo list slideshow
        slideShowArrayList = new ArrayList<>();
        slideShowArrayList = populateList();

        //ánh xạ và set apdater cho viewpager
        view_pager_slideshow = (ViewPager) view.findViewById(R.id.view_pager_slideshow);
        view_pager_slideshow.setAdapter(new SlideShowAdapter(getContext(),slideShowArrayList));

        //khai báo indicator
        CirclePageIndicator indicator = (CirclePageIndicator) view.findViewById(R.id.circle_indicator);
        indicator.setViewPager(view_pager_slideshow);
        indicator.setRadius(12);

        //set page equals arraylist
        NUM_PAGES =slideShowArrayList.size();

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                view_pager_slideshow.setCurrentItem(currentPage++, true);
            }
        };

        //time swap image
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 1000, 3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

        //recycleview looking
        recycleview_looking = view.findViewById(R.id.recycleview_looking);
        LookingRecycleviewData();
        //recycleview selling
        recycleview_selling = view.findViewById(R.id.recycleview_selling);
        SellingRecycleviewData();


        return view;
    }

    //list
    private ArrayList<SlideShow> populateList() {
        ArrayList<SlideShow> list = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            SlideShow slideShow = new SlideShow();
            slideShow.setImage_drawable(myImageList[i]);
            list.add(slideShow);
        }
        return list;
    }

    //data recycleview looking
    private void LookingRecycleviewData() {
        //Data
        Looking looking = new Looking(R.drawable.icon_64_user,"Prescription\nMedication");
        lookingList.add(looking);
        looking = new Looking(R.drawable.icon_64_user,"Prescription\nMedication");
        lookingList.add(looking);
        looking = new Looking(R.drawable.icon_64_user,"Prescription\nMedication");
        lookingList.add(looking);
        looking = new Looking(R.drawable.icon_64_user,"Prescription\nMedication");
        lookingList.add(looking);
        looking = new Looking(R.drawable.icon_64_user,"Prescription\nMedication");
        lookingList.add(looking);

        //set layout recycleview
        lookingAdapter = new LookingAdapter(getContext(),R.layout.item_recycleview_looking,lookingList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recycleview_looking.setLayoutManager(linearLayoutManager);
        recycleview_looking.setItemAnimator(new DefaultItemAnimator());
        recycleview_looking.setAdapter(lookingAdapter);
        lookingAdapter.notifyDataSetChanged();
    }

    //data recycleview selling
    private void SellingRecycleviewData() {
        //data
        Selling selling = new Selling(R.drawable.icon_64_home,"Prescription\nMedication");
        sellingList.add(selling);
        selling = new Selling(R.drawable.icon_64_home,"Prescription\nMedication");
        sellingList.add(selling);
        selling = new Selling(R.drawable.icon_64_home,"Prescription\nMedication");
        sellingList.add(selling);
        selling = new Selling(R.drawable.icon_64_home,"Prescription\nMedication");
        sellingList.add(selling);

        //set layout recycleview
        sellingAdapter = new SellingAdapter(getContext(),R.layout.item_recycleview_selling,sellingList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recycleview_selling.setLayoutManager(linearLayoutManager);
        recycleview_selling.setItemAnimator(new DefaultItemAnimator());
        recycleview_selling.setAdapter(sellingAdapter);
        sellingAdapter.notifyDataSetChanged();

    }
}
