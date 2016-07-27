package fuicui.mygitdroid;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import fuicui.mygitdroid.Base.BaseActicity;
import fuicui.mygitdroid.HortRepo.HortRepoFragment;

public class MainActivity extends BaseActicity implements NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.container)
    FrameLayout container;
    @Bind(R.id.navigationView)
    NavigationView navigationView;
    @Bind(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    public void setview() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void init() {
        setSupportActionBar(toolbar);
        navigationView.setNavigationItemSelectedListener(this);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        actionBarDrawerToggle.syncState();// 根据drawerlayout同步其当前状态
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
    }

    @Override
    public void Do() {
        replaceFragment(new HortRepoFragment());
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.github_hot_repo:
                break;
//            case R.id.github_hot_coder:
//                break;
//            case R.id.github_trend:
//                break;

        }

        return true;
    }
}
