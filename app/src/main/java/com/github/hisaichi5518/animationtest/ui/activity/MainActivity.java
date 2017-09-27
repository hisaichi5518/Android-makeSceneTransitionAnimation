package com.github.hisaichi5518.animationtest.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.github.hisaichi5518.animationtest.R;
import com.github.hisaichi5518.animationtest.databinding.ActivityMainBinding;
import com.github.hisaichi5518.animationtest.model.glide.GlideApp;
import com.jakewharton.rxbinding2.view.RxView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        GlideApp.with(this)
                .load(R.drawable.sample)
                .into(binding.view1);

        RxView.clicks(binding.view1).subscribe(__ -> {
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this, binding.view1, "image");

            ContextCompat.startActivity(this, new NextActivity.IntentBuilder(this).build(), options.toBundle());
        });
    }
}
