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
   * Paint
   */
  protected Paint paint;

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

  public AbstractShape(Context context,AttributeSet attrs) {
    super(context,attrs);
    initSpecification(context);
    //Initialize paint
    paint = new Paint();
    paint.setStyle(Paint.Style.STROKE);
    paint.setStrokeWidth(strokeWidth);
    paint.setAntiAlias(true);
  }

  /**
   * Read res xml to get specification through
   *
   * @param context use to get Resources object
   * @see Resources
   */
  private void initSpecification(Context context) {
    Resources res = context.getResources();
    strokeWidth = res.getDimension(R.dimen.stroke_width);
    squareLength = res.getDimension(R.dimen.square_length);
    LogUtil.log(squareLength);
    circleRaduis = res.getDimension(R.dimen.circle_radius);
    triangleLength = res.getDimension(R.dimen.triangle_length);
    offset = res.getDimension(R.dimen.child_layout_margin);
  }

  @Override
  protected void onSizeChanged(int w,int h,int oldw,int oldh) {
    this.w = w;
    this.h = h;
    super.onSizeChanged(w,h,oldw,oldh);
  }
}
