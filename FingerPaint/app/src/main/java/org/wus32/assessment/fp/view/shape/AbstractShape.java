package org.wus32.assessment.fp.view.shape;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import org.wus32.assessment.fp.R;
import org.wus32.assessment.fp.util.LogUtil;

/**
 * Abstract shape,implements basic method and initializes
 * key fields or specifications for its subclasses.
 * <p/>
 * Created by Wu Shuang on 2016/8/15.
 */
public abstract class AbstractShape extends View implements IShape {

  /**
   * Paint to draw the shape.
   */
  protected Paint paint;

  /**
   * Paint to draw the border of the shape.
   */
  protected Paint borderPaint;

  /**
   * The width and height of the view
   */
  float w, h;

  /**
   * The stroke width
   */
  float strokeWidth;

  /**
   * To control shapes' size
   */
  float squareLength, circleRaduis, triangleLength;

  /**
   * Offset to border
   */
  float offset;

  /**
   * With which color to draw shapes.
   */
  int color;

  public AbstractShape(Context context,AttributeSet attrs) {
    super(context,attrs);
    initSpecification(context);
    //Initialize shape paint
    paint = new Paint();
    paint.setStyle(Paint.Style.STROKE);
    paint.setStrokeWidth(strokeWidth);
    paint.setAntiAlias(true);
    //Initialize border paint
    borderPaint = new Paint();
    borderPaint.setAntiAlias(true);
    borderPaint.setStyle(Paint.Style.STROKE);
    borderPaint.setStrokeWidth(strokeWidth);
    borderPaint.setColor(Color.BLACK);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    if(color == 0) {
      color = Color.BLACK;
      paint.setStyle(Paint.Style.STROKE);
    }
    paint.setColor(color);
  }

  /**
   * Read res xml to get specification.
   *
   * @param context use to get Resources object
   * @see Resources
   */
  private void initSpecification(Context context) {
    Resources res = context.getResources();
    strokeWidth = res.getDimension(R.dimen.stroke_width);
    squareLength = res.getDimension(R.dimen.square_length);
    circleRaduis = res.getDimension(R.dimen.circle_radius);
    triangleLength = res.getDimension(R.dimen.triangle_length);
    offset = res.getDimension(R.dimen.child_layout_margin);
  }

  @Override
  protected void onSizeChanged(int w,int h,int oldw,int oldh) {
    //Record the width and height of this view.
    this.w = w;
    this.h = h;
    super.onSizeChanged(w,h,oldw,oldh);
  }

  @Override
  public void setColor(int color) {
    this.color = color;
  }

  @Override
  public void invalidate() {
    super.invalidate();
  }

  @Override
  public void setVisibility(int visibility) {
    super.setVisibility(visibility);
  }

  /**
   * Get the border paint.
   * @return border paint
   */
  Paint getBorderPaint() {
    return borderPaint;
  }
}
