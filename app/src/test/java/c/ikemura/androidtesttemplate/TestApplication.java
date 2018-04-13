package c.ikemura.androidtesttemplate;

import android.app.Application;

import org.robolectric.TestLifecycleApplication;

import java.lang.reflect.Method;

public class TestApplication extends Application implements TestLifecycleApplication {

    @Override
    public void beforeTest(Method method) {
        //本番でテストされるのを防ぐ
        if (!BuildConfig.BUILD_TYPE.equals("debug")) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void prepareTest(Object test) {

    }

    @Override
    public void afterTest(Method method) {

    }
}
