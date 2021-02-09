package com.one.bee.fragment;

import android.content.Intent;
import android.view.View;

import com.one.bee.R;
import com.one.bee.demo.refresh.HiRefreshDemoActivity;
import com.one.common.ui.component.HiBaseFragment;

/**
 * @author diaokaibin@gmail.com on 2/9/21.
 */
public class HomePageFragment extends HiBaseFragment {

    @Override
    public int getLayoutId() {

        return R.layout.fragment_home;
    }

    @Override
    public void onStart() {
        super.onStart();

        getActivity().findViewById(R.id.tv_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), HiRefreshDemoActivity.class));

            }
        });
    }
}
