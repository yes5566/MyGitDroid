package fuicui.mygitdroid.splash;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by tr on 2016/7/27.
 */
public class SplashAdpater extends PagerAdapter {
    Context mC;
    List<View> list;

    public SplashAdpater(List<View> list) {
        this.list = list;
        this.mC=mC;
    }

    public List<View> getList() {
        return list;
    }

    public void setList(List<View> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position), 0);
        return list.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
