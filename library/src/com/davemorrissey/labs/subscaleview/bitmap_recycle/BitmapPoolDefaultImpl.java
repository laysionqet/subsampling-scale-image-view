package com.davemorrissey.labs.subscaleview.bitmap_recycle;

import android.graphics.Bitmap;

/**
 * Created by laysionqet on 16/5/9.
 */
public final class BitmapPoolDefaultImpl implements BitmapPool {
  @Override public Bitmap get(int width, int height, Bitmap.Config config) {
    return null;
  }

  @Override public boolean put(Bitmap bitmap) {
    return false;
  }
}
