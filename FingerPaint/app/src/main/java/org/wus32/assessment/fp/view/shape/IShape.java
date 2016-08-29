package org.wus32.assessment.fp.view.shape;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Interface which delimits shape.
 * Created by Wu Shuang on 2016/8/14.
 */
public interface IShape {

  /**
   * Shape type,in layout it as tag.
   */
  enum Type {
    SQUARE,CIRCLE,TRIANGLE
  }

  /**
   * Draw a shape on the canvas.
   *
   * @param x      The x coordinate of the shape's central point.
   * @param y      The y coordinate of the shape's central point.
   * @param pressure The pressure of users' touch.
   * @param canvas Draw on which canvas.
   * @param paint  Use which paint.
   */
  void drawShapeWithCentre(float x,float y,float pressure,Canvas canvas,Paint paint);

  /**
   * Get current type of shape.
   *
   * @return type of shape
   */
  @SuppressWarnings("unused")
  Type getType();

  /**
   * Set which color to fill in the shape.
   * @param color
   */
  void setColor(int color);

  /**
   * Post the changes and draw.
   */
  void invalidate();

  /**
   * Set the visible state.
   * @param visibility Constant of visible state.
   * @see android.view.View
   */
  void setVisibility(int visibility);
}
