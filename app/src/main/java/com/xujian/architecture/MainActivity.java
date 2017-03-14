package com.xujian.architecture;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xujian.frameworkrouter.mapping.ProductMapping;
import com.xujian.frameworkrouter.Router;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        //schema跳转过来时，通过获取Uri做业务逻辑处理
        Uri uri = intent.getData();
    }

    public void click(View view) {
        if (Router.resolveRouter(ProductMapping.MAIN)) {
            Intent it = Router.invoke(this, ProductMapping.MAIN);
            startActivity(it);
        }
    }
}
