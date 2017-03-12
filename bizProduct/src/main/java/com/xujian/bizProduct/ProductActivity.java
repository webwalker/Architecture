package com.xujian.bizProduct;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xujian.annotation.StaticRouter;
import com.xujian.frameworkcore.model.MessageEvent;
import com.xujian.frameworkrouter.mapping.ProductMapping;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@StaticRouter(ProductMapping.MAIN_EX)
public class ProductActivity extends AppCompatActivity {
    @BindView(R2.id.image_shot)
    ImageView imageShot;
    @BindView(R2.id.text_title)
    TextView textTitle;
    @BindView(R2.id.text_like_count)
    TextView textLikeCount;
    @BindView(R2.id.imageView)
    ImageView imageView;
    @BindView(R2.id.constraintLayout)
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        EventBus.getDefault().register(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        //EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        //EventBus.getDefault().unregister(this);
    }

    @OnClick({R2.id.image_shot, R2.id.text_title})
    public void onClick(View view) {
        switch (view.getId()) {
            case R2.id.image_shot:
                break;
            case R2.id.text_title:
                EventBus.getDefault().post(new MessageEvent());
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
    }
}
