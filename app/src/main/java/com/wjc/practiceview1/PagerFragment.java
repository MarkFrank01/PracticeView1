package com.wjc.practiceview1;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

/**
 * Created by WJC on 2017/10/18.
 */

public class PagerFragment extends Fragment {
    @LayoutRes
    int sampleLayoutRes;
    @LayoutRes
    int praticeLayoutRes;

    public static PagerFragment newInstance(@LayoutRes int sampleLayoutRes, @LayoutRes int praticeLayoutRes) {
        PagerFragment pagerFragment = new PagerFragment();
        Bundle args = new Bundle();
        args.putInt("sampleLayoutRes", sampleLayoutRes);
        args.putInt("praticeLayoutRes", praticeLayoutRes);
        pagerFragment.setArguments(args);
        return pagerFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pager_fragment, container, false);

        ViewStub sampleStub = (ViewStub) view.findViewById(R.id.sampleStub);
        sampleStub.setLayoutResource(sampleLayoutRes);
        sampleStub.inflate();

        ViewStub practiceSub = (ViewStub) view.findViewById(R.id.practiceStub);
        practiceSub.setLayoutResource(praticeLayoutRes);
        practiceSub.inflate();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = new Bundle();
        if (args != null){
            sampleLayoutRes = args.getInt("sampleLayoutRes");
            praticeLayoutRes = args.getInt("praticeLayoutRes");
        }
    }
}
