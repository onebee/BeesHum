package com.one.common.tab;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.one.ui.tab.bottom.HiTabBottomInfo;

import java.util.List;

/**
 * @author diaokaibin@gmail.com on 2/9/21.
 */
public class HiTabViewAdapter {

    private List<HiTabBottomInfo<?>> infoList;
    private Fragment currentFragment;
    private FragmentManager fragmentManager;


    public HiTabViewAdapter(FragmentManager fragmentManager, List<HiTabBottomInfo<?>> infoList) {
        this.infoList = infoList;
        this.fragmentManager = fragmentManager;
    }

    /**
     * 实例化以及显示指定位置的 fragment
     *
     * @param container
     * @param position
     */
    public void instantiateItem(View container, int position) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (currentFragment != null) {
            transaction.hide(currentFragment);
        }
        String name = container.getId() + ":" + position;
        Fragment fragment = fragmentManager.findFragmentByTag(name);
        if (fragment != null) {
            transaction.show(fragment);
        } else {
            fragment = getItem(position);
            if (!fragment.isAdded()) {
                transaction.add(container.getId(), fragment, name);
            }
        }
        currentFragment = fragment;
        transaction.commitAllowingStateLoss();
    }

    public Fragment getItem(int positions) {
        try {
            return infoList.get(positions).fragment.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Fragment getCurrentFragment() {
        return currentFragment;
    }

    public int getCount() {
        return infoList == null ? 0 : infoList.size();
    }

}
