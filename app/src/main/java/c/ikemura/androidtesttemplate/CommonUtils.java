package c.ikemura.androidtesttemplate;

import android.os.Looper;
import android.os.SystemClock;

public class CommonUtils {

    private static long sClickTime = 0;

    public static boolean isUIThread() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    /**
     * 二重クリック禁止対応
     *
     * @return the boolean
     */
    public static boolean clickValid() {
        if (!isUIThread()) {
            throw new IllegalStateException();
        }

        long before = sClickTime;
        sClickTime = SystemClock.uptimeMillis();
        return before + 500 < sClickTime;
    }
}
