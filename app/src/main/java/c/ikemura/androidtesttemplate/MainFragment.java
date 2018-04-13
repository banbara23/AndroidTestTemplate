package c.ikemura.androidtesttemplate;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainFragment extends Fragment {
    public static final String BUNDLE_KEY_ID = "bundle_key_id";
    private View mView;
    private int mMyId;

    public MainFragment() {
    }

    public static MainFragment newInstance(Bundle args) {
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMyId = getArgId();
    }

    private int getArgId() {
        return getArguments().getInt(BUNDLE_KEY_ID);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mView = inflater.inflate(R.layout.fragment_main, container, false);

        final TextView textView = mView.findViewById(R.id.text);
        Button buttonA = mView.findViewById(R.id.button_a);
        Button buttonB = mView.findViewById(R.id.button_b);

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("A");
            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("B");
            }
        });

        return mView;
    }
}
