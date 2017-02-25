package com.example.lijie.kitchen;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lijie.kitchen.fragment.CookBookFragment;
import com.example.lijie.kitchen.fragment.MineFragment;
import com.example.lijie.kitchen.fragment.TakeAwayFragment;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;

import me.majiajie.pagerbottomtabstrip.Controller;
import me.majiajie.pagerbottomtabstrip.PagerBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectListener;

public class MainActivity extends AppCompatActivity implements OnTabItemSelectListener {
        private PagerBottomTabLayout bottomTabLayout;
        Controller controller;
        FragmentManager mFragmentManager = getSupportFragmentManager();
        ArrayList<Fragment> mFragments = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragments.add(new CookBookFragment());
        mFragments.add(new TakeAwayFragment());
        mFragments.add(new MineFragment());

        bottomTabLayout = (PagerBottomTabLayout) findViewById(R.id.tab);

        controller
                 =bottomTabLayout.builder()
                .addTabItem(R.drawable.cookmenu, "菜谱")
                .addTabItem(R.drawable.takeaway, "外卖")
                .addTabItem(R.drawable.mine, "我的")
                .setDefaultColor(Color.rgb(0xB2,0xD7,0xD2))
                .build();
        controller.setBackgroundColor(Color.rgb(0,79,0x6B));
        controller.addTabItemClickListener(this);
    }

    @Override
    public void onSelected(int index, Object tag) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout,mFragments.get(index));
        transaction.commit();
    }

    @Override
    public void onRepeatClick(int index, Object tag) {

    }
}
