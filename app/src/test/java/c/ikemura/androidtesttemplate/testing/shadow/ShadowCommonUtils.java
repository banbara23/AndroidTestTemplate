package c.ikemura.androidtesttemplate.testing.shadow;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

import c.ikemura.androidtesttemplate.CommonUtils;

@Implements(CommonUtils.class)
public class ShadowCommonUtils {
    @Implementation
    public static boolean clickValid() {
        return true;
    }
}
