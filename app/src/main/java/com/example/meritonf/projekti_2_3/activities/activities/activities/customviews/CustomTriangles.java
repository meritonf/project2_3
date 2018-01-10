package com.example.meritonf.projekti_2_3.activities.activities.activities.customviews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by meritonf on 1/3/2018.
 */
@SuppressLint("AppCompatCustomView")
public class CustomTriangles extends ImageView {

    private Paint color2, strokecolor;

    public CustomTriangles(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setupPaint();
    }

    private void setupPaint(){


        strokecolor = new Paint();
        strokecolor.setStyle(Paint.Style.STROKE);
        strokecolor.setColor(Color.BLUE);
        strokecolor.setStrokeWidth(30);

        color2 = new Paint();
        color2.setColor(Color.GREEN);
    }

    protected void onDraw(Canvas canvas){

        drawTriangle(canvas,strokecolor,600,1000,220);
        drawTriangle(canvas,strokecolor,400,1000,220);
        drawTriangle(canvas,strokecolor,500,800,220);
        drawTriangle(canvas,strokecolor,300,1200,220);
        drawTriangle(canvas,strokecolor,500,1200,220);
        drawTriangle(canvas,strokecolor,700,1200,220);

        drawBackwardsTriangle(canvas,color2,500,1000,180);
        drawBackwardsTriangle(canvas,color2,400,800,180);
        drawBackwardsTriangle(canvas,color2,600,800,180);

    }

    public void drawTriangle(Canvas canvas, Paint paint, int x, int y, int width) {
        int halfWidth = width / 2;

        Path path = new Path();
        path.moveTo(x, y - halfWidth); // Top
        path.lineTo(x - halfWidth, y + halfWidth); // Bottom left
        path.lineTo(x + halfWidth, y + halfWidth); // Bottom right
        path.lineTo(x, y - halfWidth); // Back to Top
        path.close();


        canvas.save();
        canvas.drawPath(path, paint);

        canvas.restore();
    }

    public void drawBackwardsTriangle(Canvas canvas, Paint paint,int x, int y, int width){
        int halfWidth = width / 2;

        Path path = new Path();
        path.moveTo(x, y - halfWidth); // Top
        path.lineTo(x - halfWidth, y + halfWidth); // Bottom left
        path.lineTo(x + halfWidth, y + halfWidth); // Bottom right
        path.lineTo(x, y - halfWidth); // Back to Top
        path.close();


        canvas.save();
        canvas.rotate(180,500,1000);
        canvas.drawPath(path, paint);
        canvas.restore();
    }
}
