/**
 * 
 */
package com.salesforce.challenge.service;

import java.util.List;

import com.salesforce.challenge.model.Tweet;

import twitter4j.Status;

/**
 * @author ksarofem
 * used by SalesForceTweetsService class 
 */
public interface SalesForceTweetsServiceInterface {
	
	// retrive all tweets based on filter
	public List<Tweet> getTweets(String filter);
	// mapp tweets based with filter.
	public List<Tweet> mapStatusToTweet(List<Status> statuses, String filter);
	//map tweets based.-Overloading
	public List<Tweet> mapStatusToTweet(List<Status> statuses);
	
	
}
