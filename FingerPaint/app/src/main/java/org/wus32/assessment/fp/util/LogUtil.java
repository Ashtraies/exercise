/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.wus32.assessment.fp.util;

import android.util.Log;

/**
 * Finger Paint
 * <p/>
 * Created by Wu Shuang on 2016/8/15.
 */
public class LogUtil {

  @SuppressWarnings("unused")
  public static void log(Object context,Object content) {
    String tag = "FP";
    if(context != null) {
      tag = context.getClass().getSimpleName();
    }
    if (content == null) {
      Log.e(tag,"NULL");
    } else {
      Log.e(tag,content.toString());
    }
  }
}
