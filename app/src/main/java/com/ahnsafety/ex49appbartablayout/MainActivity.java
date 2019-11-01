package com.ahnsafety.ex49appbartablayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;

    TabLayout tabLayout;

    ViewPager pager;
    Myadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar를 액션바로 대체하기
        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView=findViewById(R.id.nav);
        navigationView.setItemIconTintList(null);

        drawerLayout= findViewById(R.id.layout_drawer);
        drawerToggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        tabLayout=findViewById(R.id.layout_tab);
        //탭버튼(Tab객체) 생성
        TabLayout.Tab tab= null;

//        tab= tabLayout.newTab().setText("Home").setIcon(R.mipmap.ic_launcher);
////        //tab.setText("Home");
////        //tab.setIcon(R.mipmap.ic_launcher);
////        //setTag("tab1")
////        tabLayout.addTab(tab);
////
////        tab= tabLayout.newTab().setText("Theme").setIcon(R.mipmap.ic_launcher);
////        tabLayout.addTab(tab);
////
////        tab= tabLayout.newTab().setText("Talk").setIcon(R.mipmap.ic_launcher);
////        tabLayout.addTab(tab);

        pager=findViewById(R.id.pager);
        adapter=new Myadapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        //TabLayout과 ViewPager를 연동
        tabLayout.setupWithViewPager(pager);
        //주의! 뷰페이저와 연동하게 되면
        //위에 직접 코드로 추가했던 Tab객체는 무시됨
        //대신 ViewPager에서 탭버튼의 글씨를 설정

        //아이콘을 삽입하고 싶다면,.
        //tabLayout.getTabAt(0).setIcon(R.mipmap.ic_launcher;

        //제목줄에 서브제목설정하기
        getSupportActionBar().setSubtitle("Home");

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                getSupportActionBar().setSubtitle(tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //네비게이션뷰에 아이템선택 리스너 추가
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.menu_aa:
                        break;
                    case R.id.menu_bb:
                        break;
                    case R.id.menu_cc:
                        break;
                }

                //Drawer Nav 닫기
                drawerLayout.closeDrawer(navigationView);

                return false;
            }
        });


    }//onCreate Method..
    //옵션메뉴 만들어주는 메소드

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}//MainActivity class...
