package fuicui.mygitdroid.splash;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import fuicui.mygitdroid.Color.Color_Git;
import fuicui.mygitdroid.R;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by tr on 2016/7/27.
 */
public class SplashPagerFragment extends Fragment {
    View v,v1,v2,v3;
    @Bind(R.id.ivPhoneBlank)
    ImageView ivPhoneBlank;
    @Bind(R.id.ivPhoneFont)
    ImageView ivPhoneFont;
    @Bind(R.id.layoutPhoneInner)
    FrameLayout layoutPhoneInner;
    @Bind(R.id.layoutPhone)
    FrameLayout layoutPhone;
    ViewPager viewPager;
    @Bind(R.id.indicator)
    CircleIndicator indicator;
    @Bind(R.id.content)
    FrameLayout content;
    List<View> list;
    SplashAdpater sa;
    CircleIndicator circleIndicator;//圆点指示器
    private int colorGreen;
    private int colorRed;
    private int colorYellow;
    ImageView iv1,iv2,iv3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_splash_pager, container, false);
        viewPager= (ViewPager) v.findViewById(R.id.viewPager);
        v1=inflater.inflate(R.layout.content_pager_0,null);
        v2=inflater.inflate(R.layout.content_pager_1,null);
        v3=inflater.inflate(R.layout.content_pager_2,null);
        iv1= (ImageView) v3.findViewById(R.id.ivBubble1);
        iv2= (ImageView) v3.findViewById(R.id.ivBubble2);
        iv3= (ImageView) v3.findViewById(R.id.ivBubble3);
        list=new ArrayList<View>();
        list.add(v1);
        list.add(v2);
        list.add(v3);
        iv1.setVisibility(View.GONE);
        iv2.setVisibility(View.GONE);
        iv3.setVisibility(View.GONE);
        sa=new SplashAdpater(list);
        viewPager.setAdapter(sa);
        ButterKnife.bind(this, v);
        circleIndicator= (CircleIndicator) v.findViewById(R.id.indicator);
        viewPager.addOnPageChangeListener(pageChangeListener);
        viewPager.addOnPageChangeListener(onPageChangeListener);
        colorGreen=getResources().getColor(Color_Git.GREEN);
        colorRed=getResources().getColor(Color_Git.RED);
        colorYellow=getResources().getColor(Color_Git.YELLOW);
        return v;
    }
    // 主要为了做背景颜色渐变处理
            private ViewPager.OnPageChangeListener pageChangeListener=new ViewPager.OnPageChangeListener() {
        final ArgbEvaluator argbEvaluator = new ArgbEvaluator();
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    if (position == 0) {
                        int color = (int) argbEvaluator.evaluate(positionOffset, colorGreen, colorRed);
                        content.setBackgroundColor(color);
                        return;
                    }
                    // 第二个页面到第三个页面之间
                    if (position == 1) {
                        int color = (int) argbEvaluator.evaluate(positionOffset, colorRed, colorYellow);
                        content.setBackgroundColor(color);
                    }
                }

                @Override
                public void onPageSelected(int position) {

                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            };


    private ViewPager.OnPageChangeListener onPageChangeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (position == 0) {
                float scale = 0.3f + positionOffset * 0.7f;
                layoutPhone.setScaleX(scale);
                layoutPhone.setScaleY(scale);
                int scroll = (int) ((positionOffset-0.7) * 360);
                layoutPhone.setTranslationX(scroll);
                ivPhoneFont.setAlpha(positionOffset);
                return;
            }
            if (position == 1) {
                layoutPhone.setTranslationX(-positionOffsetPixels);
            }
        }

        @Override
        public void onPageSelected(int position) {
            // 当显示出最后一个pager时，播放它自己的动画
            if(position == 2) {
               showAnimation();
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
    public void showAnimation(){
        if(iv1.getVisibility()!=View.VISIBLE){
            v.postDelayed(new Runnable() {
                @Override public void run() {
                    iv1.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.FadeInLeft).duration(300).playOn(iv1);
                }
            }, 50);
            v.postDelayed(new Runnable() {
                @Override public void run() {
                    iv2.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.FadeInLeft).duration(300).playOn(iv2);
                }
            }, 550);
            v.postDelayed(new Runnable() {
                @Override public void run() {
                   iv3.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.FadeInLeft).duration(300).playOn(iv3);
                }
            }, 1050);

        }
    }
}
