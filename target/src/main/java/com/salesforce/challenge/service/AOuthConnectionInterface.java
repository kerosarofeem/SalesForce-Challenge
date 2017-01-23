package com.salesforce.challenge.service;

import twitter4j.conf.ConfigurationBuilder;

/**
 * idea here to implement facet interface to hide the complexity of the connectivity
 * @author ksarofem
 *
 */
public interface AOuthConnectionInterface {

	public ConfigurationBuilder getConfigurationBuilder();

}