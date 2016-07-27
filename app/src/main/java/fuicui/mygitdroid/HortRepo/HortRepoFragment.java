package fuicui.mygitdroid.HortRepo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import fuicui.mygitdroid.R;

/**
 * Created by tr on 2016/7/27.
 */
public class HortRepoFragment extends Fragment {
    View view;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    List<Fragment> list;
    List<String> list_title;
    HortRepoAdpater hra;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_hot_repo, container, false);
        ButterKnife.bind(this, view);
        list=new ArrayList<Fragment>();
        list_title=new ArrayList<String>();
        list_title.add("java");
        list.add(new Text());
        hra=new HortRepoAdpater(getFragmentManager(),list,list_title);
        viewPager.setAdapter(hra);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
