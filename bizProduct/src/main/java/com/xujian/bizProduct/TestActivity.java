package com.xujian.bizProduct;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.xujian.annotation.Component;
import com.xujian.annotation.StaticRouter;
import com.xujian.frameworkrouter.Router;
import com.xujian.frameworkrouter.rules.ActivityRule;

@Component("product")
@StaticRouter(ActivityRule.ACTIVITY_SCHEME + "product.main")
public class TestActivity extends AppCompatActivity {

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
                Toast.makeText(TestActivity.this, "clicked!", Toast.LENGTH_SHORT).show();
                if (Router.resolveRouter(ActivityRule.ACTIVITY_SCHEME + "com.xujian.bizorder.MainActivity")) {
                    Intent it = Router.invoke(TestActivity.this, ActivityRule.ACTIVITY_SCHEME + "com.xujian.bizorder.MainActivity");
                    startActivity(it);
                }
            }
        });
    }
}
