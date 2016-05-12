package com.habuma.spitter.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HttpUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testGetMACAddress() throws Exception {
		assertNotNull(HttpUtil.getMACAddress("127.0.0.1"));
	}

}
