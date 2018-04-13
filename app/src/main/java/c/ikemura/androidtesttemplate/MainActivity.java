package c.ikemura.androidtesttemplate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = new Bundle();
        bundle.putInt(MainFragment.BUNDLE_KEY_ID, 0);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.container, MainFragment.newInstance(bundle))
                .commit();
    }
}
