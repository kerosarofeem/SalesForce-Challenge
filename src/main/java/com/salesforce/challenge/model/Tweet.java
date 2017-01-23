/**
 * 
 */
package com.salesforce.challenge.model;

import java.io.Serializable;

import org.apache.log4j.Logger;

/**
 * @author ksarofem
 * Model class represent the tweet info, per requirements.
 */

public class Tweet implements TweetInterface,Serializable{
	private static final Logger logger = Logger.getLogger(Tweet.class);
//	­ user name 
//	­ user screen name (@screen_name) 
//	­ user profile image 
//	­ tweet content 
//	­ how many times the message was retweeted 

	private static final long serialVersionUID = 1L;
	private String userName;
	private String userScreenName;
	private String userProfileImage;
	private String tweetContent;
	private int retweeted;
	
	public Tweet(){}
	
	/* constructor that takes all the require data once */
	public Tweet(String userName, String userScreenName, String userProfileImage, String tweetContent, int retweeted  ){
		logger.debug("userName "+userName+ " userScreenName "+
	userScreenName+" userProfileImage "+ userProfileImage+ " tweetContent "+ tweetContent + " retweeted "+ retweeted);
		this.setUserName(userName);
		this.setUserScreenName(userScreenName);
		this.setUserProfileImage(userProfileImage);
		this.setTweetContent(tweetContent);
		this.setRetweeted(retweeted);
	}
	
	
	@Override
	public void setUserName(String userName) {
		this.userName=userName;
		
	}
	@Override
	public String getUserName() {
		return userName;
	}
	@Override
	public String getUserScreenName() {
		return userScreenName;
	}
	@Override
	public void setUserScreenName(String userScreenName) {
		this.userScreenName=userScreenName;
		
	}
	@Override
	public String getUserProfileImage() {
		return userProfileImage;
	}
	@Override
	public void setUserProfileImage(String userProfileImage) {
		this.userProfileImage=userProfileImage;
		
	}
	@Override
	public String getTweetContent() {
		return tweetContent;
	}
	@Override
	public void setTweetContent(String tweetContent) {
		this.tweetContent=tweetContent;
	}
	@Override
	public int getRetweeted() {
		return retweeted;
	}
	@Override
	public void setRetweeted(int retweeted) {
		this.retweeted=retweeted;
	}

}
