package com.davemorrissey.labs.subscaleview;

import com.davemorrissey.labs.subscaleview.bitmap_recycle.BitmapPool;
import com.davemorrissey.labs.subscaleview.bitmap_recycle.BitmapPoolDefaultImpl;
import java.util.concurrent.Executor;

/**
 * Created by laysionqet on 16/4/22.
 */
public final class ConfigurationFactory {
  private ConfigurationFactory() {}

  private static volatile Executor sExecutor;

  /**
   *
   * no confirm guarantee of thread safety, should only invoke this once during app runtime
   *
   * @param executor
   */
  public static void registerAsyncTaskExecutor(Executor executor) {
    if (null == sExecutor) {
      sExecutor = executor;
    }
  }

  /* package */ static Executor getAsyncTaskExecutor() {
    return sExecutor;
  }


  private static volatile BitmapPool sBitmapPool;

  public static void registerBitmapPoolImpl(BitmapPool pool) {
    if (null == pool) {
      return;
    }
    synchronized (ConfigurationFactory.class) {
      sBitmapPool = pool;
    }
  }

  public static BitmapPool getBitmapPool() {
    if (null == sBitmapPool) {
      synchronized (ConfigurationFactory.class) {
        if (null == sBitmapPool) {
          sBitmapPool = new BitmapPoolDefaultImpl();
        }
      }
    }
    return sBitmapPool;
  }
}
