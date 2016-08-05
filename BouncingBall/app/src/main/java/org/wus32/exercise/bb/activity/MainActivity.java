package org.wus32.exercise.bb.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.wus32.exercise.bb.view.DrawView;

/**
 * Main
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }
}
