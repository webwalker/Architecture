package com.xujian.architecture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xujian.frameworkrouter.Router;
import com.xujian.frameworkrouter.rules.ActivityRule;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        if (Router.resolveRouter(ActivityRule.ACTIVITY_SCHEME + "product.main")) {
            Intent it = Router.invoke(this, ActivityRule.ACTIVITY_SCHEME + "product.main");
            startActivity(it);
        }
    }
}
