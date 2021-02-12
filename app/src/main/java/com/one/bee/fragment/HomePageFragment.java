package com.one.bee.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.one.bee.R;
import com.one.bee.concurrent.ConcurrentTest;
import com.one.bee.demo.banner.HiBannerDemoActivity;
import com.one.common.ui.component.HiBaseFragment;
import com.one.library.log.HiConsolePrinter;
import com.one.library.log.HiLogManager;

/**
 * @author diaokaibin@gmail.com on 2/9/21.
 */
public class HomePageFragment extends HiBaseFragment {

    TextView tv;

    @Override
    public int getLayoutId() {

        return R.layout.fragment_home;
    }

    @Override
    public void onStart() {
        super.onStart();
        HiConsolePrinter hiConsolePrinter = new HiConsolePrinter();
        HiLogManager.getInstance().addPrinter(hiConsolePrinter);
       tv= getActivity().findViewById(R.id.tv_home);
               tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), HiBannerDemoActivity.class));

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

//        HiLog.i(" onResume : " + tv.getWidth() + " , " + tv.getHeight());
//
//        tv.post(new Runnable() {
//            @Override
//            public void run() {
//                HiLog.i(" post onResume : " + tv.getWidth() + " , " + tv.getHeight());
//            }
//        });

        new ConcurrentTest().test();
    }
}
