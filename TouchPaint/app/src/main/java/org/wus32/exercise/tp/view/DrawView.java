package org.wus32.exercise.tp.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import org.wus32.exercise.tp.R;

/**
 * TouchPaint
 * <p/>
 * This class is used to draw shape.
 *
 * @see View
 * Created by Wu Shuang on 2016/8/8.
 */
public class DrawView extends View {

  private int rectW;

  private int rectH;

  private int RADIUS;

  /**
   * Four coners of the rect
   */
  private int tl, tr, bl, br;

  private Paint p;

  private Bitmap customBitmap;

  private Canvas customCanvas;

  private int color = Color.BLACK;

  public DrawView(Context context,AttributeSet attrs) {
    super(context,attrs);
    p = new Paint();
    rectW = context.getResources().getInteger(R.integer.RECT_W);
    rectH = context.getResources().getInteger(R.integer.RECT_H);
    RADIUS = (rectW + rectH) / 30;
  }

  public void setColor(int color) {
    this.color = color;
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    canvas.drawColor(Color.WHITE);
    drawText(canvas);
    drawRect(canvas);
    drawCircle(canvas);
    drawLine(canvas);
    //draw custom bitmap(canvas) on the top of default canvas
    canvas.drawBitmap(customBitmap,0,0,p);
  }

  private void drawLine(Canvas canvas) {
    canvas.drawLine(tl,bl,tr,br,p);
    canvas.drawLine(tl,bl + rectH,tr,br - rectH,p);
  }

  private void drawCircle(Canvas canvas) {
    p.setColor(Color.RED);
    canvas.drawCircle(tl,bl,RADIUS,p);
    //TODO How to draw a circle only has border?
    p.setColor(Color.BLACK);
    p.setStrokeWidth(5);
    canvas.drawCircle(tr,br,RADIUS,p);
  }

  private void drawCircle(float x,float y,Canvas canvas) {
    p.setColor(color);
    canvas.drawCircle(x,y,RADIUS,p);
  }

  private void drawRect(Canvas canvas) {
    p.setColor(Color.GREEN);
    //build a rect in the centre of screen
    Rect r = new Rect();
    r.set(tl,bl,tr,br);
    canvas.drawRect(r,p);
  }

  private void drawText(Canvas canvas) {
    p.setTextSize(36f);
    p.setColor(Color.MAGENTA);
    canvas.drawText("Welcome to Mobile Programming",10,35,p);
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    float touchX = event.getX();
    float touchY = event.getY();
    //use custom canvas to draw
    drawCircle(touchX,touchY,customCanvas);
    //call onDraw to draw custom bitmap whitin circle
    invalidate();
    //return false is the same
    return true;
  }

  @Override
  protected void onSizeChanged(int w,int h,int oldw,int oldh) {
    tl = (w - rectW) / 2;
    tr = tl + rectW;
    bl = (h - rectH) / 2;
    br = bl + rectH;
    //create a bitmap as large as the screen (and transparent?)
    customBitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
    //use this bitmap to creat a canvas
    customCanvas = new Canvas(customBitmap);
    super.onSizeChanged(w,h,oldw,oldh);
  }
}
