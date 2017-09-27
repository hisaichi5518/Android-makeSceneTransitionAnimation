package com.github.hisaichi5518.animationtest.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.github.hisaichi5518.animationtest.R;
import com.github.hisaichi5518.animationtest.databinding.ActivityNextBinding;
import com.github.hisaichi5518.animationtest.model.glide.GlideApp;
import com.jakewharton.rxbinding2.view.RxView;

public class NextActivity extends AppCompatActivity {

    private ActivityNextBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_next);

        GlideApp.with(this)
                .load(R.drawable.sample)
                .into(binding.view1);

        RxView.clicks(binding.view1).subscribe(__ -> {
            ActivityCompat.finishAfterTransition(this);
        });
    }


    static class IntentBuilder {
        private final Context context;

        IntentBuilder(Context context) {
            this.context = context;
        }

        Intent build() {
            return new Intent(context, NextActivity.class);
        }
    }
}
