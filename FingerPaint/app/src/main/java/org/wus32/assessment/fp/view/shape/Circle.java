/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.wus32.assessment.fp.view.shape;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

/**
 * Finger Paint
 * <p/>
 * Created by Wu Shuang on 2016/8/16.
 */
public class Circle extends AbstractShape{

  public Circle(Context context,AttributeSet attrs) {
    super(context,attrs);
  }

  public Circle(Context context) {
    super(context,null);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    canvas.drawCircle(w/2,h/2,w/2 - strokeWidth,paint);
  }

  @Override
  public void drawShapeWithCentre(float x,float y,Canvas canvas,Paint paint) {
    canvas.drawCircle(x,y,circleRaduis,paint);
  }

  @Override
  public Type getType() {
    return Type.CIRCLE;
  }
}
