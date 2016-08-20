package org.wus32.assessment.fp.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    canvas = (MainCanvas)findViewById(R.id.main_canvas);
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
    switch (IShape.Type.valueOf(tag)) {
      case SQUARE:
        shape = new Square(this);
        break;
      case CIRCLE:
        shape = new Circle(this);
        break;
      case TRIANGLE:
        shape = new Triangle(this);
        break;
    }
    canvas.setShape(shape);
//    canvas.drawSelected();
  }

  @SuppressWarnings("unused")
  public void getColor(View v) {
    selectedColor =
            ((ColorDrawable)v.getBackground()).getColor();
    canvas.setShapeColor(selectedColor);
//    canvas.drawSelected();
  }
}
