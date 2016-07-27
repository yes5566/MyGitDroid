package fuicui.mygitdroid.Base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by tr on 2016/7/27.
 */
public abstract class BaseActicity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setview();
        init();
        Do();


    }
   public abstract void setview();
    public abstract void init();
    public abstract void Do();
    public void IntentActivity(Class c){
        Intent i=new Intent(this,c);
        startActivity(i);
    }
}
