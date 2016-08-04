package org.wus32.exercise.bb.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.wu32.exercise.bb.R;
import org.wus32.exercise.bb.test.TestCentre;

/**
 * 的时间
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TestCentre.showLog(this);




    }
}
