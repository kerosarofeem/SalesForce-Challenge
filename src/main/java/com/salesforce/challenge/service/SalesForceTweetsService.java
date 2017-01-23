/**
 * 
 */
package com.salesforce.challenge.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.salesforce.challenge.model.Tweet;

import twitter4j.TwitterException;

/**
 * @author ksarofem
 *
 */
@Service
public class SalesForceTweetsService extends AbstractSalesForceTweetsService {
	private static final Logger logger = Logger.getLogger(SalesForceTweetsService.class);
	/* (non-Javadoc)
	 * @see com.salesforce.challenge.service.SalesForceTweetsServiceInterface#getTweets(java.lang.String)
	 *this method responsible to retrieve all the tweets based on filter
	 */
	@Override
	public List<Tweet> getTweets(String filter) {
		List<Tweet> tweets = new ArrayList<>();
		try{
		if ( filter == null || filter.isEmpty()){
			// if filter is empty then retrive last 10 tweets.. easy!!
			logger.debug("Filter is empty");
			tweets=mapStatusToTweet(getTwitter().getUserTimeline(USER).subList(0,COUNT ));
		}else{
			// if filter is not empty then get everything and then will check the tweet text and get latest 10 contains this filter
			logger.debug("Filter is{"+filter+"}");
			tweets=mapStatusToTweet(getTwitter().getUserTimeline(USER), filter);
		}
		}catch(TwitterException te){
            te.printStackTrace();
            logger.error("Failed to get timeline: " + te.getMessage());
		}
		
		return tweets;
	}



}
