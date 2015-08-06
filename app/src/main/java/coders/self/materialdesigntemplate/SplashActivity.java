package coders.self.materialdesigntemplate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by Carlos Bedoy on 8/6/15.
 * <p/>
 * Mobile App Developer - MaterialDesignTemplate
 * <p/>
 * Pademobile
 */
public class SplashActivity extends ActionBarActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_activity);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));

                finish();
            }
        }, 2000);
    }
}
