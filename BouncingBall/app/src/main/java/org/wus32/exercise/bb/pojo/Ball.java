package org.wus32.exercise.bb.pojo;

import android.graphics.Color;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ashtray on 2016/8/4.
 */
public class Ball implements Serializable, Cloneable {

  private int startX, startY;

  private int colour;

  private int speedX, speedY;

  private float radius;

  public Ball() {
  }

  public int getStartX() {
    return startX;
  }

  public void setStartX(int startX) {
    this.startX = startX;
  }

  public int getStartY() {
    return startY;
  }

  public void setStartY(int startY) {
    this.startY = startY;
  }

  public int getColour() {
    return colour;
  }

  public void setColour(int colour) {
    this.colour = colour;
  }

  public int getSpeedX() {
    return speedX;
  }

  public void setSpeedX(int speedX) {
    this.speedX = speedX;
  }

  public int getSpeedY() {
    return speedY;
  }

  public void setSpeedY(int speedY) {
    this.speedY = speedY;
  }

  public float getRadius() {
    return radius;
  }

  public void setRadius(float radius) {
    this.radius = radius;
  }

  @Override
  public String toString() {
    return "Ball{" +
            "startX=" + startX +
            ", startY=" + startY +
            ", colour=" + colour +
            ", speedX=" + speedX +
            ", speedY=" + speedY +
            ", radius=" + radius +
            '}';
  }

  public static List<Ball> getSomeBalls(int num) {
    List<Ball> list = new ArrayList<>(num);
    for (int i = 0;i < num;i++) {
      Ball ball = new Ball();
      ball.startX = r(100);
      ball.startY = r(100);
      ball.speedX = r(30);
      ball.speedY = r(30);
      ball.radius = r(70);
      ball.colour = c();
      list.add(ball);
    }
    return list;
  }

  static int r() {
    return new Random().nextInt(50);
  }

  static int r(int seed) {
    return new Random().nextInt(seed);
  }

  static int c() {
    int[] colors = {
            Color.RED,
            Color.BLACK,
            Color.DKGRAY,
            Color.GRAY,
            Color.LTGRAY,
            Color.WHITE,
            Color.RED,
            Color.GREEN,
            Color.BLUE,
            Color.YELLOW,
            Color.CYAN,
            Color.MAGENTA,
    };
    return colors[new Random().nextInt(12)];
  }
}
