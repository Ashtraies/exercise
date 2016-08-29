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
 * Draw square
 * Created by Wu Shuang on 2016/8/15.
 */
public class Square extends AbstractShape {

  public Square(Context context,AttributeSet attrs) {
    super(context,attrs);
  }

  public Square(Context context) {
    super(context,null);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    canvas.drawRect(0,0,w,h,paint);
  }

  @Override
  public void drawShapeWithCentre(float x,float y,float pressure,Canvas canvas,Paint paint) {
    float l = squareLength * pressure;
    //Calculate the coordinate of the four points of the square.
    canvas.drawRect(x - l / 2,
            y - l / 2,
            x + l / 2,
            y + l / 2,paint);
    canvas.drawRect(x - l / 2,
            y - l / 2,
            x + l / 2,
            y + l / 2,getBorderPaint());
  }

  @Override
  public Type getType() {
    return Type.SQUARE;
  }
}
