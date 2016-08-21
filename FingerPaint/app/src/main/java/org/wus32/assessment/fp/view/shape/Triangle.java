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
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;

/**
 * Finger Paint
 * <p/>
 * Created by Wu Shuang on 2016/8/16.
 */
public class Triangle extends AbstractShape {

  private float margin = (float)(Math.sqrt(3) / 6 * triangleLength);

  private float high = (float)(Math.sqrt(3) / 2 * triangleLength);

  public Triangle(Context context,AttributeSet attrs) {
    super(context,attrs);
  }

  public Triangle(Context context) {
    super(context,null);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    Path path = new Path();
    path.moveTo(0,h);
    path.lineTo(w / 2,0);
    path.lineTo(w,h);
    path.close();
    canvas.drawPath(path,paint);
  }

  @Override
  public void drawShapeWithCentre(float x,float y,Canvas canvas,Paint paint) {
    Path path = new Path();
    path.moveTo(x - triangleLength / 2,y + margin);
    path.lineTo(x,y - (high - margin));
    path.lineTo(x + triangleLength / 2,y + margin);
    path.close();
    canvas.drawPath(path,paint);
    canvas.drawPath(path,getBorderPaint());
  }

  @Override
  public Type getType() {
    return Type.TRIANGLE;
  }
}
