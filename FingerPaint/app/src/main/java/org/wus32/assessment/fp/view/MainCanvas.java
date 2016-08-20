package org.wus32.assessment.fp.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import org.wus32.assessment.fp.R;
import org.wus32.assessment.fp.util.LogUtil;
import org.wus32.assessment.fp.view.shape.IShape;

/**
 * Finger Paint
 * a custom view,use as canvas
 * <p/>
 * Created by Wu Shuang on 2016/8/14.
 */
public class MainCanvas extends View {

  private int w,h;

  private int shapeColor;

  private Bitmap customBitmap;

  private Canvas customCanvas;

  private Paint paint;

  private IShape shape;

  public MainCanvas(Context context,AttributeSet attrs) {
    super(context,attrs);
    paint = new Paint();
    paint.setStyle(Paint.Style.FILL_AND_STROKE);
    paint.setStrokeWidth(context.getResources().getDimension(R.dimen.stroke_width));
    paint.setColor(context.getResources().getColor(R.color.colorPrimary));
    paint.setAntiAlias(true);
  }

  public void drawSelected() {
    if(shape == null) {
      if(shapeColor == 0) {
        shapeColor = Color.TRANSPARENT;
      }
      customCanvas.drawColor(shapeColor);
    }else {
      if(shapeColor == 0) {
        shapeColor = Color.TRANSPARENT;
      }
      paint.setStyle(Paint.Style.FILL_AND_STROKE);
      paint.setColor(shapeColor);
      shape.drawShapeWithCentre(10,10,customCanvas,paint);
    }
    invalidate();
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    if(shape != null) {
      float touchX = event.getX();
      float touchY = event.getY();
      //use custom canvas to draw
      paint.setColor(shapeColor);
      shape.drawShapeWithCentre(touchX,touchY,customCanvas,paint);
      //call onDraw to draw custom bitmap whitin circle
      invalidate();
      //return false is the same
      return true;
    }
    return super.onTouchEvent(event);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    //draw custom bitmap(canvas) on the top of default canvas
    canvas.drawBitmap(customBitmap,0,0,paint);
  }

  /**
   * create a new canvas and erase the exsisting object on former canvas
   *
   * @param w width of new canvas
   * @param h height of new canvas
   */
  public void reset(int w,int h) {
    //create a bitmap as large as the screen (and transparent?)
    customBitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
    //use this bitmap to creat a canvas
    customCanvas = new Canvas(customBitmap);
    invalidate();
  }

  @Override
  protected void onSizeChanged(int w,int h,int oldw,int oldh) {
    this.w = w;
    this.h = h;
    Log.e("FP",w + "/" + h);
    reset(w,h);
    super.onSizeChanged(w,h,oldw,oldh);
  }

  public int getW() {
    return w;
  }

  public int getH() {
    return h;
  }

  public void setShape(IShape shape) {
    this.shape = shape;
  }

  public void setShapeColor(int shapeColor) {
    this.shapeColor = shapeColor;
  }

}
