package org.wus32.assessment.fp.view.shape;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * interface which delimits shape
 * <p/>
 * <p/>
 * Created by Wu Shuang on 2016/8/14.
 */
public interface IShape {

  /**
   * shape type,in layout it as tag
   */
  enum Type {
    SQUARE,CIRCLE,TRIANGLE
  }

  /**
   * draw a shape on the canvas
   *
   * @param x      the x coordinate of the shape's central point
   * @param y      the y coordinate of the shape's central point
   * @param canvas draw on which canvas
   * @param paint  use which paint
   */
  void drawShapeWithCentre(float x,float y,float pressure,Canvas canvas,Paint paint);

  /**
   * get current type of shape
   *
   * @return type of shape
   */
  Type getType();

  void setColor(int color);

  void invalidate();

  void setVisibility(int visibility);
}
