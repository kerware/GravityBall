package fr.caensup.lsts.smb116.gravityball;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread {
    private SurfaceHolder surfaceHolder;
    private GameView gameView;
    private boolean running;
    public static Canvas canvas;


    private int targetFPS = 60;
    private long targetTime = 1000 / targetFPS; // Time per frame in milliseconds

    public MainThread(SurfaceHolder surfaceHolder, GameView gameView) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gameView = gameView;
    }

    public void setRunning(boolean isRunning) {
        running = isRunning;
    }

    @Override
    public void run() {
        long startTime;
        long timeMillis;
        long waitTime;
        while (running) {
            startTime = System.nanoTime();

            canvas = null;

            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.gameView.update();
                    this.gameView.draw(canvas);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            timeMillis = (System.nanoTime() - startTime) / 1000000; // Time taken for the update and draw
            waitTime = targetTime - timeMillis; // Remaining time to match target frame time

            try {
                if (waitTime > 0) {
                    sleep(waitTime); // Wait to maintain target FPS
                }
            } catch (Exception e) {
              //  e.printStackTrace();
            }

        }
    }
}
