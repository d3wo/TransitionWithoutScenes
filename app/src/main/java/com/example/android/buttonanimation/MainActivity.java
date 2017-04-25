package com.example.android.buttonanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import static android.transition.Fade.IN;

public class MainActivity extends AppCompatActivity {


    private TextView mLabelText;
    private Fade mFade;
    private ViewGroup mRootView;
    private EditText mEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





    }



    public void tambahLagi(View view){

        mEditText = (EditText) findViewById(R.id.inputText);
        String textInput = mEditText.getText().toString();

        if (textInput.isEmpty()){
            textInput = "Empty Value";
        }

        // Create a new TextView and set some View properties
        mLabelText = new TextView(MainActivity.this);
        mLabelText.setText(textInput);
        mLabelText.setId(View.NO_ID);

        // Get the root view and create a transition
        mRootView = (ViewGroup) findViewById(R.id.mainLayout);
        mFade = new Fade(IN);


        // Start recording changes to the view hierarchy
        TransitionManager.beginDelayedTransition(mRootView, mFade);

        // Add the new TextView to the view hierarchy
        mRootView.addView(mLabelText);

        // When the system redraws the screen to show this update,
        // the framework will animate the addition as a fade in

    }

}
