package com.wjc.practiceview1;

import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    List<PageModel> pageModels = new ArrayList<>();{
        pageModels.add(new PageModel(R.layout.simple_color, R.string.title_draw_color, R.layout.practice_color));
        pageModels.add(new PageModel(R.layout.simple_circle,R.string.title_draw_circle,R.layout.practice_circle));
        pageModels.add(new PageModel(R.layout.simple_rect,R.string.title_draw_rect,R.layout.practice_rect));
        pageModels.add(new PageModel(R.layout.simple_point,R.string.title_draw_point,R.layout.practice_point));
        pageModels.add(new PageModel(R.layout.simple_oval,R.string.title_draw_oval,R.layout.practice_oval));
        pageModels.add(new PageModel(R.layout.simple_line,R.string.title_draw_line,R.layout.practice_line));
        pageModels.add(new PageModel(R.layout.simple_roundrect,R.string.title_draw_round_rect,R.layout.practice_roundrect));
        pageModels.add(new PageModel(R.layout.simple_arc,R.string.title_draw_arc,R.layout.practice_arc));
        pageModels.add(new PageModel(R.layout.simple_path,R.string.title_draw_path,R.layout.practice_path));
        pageModels.add(new PageModel(R.layout.simple_histogram,R.string.title_draw_histogram,R.layout.practice_histogram));
        pageModels.add(new PageModel(R.layout.simple_chatpie,R.string.title_draw_pie_chart,R.layout.practice_chartpie));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.pager);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                PageModel pageModel = pageModels.get(position);
                return  PagerFragment.newInstance(pageModel.sampleLayoutRes,pageModel.practiceLayoutRes);
            }

            @Override
            public int getCount() {
                return pageModels.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(pageModels.get(position).titleRes);

            }
        });

        tabLayout =(TabLayout)findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    private class PageModel{
        @LayoutRes int sampleLayoutRes;
        @StringRes int titleRes;
        @LayoutRes int practiceLayoutRes;

        PageModel(@LayoutRes int sampleLayoutRes, @StringRes int titleRes, @LayoutRes int practiceLayoutRes) {
            this.sampleLayoutRes = sampleLayoutRes;
            this.titleRes = titleRes;
            this.practiceLayoutRes = practiceLayoutRes;
        }
    }
}
