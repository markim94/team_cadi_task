package org.techtown.a0623_kakaotalk;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListView = null;

    /*
    액션바 설정
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_tab, menu);
        return true;
    }


    /*
    액션바 클릭 리스너 설정
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int curId = item.getItemId(); // 탭 메뉴 아이템에서 id값을 얻어옴
        switch (curId){
            case R.id.action_search_btn:
                Toast.makeText(getApplicationContext(),"검색버튼 클릭",Toast.LENGTH_LONG).show();
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(),"설정버튼 클릭",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //추가 버튼 리스너 설정
        Button button = (Button) findViewById(R.id.addButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "추가버튼을 클릭함", Toast.LENGTH_LONG).show();
            }
        });

        //tablayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tl_tabs);
        //viewpager
        ViewPager viewPager = (ViewPager) findViewById(R.id.vp_pager);

        //프래그먼트 배열, 프래그먼트를 배열에
        Fragment[] arrFragments = new Fragment[5];
        arrFragments[0] = new FirstFragment();
        arrFragments[1] = new SecondFragment();
        arrFragments[2] = new ThirdFragment();
        arrFragments[3] = new FourthFragment();
        arrFragments[4] = new FifthFragment();

        //어댑터 연결
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), arrFragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }



    //pager adapter
    private class MyPagerAdapter extends FragmentPagerAdapter {

        private Fragment[] arrFragments;

        //생성자
        public MyPagerAdapter(FragmentManager fm, Fragment[] arrFragments) {
            super(fm);
            this.arrFragments = arrFragments;
        }

        @Override
        public Fragment getItem(int position) {
            return arrFragments[position];
        }

        @Override
        public int getCount() {
            return arrFragments.length;
        }



        //Tab의 타이틀 설정, 이미지로 변환가능
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "친구";
                case 1:
                    return "대화";
                case 2:
                    return "뉴스";
                case 3:
                    return "게임";
                case 4:
                    return "더보기";
                default:
                    return "";
            }
            //return super.getPageTitle(position);
        }
    }




}