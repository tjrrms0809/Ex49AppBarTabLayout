package com.ahnsafety.ex49appbartablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Myadapter extends FragmentPagerAdapter {

    Fragment[] fragments=new Fragment[3];
    String[] pageTitles= new String[]{"Home","Them","Talk"};

    public Myadapter(@NonNull FragmentManager fm) {
        super(fm);

        fragments[0]= new Page1Fragment();
        fragments[1]= new Page2Fragment();
        fragments[2]= new Page3Fragment();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    //뷰페이저와 연동된 탭레이아웃의 탭버튼들의
    //글씨를 리턴해주는 메소드


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitles[position];
    }
}
