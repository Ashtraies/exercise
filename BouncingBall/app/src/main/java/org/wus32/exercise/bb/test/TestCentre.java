package org.wus32.exercise.bb.test;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 *
 * Created by Ashtray on 2016/7/30.
 */
public final class TestCentre {

  public void testClick(Context ctx) {
    Toast.makeText(ctx,"CLICK!",Toast.LENGTH_SHORT).show();
  }

  /**
   *
   * @param ctx
   */
  public static void showLog(Context ctx) {
    Log.e("BB","This is the very text E");
    Log.d("BB","This is the very text D");
    Log.v("BB","This is the very text V");
    Log.i("BB","This is the very text I");
    Log.w("BB","This is the very text W");
    System.out.print(false);
  }
}
