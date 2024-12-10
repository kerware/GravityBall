package fr.caensup.lsts.smb116.gravityball;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Ball {
    private int x, y, radius;
    private int dx, dy; // Velocity components
    private Paint paint;

    public Ball(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        dx = 5; // Speed along X-axis
        dy = 5; // Speed along Y-axis
        paint = new Paint();
        paint.setColor(Color.BLUE); // Ball color
    }

    public void setVelocity(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }


    public void update(int screenWidth, int screenHeight) {
        x += dx;
        y += dy;

        // Check for collision with left or right border
        if (x < radius || x > screenWidth - radius) {
            //dx = -dx;
        }

        // Check for collision with top or bottom border
        if (y < radius || y > screenHeight - radius) {
            //dy = -dy;
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(x, y, radius, paint);
    }
}
