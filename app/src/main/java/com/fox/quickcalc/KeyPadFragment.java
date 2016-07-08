package com.fox.quickcalc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by stefox2 on 7/7/16.
 */
public class KeyPadFragment extends Fragment {

    private static final String TAG = KeyPadFragment.class.getName();
    private View.OnClickListener mKeyPadNumberListener = new View.OnClickListener() {
        @Override
        public void onClick( View v ) {
            keyPadNumberClick(v);
        }
    };

    // FIXME: 7/8/16 maybe these shouldn't be here? But this component IS dependent on them being here...
    private int[] mButtonIds = {
            R.id.keypad_number_zero, R.id.keypad_number_one, R.id.keypad_number_two, R.id.keypad_number_three,
            R.id.keypad_number_four, R.id.keypad_number_five, R.id.keypad_number_six,
            R.id.keypad_number_seven, R.id.keypad_number_eight, R.id.keypad_number_nine };

    public KeyPadFragment() {
    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        // Get the view associated with this Fragment. Thus, a Component
        View _inflate = inflater.inflate(R.layout.keypad_layout, container, false);
        Log.d(TAG, "onCreateView() called with: " + "inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]");

        Button button;
        for ( int id : mButtonIds ) {
            button = (Button) _inflate.findViewById(id);
            button.setOnClickListener(mKeyPadNumberListener);
        }

        return _inflate;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Click handling for button in the keypad space
    ///////////////////////////////////////////////////////////////////////////
    public void keyPadNumberClick( View view ) {
        String buttonText = ( (Button) view ).getText().toString();
        switch (buttonText) {
            default:
                Toast.makeText(getContext(), "Got a button click with text: " + buttonText, Toast.LENGTH_SHORT).show();
        }
        Log.d(TAG, "keyPadNumberClick() called with: " + "view = [" + view + "]");
    }
}
