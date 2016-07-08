package com.fox.quickcalc;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager _fragmentManager = getSupportFragmentManager();

        commitFragmentWith(_fragmentManager, R.id.display_frame_layout, new DisplayFragment());

        commitFragmentWith(_fragmentManager, R.id.keypad_frame_layout, new KeyPadFragment());
    }


    ///////////////////////////////////////////////////////////////////////////
    // Helpers
    ///////////////////////////////////////////////////////////////////////////

    private void commitFragmentWith( FragmentManager fragmentManager, @IdRes int target_layout, Fragment fragmentToLoad ) {
        Fragment _fragmentById = fragmentManager.findFragmentById(target_layout);

        Log.d(TAG, "commitFragmentWith: " + getResources().getResourceName(target_layout));

        if ( _fragmentById == null ) {
            _fragmentById = fragmentToLoad;
            fragmentManager.beginTransaction()
                    .add(target_layout, _fragmentById)
                    .commit();
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // Interface Implementations
    ///////////////////////////////////////////////////////////////////////////

    private class MyInteractionListener implements DisplayFragment.InteractionListener {
        @Override
        public void textChangedTo( String resultantText ) {

        }
    }
}
