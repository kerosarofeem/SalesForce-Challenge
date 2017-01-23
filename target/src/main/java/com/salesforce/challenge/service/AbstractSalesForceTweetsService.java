/**
 * 
 */
package com.salesforce.challenge.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.salesforce.challenge.model.Tweet;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

/**
 * @author ksarofem
 * service class which is connect to tweeter and retrieve tweets based on filter and size for specific public account.
 */
@Service
public abstract class AbstractSalesForceTweetsService implements SalesForceTweetsServiceInterface {
	/*auto inject user value from the property file*/
	private static final Logger logger = Logger.getLogger(AbstractSalesForceTweetsService.class);
	@Value("${user}")
	public  String USER; 
	
	@Value("${count}")
	public  int COUNT; 
	/*made the twitter object static per class init it once and return it manytimes*/
	private static Twitter twitter=null;
	
	/*Auto wire Oauth*/
	@Autowired
	private OAuthConnection oauthConnection;

	/*init twitter once, check of the twitter object if init then return it */
	protected  Twitter getTwitter() {		
		if (twitter==null){
			twitter= new TwitterFactory(oauthConnection.getConfigurationBuilder().build()).getInstance();
		}
		return twitter ;
	}

	/*map twitter status to our twitter object*/
	protected Tweet mapStatusToTweet(Status status) {
		logger.debug("mapStatusToTweet status user name is"+ status.getUser().getName());
		return new Tweet(status.getUser().getName(), status.getUser().getScreenName(),
				status.getUser().getProfileImageURL(), status.getText(), status.getRetweetCount());

	}
	/*map list of status, overloading methed call the other once which take one!!*/
	public List<Tweet> mapStatusToTweet(List<Status> statuses) {
		List<Tweet> tweets= new ArrayList<>();
		for (Status status : statuses) {
			tweets.add(mapStatusToTweet(status));
		}

		return tweets;
	}
	/*map list of status but it check for filter first , overloading methed call the other once which take one!!*/
	public List<Tweet> mapStatusToTweet(List<Status> statuses, String filter) {
		
		List<Tweet> tweets= new ArrayList<>();
		int i=0;
		for (Status status : statuses) {
			/*change twitter text to upper case and the filter to upper case to check all the value *IgnoreCase*/
			if ( status.getText().toUpperCase().contains(filter.toUpperCase())){
				tweets.add(mapStatusToTweet(status));
				i++;
			}
			if(COUNT==i){
				break;
			}
		}

		return tweets;
	}

	public String getUSER() {
		return USER;
	}

	public void setUSER(String uSER) {
		USER = uSER;
	}

	public int getCOUNT() {
		return COUNT;
	}

	public void setCOUNT(int cOUNT) {
		COUNT = cOUNT;
	}

	public OAuthConnection getOAuthConnection() {
		return oauthConnection;
	}

	public void setOAuthConnection(OAuthConnection oauthConnection) {
		this.oauthConnection = oauthConnection;
	}
	
	
}
