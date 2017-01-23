package com.salesforce.challenge.model;

/**
 * Interface for the tweet model, 
 * best practice to use interface you might need to refactor that in future using decorate design
 * */
public interface TweetInterface {

	public void setUserName(String userName);

	public String getUserName();

	public String getUserScreenName();

	public void setUserScreenName(String userScreenName);

	public String getUserProfileImage();

	public void setUserProfileImage(String userProfileImage);

	public String getTweetContent();

	public void setTweetContent(String tweetContent);

	public int getRetweeted();

	public void setRetweeted(int retweeted);
}
