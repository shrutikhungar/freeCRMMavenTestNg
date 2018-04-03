
/**
 * @author D E L L
 *
 */
package com.crm.qa.util;

import java.io.IOException;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	
	public void switchToFrame(String frameName) {
		driver.switchTo().frame(frameName);
	}
	
}