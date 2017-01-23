/**
 * 
 */
package com.salesforce.challenge.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import twitter4j.conf.ConfigurationBuilder;

/**
 * @author ksarofem
 * implement AOuthConnectionInterface to apply facet design pattern in case there more connections
 */
@Configuration
public class OAuthConnection implements AOuthConnectionInterface,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
/**
 * obtain these info from properties file, to do that you have to create an account
 * in twitter dev and create an app to have Oauth credentials.
 */
	@Value("${oAuthConsumerKey}")
	private String oAuthConsumerKey;
	@Value("${oAuthConsumerSecret}")
	private String oAuthConsumerSecret;
	@Value("${oAuthAccessToken}")
	private String oAuthAccessToken;
	@Value("${oAuthAccessTokenSecret}")
	private String oAuthAccessTokenSecret;
	
	private ConfigurationBuilder cb;
	
	/* (non-Javadoc)
	 * @see com.salesforce.challenge.service.AOuthConnectionInterface#getConfigurationBuilder()
	 * create configuration builder to usign oauth params
	 */
	//@Override
	@Bean
	public ConfigurationBuilder getConfigurationBuilder(){
	cb = new ConfigurationBuilder();
    cb.setDebugEnabled(true).setOAuthConsumerKey(oAuthConsumerKey)
            .setOAuthConsumerSecret(oAuthConsumerSecret)
            .setOAuthAccessToken(oAuthAccessToken)
            .setOAuthAccessTokenSecret(oAuthAccessTokenSecret);
    return cb;
	}

	public String getoAuthConsumerKey() {
		return oAuthConsumerKey;
	}

	public void setoAuthConsumerKey(String oAuthConsumerKey) {
		this.oAuthConsumerKey = oAuthConsumerKey;
	}

	public String getoAuthConsumerSecret() {
		return oAuthConsumerSecret;
	}

	public void setoAuthConsumerSecret(String oAuthConsumerSecret) {
		this.oAuthConsumerSecret = oAuthConsumerSecret;
	}

	public String getoAuthAccessToken() {
		return oAuthAccessToken;
	}

	public void setoAuthAccessToken(String oAuthAccessToken) {
		this.oAuthAccessToken = oAuthAccessToken;
	}

	public String getoAuthAccessTokenSecret() {
		return oAuthAccessTokenSecret;
	}

	public void setoAuthAccessTokenSecret(String oAuthAccessTokenSecret) {
		this.oAuthAccessTokenSecret = oAuthAccessTokenSecret;
	}
	
}
