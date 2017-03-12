package com.xujian.bizorder;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.xujian.annotation.AutoRouter;
import com.xujian.frameworkrouter.mapping.RouteMapping;
import com.xujian.frameworkrouter.Router;

@AutoRouter
public class OrderActivity extends AppCompatActivity {
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
                Toast.makeText(OrderActivity.this, "clicked!", Toast.LENGTH_SHORT).show();
                if (Router.resolveRouter(RouteMapping.ACTIVITY_SCHEMA + "product.main")) {
                    Intent it = Router.invoke(OrderActivity.this, RouteMapping.ACTIVITY_SCHEMA + "product.main");
                    startActivity(it);
                }
            }
        });
    }
}
