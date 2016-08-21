package org.wus32.assessment.fp.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import org.wus32.assessment.fp.R;
import org.wus32.assessment.fp.view.MainCanvas;
import org.wus32.assessment.fp.view.shape.Circle;
import org.wus32.assessment.fp.view.shape.IShape;
import org.wus32.assessment.fp.view.shape.Square;
import org.wus32.assessment.fp.view.shape.Triangle;

public class MainActivity extends AppCompatActivity {

  private int selectedColor;

  private IShape selectedShape;

  private MainCanvas canvas;

  private IShape currSelected, mainSquare, mainCircle, mainTriangle;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    canvas = (MainCanvas)findViewById(R.id.main_canvas);
    mainSquare = (IShape)findViewById(R.id.main_square);
    mainCircle = (IShape)findViewById(R.id.main_circle);
    mainTriangle = (IShape)findViewById(R.id.main_triangle);
    findViewById(R.id.menu_reset).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        canvas.reset(canvas.getW(),canvas.getH());
      }
    });
    findViewById(R.id.menu_exit).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        finish();
      }
    });
  }

  @SuppressWarnings("unused")
  public void selectShape(View v) {
    String tag = v.getTag().toString();
    IShape shape = null;
    if (currSelected != null) {
      currSelected.setVisibility(View.GONE);
    }
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
    currSelected.setVisibility(View.VISIBLE);
    currSelected.setColor(selectedColor);
    currSelected.invalidate();
    canvas.setShape(shape);
    if(selectedColor == 0) {
      Toast.makeText(this,getResources().getString(R.string.main_tips_2),Toast.LENGTH_SHORT).show();
    }
  }

  @SuppressWarnings("unused")
  public void getColor(View v) {
    if (currSelected != null) {
      selectedColor =
              ((ColorDrawable)v.getBackground()).getColor();
      canvas.setShapeColor(selectedColor);
      currSelected.setColor(selectedColor);
      currSelected.invalidate();
    } else {
      Toast.makeText(this,getResources().getString(R.string.main_tips_1),Toast.LENGTH_SHORT).show();
    }
  }
}
