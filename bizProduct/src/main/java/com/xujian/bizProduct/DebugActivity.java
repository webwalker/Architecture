package com.xujian.bizProduct;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.xujian.annotation.StaticRouter;
import com.xujian.frameworkrouter.mapping.RouteMapping;
import com.xujian.frameworkrouter.Router;
import com.xujian.frameworkrouter.mapping.ProductMapping;

@StaticRouter(ProductMapping.MAIN)
public class DebugActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setTextSize(50);
        tv.setText("PRODUCT!!!");
        setContentView(tv);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DebugActivity.this, "clicked!", Toast.LENGTH_SHORT).show();
                if (Router.resolveRouter(RouteMapping.ACTIVITY_SCHEMA + "com.xujian.bizorder.OrderActivity")) {
                    Intent it = Router.invoke(DebugActivity.this, RouteMapping.ACTIVITY_SCHEMA + "com.xujian.bizorder.OrderActivity");
                    startActivity(it);
                }
            }
        });
    }
}
