package com.davemorrissey.labs.subscaleview;

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

  /* package */ static Executor getAsynTaskExecutor() {
    return sExecutor;
  }
}
