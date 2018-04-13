package c.ikemura.androidtesttemplate.testing;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import c.ikemura.androidtesttemplate.BuildConfig;
import c.ikemura.androidtesttemplate.TestApplication;
import c.ikemura.androidtesttemplate.testing.shadow.ShadowCommonUtils;

public class MyRobolectricTestRunner extends RobolectricTestRunner {
    public MyRobolectricTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @Override
    protected Config buildGlobalConfig() {
        Class<?>[] shadow = {
                ShadowCommonUtils.class,
        };
        return new Config.Builder()
                .setShadows(shadow)
                .setSdk(24)
                .setConstants(BuildConfig.class)
                .setApplication(TestApplication.class)
                .build();
    }
}
