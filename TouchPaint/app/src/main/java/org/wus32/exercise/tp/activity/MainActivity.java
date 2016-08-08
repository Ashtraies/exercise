package org.wus32.exercise.tp.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.wus32.exercise.tp.R;
import org.wus32.exercise.tp.view.DrawView;

/**
 * TouchPaint
 * <p/>
 * Created by Wu Shuang on 2016/8/8.
 */
public class MainActivity extends AppCompatActivity {

  private View currBtn;

  private DrawView dv;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    dv = (DrawView)findViewById(R.id.dv);
  }

  public void selectColor(View v){
    if(currBtn != null) {
      currBtn.setBackground(null);
    }
    int id = v.getId();
    switch (id) {
      case R.id.red:
        v.setBackgroundColor(Color.RED);
        dv.setColor(Color.RED);
        break;
      case R.id.green:
        v.setBackgroundColor(Color.GREEN);
        dv.setColor(Color.GREEN);
        break;
      case R.id.yellow:
        v.setBackgroundColor(Color.YELLOW);
        dv.setColor(Color.YELLOW);
        break;
      default:
        break;
    }
    currBtn = v;
  }
}
