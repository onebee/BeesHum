package com.one.bee;

import android.os.Bundle;

import com.one.bee.logic.MainActivityLogic;
import com.one.common.ui.component.HiBaseActivity;

public class MainActivity extends HiBaseActivity implements MainActivityLogic.ActivityProvider {

    private MainActivityLogic activityLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityLogic = new MainActivityLogic(this);
    }

}