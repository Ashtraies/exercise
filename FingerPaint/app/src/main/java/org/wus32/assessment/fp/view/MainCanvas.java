package org.wus32.assessment.fp.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import org.wus32.assessment.fp.R;
import org.wus32.assessment.fp.view.shape.IShape;

/**
 * Finger Paint
 * A custom view,use as canvas
 * <p/>
 * Created by Wu Shuang on 2016/8/17.
 */
public class MainCanvas extends View {

  /**
   * The width and height of this view.
   */
  private int w, h;

  /**
   * To fill in the shape with this color.
   */
  private int shapeColor;

  /**
   * A custom bitmap to record users' draw.
   */
  private Bitmap customBitmap;

  /**
   * A canvase which built by custom bitmap.
   */
  private Canvas customCanvas;

  /**
   * A paint to draw.
   */
  private Paint paint;

  /**
   * Which shape to draw.
   */
  private IShape shape;

  /**
   * Current scale.
   */
  private float scale = 1.0f;

  public MainCanvas(Context context,AttributeSet attrs) {
    super(context,attrs);
    //Initialize the paint.
    paint = new Paint();
    paint.setStyle(Paint.Style.FILL_AND_STROKE);
    paint.setStrokeWidth(context.getResources().getDimension(R.dimen.stroke_width));
    paint.setAntiAlias(true);
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    //Draw only when the users have chosen a shape and a color.
    if (shape != null && shapeColor != 0) {
      //Get the coordinate of the touch point.
      float touchX = event.getX();
      float touchY = event.getY();
      //Use custom canvas to draw.
      paint.setColor(shapeColor);
      shape.drawShapeWithCentre(touchX,touchY,event.getPressure(),scale,customCanvas,paint);
      //Call onDraw to draw custom bitmap whitin circle.
      invalidate();
      //Return false is the same.
      return true;
    }
    return super.onTouchEvent(event);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    //Draw custom bitmap(canvas) on the top of default canvas
    canvas.drawBitmap(customBitmap,0,0,paint);
  }

  @Override
  protected void onSizeChanged(int w,int h,int oldw,int oldh) {
    this.w = w;
    this.h = h;
    //Call reset to return the initial state.
    reset(w,h);
    super.onSizeChanged(w,h,oldw,oldh);
  }

  /**
   * create a new canvas and erase the exsisting object on former canvas
   *
   * @param w width of new canvas
   * @param h height of new canvas
   */
  public void reset(int w,int h) {
    //Create a bitmap as large as the screen (and transparent?).
    customBitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
    //Use this bitmap to creat a canvas.
    customCanvas = new Canvas(customBitmap);
    //Draw a white backgroun for this canvas.
    customCanvas.drawColor(Color.WHITE);
    invalidate();
  }

  /**
   * Zoom in our out current draw.
   * @param scale
   */
  public void zoom(float scale) {
    this.scale = scale;
    Matrix matrix = new Matrix();
    matrix.postScale(scale,scale);
    customBitmap = Bitmap.createBitmap(customBitmap,0,0,
            customBitmap.getWidth(),
            customBitmap.getHeight(),matrix,true);
    //Use this bitmap to creat a new canvas.
    customCanvas = new Canvas(customBitmap);
    invalidate();
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

  public Bitmap getCustomBitmap() {
    return customBitmap;
  }

}
