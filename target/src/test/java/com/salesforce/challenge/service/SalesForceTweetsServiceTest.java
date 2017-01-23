package com.salesforce.challenge.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import base.BaseTest;


public class SalesForceTweetsServiceTest  extends BaseTest{
	
	SalesForceTweetsService service; 

	@Before
	public void initService(){
		service=getService();
	}
	
	public void tearDown() throws Exception {
	}

	@Test
	public void testWithEmptyFilter() {
		String filter="";
		Assert.assertEquals(count, service.getTweets(filter).size());
		
	}
	
	@Test
	public void testWithNullFilter() {
		String filter=null;
		Assert.assertEquals(count, service.getTweets(filter).size());
		
	}
	
	@Test
	public void testWithStringFilter() {
		String filter="Sales";
		Assert.assertTrue(count>= service.getTweets(filter).size());
		
	}
	
	@Test
	public void testWithNumberFilter() {
		String filter="0";
		Assert.assertTrue(count>= service.getTweets(filter).size());
		
	}
	
	

}
