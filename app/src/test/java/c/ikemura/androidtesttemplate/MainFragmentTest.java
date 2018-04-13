package c.ikemura.androidtesttemplate;

import android.os.Bundle;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.util.ReflectionHelpers;

import c.ikemura.androidtesttemplate.testing.MyRobolectricTestRunner;

import static junit.framework.Assert.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Enclosed.class)
public class MainFragmentTest {
    public static abstract class MainFragmentTestBase {

        MainFragment testTarget;

        @Mock
        Bundle mBundle;

        @Before
        public void setUp() throws Exception {
            MockitoAnnotations.initMocks(this);
            mBundle = new Bundle();
            mBundle.putInt("bundle_key_id", 1);
            testTarget = MainFragment.newInstance(mBundle);
        }
    }

    @RunWith(MyRobolectricTestRunner.class)
    public static class 初回テスト extends MainFragmentTestBase {

        @Test
        public void newInstance後はnullではない() throws Exception {
            assertNotNull(testTarget);
        }
    }

    @RunWith(MyRobolectricTestRunner.class)
    public static class ライフサイクルの確認 extends MainFragmentTestBase {

//        @Mock
//        LayoutInflater inflater;
//        @Mock
//        ViewGroup container;

        @Test
        public void onCreate() throws Exception {
            testTarget.onCreate(null);
            int myId = ReflectionHelpers.getField(testTarget, "mMyId");
            assertThat(myId).isEqualTo(1);
        }

//        @Test
//        public void onCreateView() throws Exception {
//            testTarget.onCreateView(inflater, container, null);
//            View view = ReflectionHelpers.getField(testTarget, "mView");
//            assertThat(view).isNotNull();
//        }
    }
}