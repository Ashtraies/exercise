package org.wus32.test;

import android.app.Application;
import android.test.ApplicationTestCase;

import org.apache.log4j.Logger;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

  Logger l = Logger.getLogger(getClass());

  public ApplicationTest() {
    super(Application.class);
  }
}