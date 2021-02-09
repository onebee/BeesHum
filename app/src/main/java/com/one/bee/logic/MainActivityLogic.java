package com.one.bee.logic;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.FragmentManager;

import com.one.bee.R;
import com.one.bee.fragment.CategoryFragment;
import com.one.bee.fragment.FavoriteFragment;
import com.one.bee.fragment.HomePageFragment;
import com.one.bee.fragment.ProfileFragment;
import com.one.bee.fragment.RecommendFragment;
import com.one.common.tab.HiFragmentTabView;
import com.one.common.tab.HiTabViewAdapter;
import com.one.ui.tab.bottom.HiTabBottomInfo;
import com.one.ui.tab.bottom.HiTabBottomLayout;
import com.one.ui.tab.common.IHiTabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @author diaokaibin@gmail.com on 2/9/21.
 * MainActivity 逻辑内聚在这
 */
public class MainActivityLogic {



    private HiFragmentTabView fragmentTabView;
    private HiTabBottomLayout hiTabBottomLayout;
    private List<HiTabBottomInfo<?>> infoList;
    private ActivityProvider activityProvider;
    private final static String SAVED_CURRENT_ID = "SAVED_CURRENT_ID";
    private int currentItemIndex;

    public MainActivityLogic(ActivityProvider activityProvider) {
        this.activityProvider = activityProvider;
        initTabBottom();
    }


    private void initTabBottom() {
        hiTabBottomLayout = activityProvider.findViewById(R.id.tab_bottom_layout);
        hiTabBottomLayout.setAlpha(0.85f);
        infoList = new ArrayList<>();
        int tintColor = activityProvider.getResources().getColor(R.color.tabBottomTintColor);
        int defaultColor = activityProvider.getResources().getColor(R.color.tabBottomDefaultColor);

        HiTabBottomInfo homeInfo = new HiTabBottomInfo(
                "首页",
                "fonts/iconfont.ttf",
                activityProvider.getString(R.string.if_home),
                null,
                "#ff656667",
                "#ffd44949"
        );
        HiTabBottomInfo infoFavorite = new HiTabBottomInfo(
                "收藏",
                "fonts/iconfont.ttf",
                activityProvider.getString(R.string.if_favorite),
                null,
                "#ff656667",
                "#ffd44949"
        );


        Bitmap bitmap = BitmapFactory.decodeResource(activityProvider.getResources(), R.drawable.fire, null);

        HiTabBottomInfo infoCategory = new HiTabBottomInfo<String>(
                "分类",
                bitmap,
                bitmap
        );
        HiTabBottomInfo infoRecommend = new HiTabBottomInfo(
                "推荐",
                "fonts/iconfont.ttf",
                activityProvider.getString(R.string.if_recommend),
                null,
                "#ff656667",
                "#ffd44949"
        );
        HiTabBottomInfo infoProfile = new HiTabBottomInfo(
                "我的",
                "fonts/iconfont.ttf",
                activityProvider.getString(R.string.if_profile),
                null,
                "#ff656667",
                "#ffd44949"
        );

        infoProfile.fragment = ProfileFragment.class;
        infoCategory.fragment = CategoryFragment.class;
        homeInfo.fragment = HomePageFragment.class;
        infoFavorite.fragment = FavoriteFragment.class;
        infoRecommend.fragment = RecommendFragment.class;

        infoList.add(homeInfo);
        infoList.add(infoFavorite);
        infoList.add(infoCategory);
        infoList.add(infoRecommend);
        infoList.add(infoProfile);
        hiTabBottomLayout.inflateInfo(infoList);
        initFragmentTabView();

        hiTabBottomLayout.addTabSelectedChangeListener(new IHiTabLayout.OnTabSelectedListener<HiTabBottomInfo<?>>() {
            @Override
            public void onTabSelectedChange(int index, @Nullable HiTabBottomInfo<?> prevInfo, @NonNull HiTabBottomInfo<?> nextInfo) {
                fragmentTabView.setCurrentItem(index);
            }
        });
        hiTabBottomLayout.defaultSelected(homeInfo);
    }

    private void initFragmentTabView() {
        HiTabViewAdapter tabViewAdapter = new HiTabViewAdapter(activityProvider.getSupportFragmentManager(), infoList);
        fragmentTabView = activityProvider.findViewById(R.id.fragment_tab_view);
        fragmentTabView.setAdapter(tabViewAdapter);

    }

    public HiFragmentTabView getFragmentTabView() {
        return fragmentTabView;
    }

    public HiTabBottomLayout getHiTabBottomLayout() {
        return hiTabBottomLayout;
    }

    public List<HiTabBottomInfo<?>> getInfoList() {
        return infoList;
    }


    public interface ActivityProvider {
        <T extends View> T findViewById(@IdRes int id);

        Resources getResources();

        FragmentManager getSupportFragmentManager();

        String getString(@StringRes int resID);
    }
}
