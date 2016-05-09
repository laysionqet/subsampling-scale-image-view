package com.davemorrissey.labs.subscaleview.bitmap_recycle;

import android.graphics.Bitmap;

/**
 * Created by laysionqet on 16/5/9.
 */
public interface BitmapPool {
  Bitmap get(int width, int height, Bitmap.Config config);
  boolean put(Bitmap bitmap);
}
