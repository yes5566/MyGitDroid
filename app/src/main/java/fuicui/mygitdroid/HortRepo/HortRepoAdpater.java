package fuicui.mygitdroid.HortRepo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tr on 2016/7/27.
 */
public class HortRepoAdpater extends FragmentPagerAdapter{
    List<Fragment> list;
    List<String> list_title;

    public HortRepoAdpater(FragmentManager fm, List<Fragment> list, List<String> list_title) {
        super(fm);
        this.list = list;
        this.list_title = list_title;
    }

    public List<Fragment> getList() {
        return list;
    }

    public void setList(List<Fragment> list) {
        this.list = list;
    }

    public List<String> getList_title() {
        return list_title;
    }

    public void setList_title(List<String> list_title) {
        this.list_title = list_title;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list_title.get(position);
    }
}
