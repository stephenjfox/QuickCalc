package com.fox.quickcalc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by stefox2 on 7/7/16.
 */
public class DisplayFragment extends Fragment {

    private static final String TAG = DisplayFragment.class.getName();

    public DisplayFragment() {
        // "required" public constructor
    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        View inflate = inflater.inflate(R.layout.expression_display, container, false);
        // listen through the hosting activity
        TextView resultView = (TextView) inflate.findViewById(R.id.resultView);
        TextView expressionView = (TextView) inflate.findViewById(R.id.expressionView);


        expressionView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged( CharSequence s, int start, int count, int after ) {

            }

            @Override
            public void onTextChanged( CharSequence s, int start, int before, int count ) {
                Log.d(TAG, "expressionView.onTextChanged() called with: " + "s = [" + s + "], " +
                        "start = [" + start + "], before = [" + before + "], count = [" + count + "]");
            }

            @Override
            public void afterTextChanged( Editable s ) {
                Log.d(TAG, "afterTextChanged: " + s.toString());
            }
        });

        return inflate;
    }

    public interface InteractionListener {
        void textChangedTo( final String resultantText );
    }
}
