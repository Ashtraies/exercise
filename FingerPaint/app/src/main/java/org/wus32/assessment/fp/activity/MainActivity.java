package org.wus32.assessment.fp.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.wus32.assessment.fp.R;
import org.wus32.assessment.fp.util.StorageUtil;
import org.wus32.assessment.fp.util.ToastUtil;
import org.wus32.assessment.fp.view.MainCanvas;
import org.wus32.assessment.fp.view.shape.Circle;
import org.wus32.assessment.fp.view.shape.IShape;
import org.wus32.assessment.fp.view.shape.Square;
import org.wus32.assessment.fp.view.shape.Triangle;

/**
 * The entrance of the app.
 * <p/>
 * Created by Wu Shuang on 2016/8/15.
 */
public class MainActivity extends AppCompatActivity {

  /**
   * A util for toast message on screen.
   */
  private ToastUtil toast;

  /**
   * Current color user selected.
   */
  private int selectedColor;

  /**
   * A custom view on which user can draw shapes.
   */
  private MainCanvas canvas;

  /**
   * The offered shapes and the shape which user currently selected.
   *
   * @see Square,Circle,Triangle
   */
  private IShape currSelected, mainSquare, mainCircle, mainTriangle;

  /**
   * Default scale.
   */
//  private float scale = 1.0f;

  /**
   * How much to zoom.
   */
  public static final float STEP = 0.1f;

  /**
   * Max zoom.
   */
  public static final float MAX = 2.0f;

  /**
   * Min zoom.
   */
  public static final float MIN = 0.5f;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    toast = new ToastUtil(this);
    //Find the views which needed on the screen.
    canvas = (MainCanvas)findViewById(R.id.main_canvas);
    mainSquare = (IShape)findViewById(R.id.main_square);
    mainCircle = (IShape)findViewById(R.id.main_circle);
    mainTriangle = (IShape)findViewById(R.id.main_triangle);
    //Add event handler.
    findViewById(R.id.menu_reset).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Reser current canvas.
        canvas.reset(canvas.getW(),canvas.getH());
      }
    });
    findViewById(R.id.menu_exit).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Finish this activity and exit.
        finish();
      }
    });
    findViewById(R.id.menu_save).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Get the current bitmap on which has users' work.
        Bitmap bitmap = canvas.getCustomBitmap();
        //Save and show tips.
        boolean isSuccessful = StorageUtil.saveBitmap(bitmap);
        if (isSuccessful) {
          toast.showById(R.string.main_storage_success);
        } else {
          toast.showById(R.string.main_storage_failed);
        }
      }
    });
  }

  /**
   * Zoom in the canvas.
   *
   * @param view
   */
  public void zoomIn(View view) {
    float scale = 1;
    scale += STEP;
    if (scale < MAX) {
      canvas.zoom(scale);
    }
  }

  /**
   * Zoom out the canvas.
   *
   * @param view
   */
  public void zoomOut(View view) {
    float scale = 1;
    scale -= STEP;
    if (scale > MIN) {
      canvas.zoom(scale);
    }
  }

  /**
   * A binding action,when user select a shape to draw.
   *
   * @param v
   */
  @SuppressWarnings("unused")
  public void selectShape(View v) {
    String tag = v.getTag().toString();
    IShape shape = null;
    //Hide current selected shape.
    if (currSelected != null) {
      currSelected.setVisibility(View.INVISIBLE);
    }
    //Initialize the shape which user want to draw.
    switch (IShape.Type.valueOf(tag)) {
      case SQUARE:
        shape = new Square(this);
        currSelected = mainSquare;
        break;
      case CIRCLE:
        shape = new Circle(this);
        currSelected = mainCircle;
        break;
      case TRIANGLE:
        shape = new Triangle(this);
        currSelected = mainTriangle;
        break;
    }
    //Display the current selected shape.
    currSelected.setVisibility(View.VISIBLE);
    currSelected.setColor(selectedColor);
    currSelected.invalidate();
    //Tell MainCanvase which shape to draw.
    canvas.setShape(shape);
    //If no color is selected,tell user to choose one.
    if (selectedColor == 0) {
      toast.showById(R.string.main_tips_2);
    }
  }

  /**
   * Get the color which the user want to use.
   *
   * @param v
   */
  @SuppressWarnings("unused")
  public void getColor(View v) {
    //Only when a shape has been selected,then can choose a color.
    //Otherwise give a tips.
    if (currSelected != null) {
      selectedColor =
              ((ColorDrawable)v.getBackground()).getColor();
      canvas.setShapeColor(selectedColor);
      //Refresh the display to let the user know which color he chose.
      currSelected.setColor(selectedColor);
      currSelected.invalidate();
    } else {
      toast.showById(R.string.main_tips_1);
    }
  }
}
