package org.rpc.remoting.util;

import org.junit.Assert;
import org.junit.Test;
import org.rpc.remoting.helper.StringUtil;

public class StringUtilsTest {
	
	@Test
	public void isEmptyTest(){
		String str1 = "sss";
		String str2 = "  ";
		String str3 = "";
		String str4 = null;
		Assert.assertEquals(false, StringUtil.isEmpty(str1));
		Assert.assertEquals(false, StringUtil.isEmpty(str2));
		Assert.assertEquals(true, StringUtil.isEmpty(str3));
		Assert.assertEquals(true, StringUtil.isEmpty(str4));
	}
	
	@Test
	public void isNumeric(){
		String str1 = "0313";
		String str2 = "313b";
		String str3 = "23433";
		Assert.assertEquals(false, StringUtil.isNumeric(str1));
		Assert.assertEquals(false, StringUtil.isNumeric(str2));
		Assert.assertEquals(true, StringUtil.isNumeric(str3));
	}
}