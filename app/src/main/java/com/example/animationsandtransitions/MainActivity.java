package com.example.animationsandtransitions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import android.view.MotionEvent ;
import android.view.View ;
import android.view.ViewGroup ;
import android.widget.RelativeLayout ;
import android.transition.TransitionManager ;


public class MainActivity extends AppCompatActivity {

    ViewGroup Layout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Layout = (ViewGroup) findViewById(R.id.Layout);

        Layout.setOnTouchListener(
                new RelativeLayout.OnTouchListener(){
                    @Override
                    public boolean onTouch(View v, MotionEvent event ){
                        movebutton();
                        return true;
                    }
                }
        );


    }
    //
    public void movebutton(){

        View button = findViewById(R.id.button);

        TransitionManager.beginDelayedTransition(Layout);

        // change the position of the button

        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT ,RelativeLayout.LayoutParams.WRAP_CONTENT );
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);

        button.setLayoutParams(positionRules);

        // change the size of the button
        ViewGroup.LayoutParams sizeRules = button.getLayoutParams();
        sizeRules.width = 450 ;
        sizeRules.height = 300;
        button.setLayoutParams(sizeRules);
    }
}