package com.example.eazywash.utils;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import org.jetbrains.annotations.NotNull;

public class ZoomInPageTransformer implements ViewPager.PageTransformer {
    public static final float MAX_ROTATION = 90.0f;

    @Override
    public void transformPage(@NonNull @NotNull View page, float position) {
        final float scale = position < 0 ? position + 1f : Math.abs(1f - position);
        page.setScaleX(scale);
        page.setScaleY(scale);
        page.setPivotX(page.getWidth() * 0.5f);
        page.setPivotY(page.getHeight() * 0.5f);
        page.setAlpha(position < -1f || position > 1f ? 0f : 1f - (scale - 1f));
    }
}
