package com.example.bravepilot.Components;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.example.bravepilot.Views.GameView.screenRatioX;
import static com.example.bravepilot.Views.GameView.screenRatioY;

import com.example.bravepilot.R;

public class Bullet {
    public int x;
    public int y;
    public int width;
    public int height;
    public Bitmap bullet;

    public Bullet(Resources res) {

        bullet = BitmapFactory.decodeResource(res, R.drawable.bullet);

        width = bullet.getWidth();
        height = bullet.getHeight();

        width /= 4;
        height /= 4;

        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        bullet = Bitmap.createScaledBitmap(bullet, width, height, false);

    }

    public Rect getCollisionShape() {
        return new Rect(x, y, x + width, y + height);
    }

}
