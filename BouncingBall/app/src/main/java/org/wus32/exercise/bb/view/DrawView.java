package org.wus32.exercise.bb.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import org.wus32.exercise.bb.pojo.Ball;

import java.util.List;

/**
 * Created by Ashtray on 2016/8/4.
 */
public class DrawView extends View {

  private int width, height;

  private List<Ball> balls;

  private Paint paint;

  public static final int BALL_NUM = 47;

  public DrawView(Context context) {
    super(context);
    balls = Ball.getSomeBalls(BALL_NUM);
    paint = new Paint();
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    for (int i = 0;i < balls.size();i++) {
      drawBall(canvas,i);
    }
  }

  private void drawBall(Canvas canvas,int location) {
    Ball ball = balls.get(location);
    paint.setColor(ball.getColour());
    canvas.drawCircle(ball.getStartX(),ball.getStartY(),ball.getRadius(),paint);
    boolean boderX = (ball.getStartX() + ball.getRadius()) >= width;
    boolean boderY = (ball.getStartY() + ball.getRadius()) >= height;
    if (boderX) {
      ball.setSpeedX(-ball.getSpeedX());
    }
    if (ball.getStartX() <= 0) {
      ball.setSpeedX(-ball.getSpeedX());
    }
    if (boderY) {
      ball.setSpeedY(-ball.getSpeedY());
    }
    if (ball.getStartY() <= 0) {
      ball.setSpeedY(-ball.getSpeedY());
    }
    ball.setStartX(ball.getStartX() + ball.getSpeedX());
    ball.setStartY(ball.getStartY() + ball.getSpeedY());
    invalidate();
  }

  @Override
  protected void onSizeChanged(int w,int h,int oldw,int oldh) {
    this.width = w;
    this.height = h;
    super.onSizeChanged(w,h,oldw,oldh);
  }
}

