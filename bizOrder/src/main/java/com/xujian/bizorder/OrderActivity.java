package com.xujian.bizorder;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.xujian.annotation.AutoRouter;
import com.xujian.frameworkrouter.mapping.ProductMapping;
import com.xujian.frameworkrouter.Router;

@AutoRouter
public class OrderActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.o_activity_order);
    }

    public void click(View view) {
        Toast.makeText(OrderActivity.this, "clicked!", Toast.LENGTH_SHORT).show();
        if (Router.resolveRouter(ProductMapping.MAIN + "?a=1&b=2")) {
            Intent it = Router.invoke(OrderActivity.this, ProductMapping.MAIN + "?a=1&b=2");
            startActivity(it);
        }
    }
}
