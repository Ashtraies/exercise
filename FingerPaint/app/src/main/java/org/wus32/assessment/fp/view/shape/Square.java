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
 * <p/>
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
  public void drawShapeWithCentre(float x,float y,Canvas canvas,Paint paint) {
    canvas.drawRect(x - squareLength / 2,
            y - squareLength / 2,
            x + squareLength / 2,
            y + squareLength / 2,paint);
    canvas.drawRect(x - squareLength / 2,
            y - squareLength / 2,
            x + squareLength / 2,
            y + squareLength / 2,getBorderPaint());

  }

  @Override
  public Type getType() {
    return Type.SQUARE;
  }
}
