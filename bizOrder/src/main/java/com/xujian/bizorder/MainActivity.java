package com.xujian.bizorder;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.xujian.annotation.AutoRouter;
import com.xujian.annotation.Component;
import com.xujian.frameworkrouter.Router;
import com.xujian.frameworkrouter.rules.ActivityRule;

@Component("order")
@AutoRouter
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setTextSize(50);
        tv.setText("ORDER!!!");
        setContentView(tv);
        //setContentView(R.layout.activity_main);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "clicked!", Toast.LENGTH_SHORT).show();
                if (Router.resolveRouter(ActivityRule.ACTIVITY_SCHEME + "product.main")) {
                    Intent it = Router.invoke(MainActivity.this, ActivityRule.ACTIVITY_SCHEME + "product.main");
                    startActivity(it);
                }
            }
        });
    }
}
