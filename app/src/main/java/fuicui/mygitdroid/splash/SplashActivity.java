package fuicui.mygitdroid.splash;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fuicui.mygitdroid.Base.BaseActicity;
import fuicui.mygitdroid.MainActivity;
import fuicui.mygitdroid.R;

/**
 * Created by tr on 2016/7/27.
 */
public class SplashActivity extends BaseActicity {
    @Bind(R.id.btnLogin)
    Button btnLogin;
    @Bind(R.id.btnEnter)
    Button btnEnter;

    @Override
    public void setview() {
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
    }

    @Override
    public void init() {

    }

    @Override
    public void Do() {

    }

    @OnClick({R.id.btnLogin, R.id.btnEnter})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                break;
            case R.id.btnEnter:
                IntentActivity(MainActivity.class);
                finish();
                break;
        }
    }
}
