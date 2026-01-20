package ru.iteco.fmhandroid.ui;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;

public abstract class BaseTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @org.junit.After
    public void globalTearDown() {
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        android.util.Log.i("BASE_TEST", "Принудительная очистка памяти выполнена успешно");
    }

    protected View getDecorView() {
        final View[] view = new View[1];
        mActivityScenarioRule.getScenario().onActivity(activity -> {
            view[0] = activity.getWindow().getDecorView();
        });
        return view[0];
    }
}
