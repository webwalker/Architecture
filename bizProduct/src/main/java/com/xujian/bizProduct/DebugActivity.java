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
import com.xujian.frameworkrouter.support.RouteFragment;

@StaticRouter(ProductMapping.MAIN)
public class DebugActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p_activity_debug);

        RouteFragment fragment = Router.invoke(DebugActivity.this, ProductMapping.FRAGMENT);
    }

    public void click(View view) {
        Toast.makeText(DebugActivity.this, "clicked!", Toast.LENGTH_SHORT).show();
        if (Router.resolveRouter(RouteMapping.pattern("com.xujian.bizorder.OrderActivity"))) {
            Intent it = Router.invoke(DebugActivity.this, RouteMapping.pattern("com.xujian.bizorder.OrderActivity"));
            startActivity(it);
        }
    }
}
