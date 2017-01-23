/**
 * 
 */
package com.salesforce.challenge.controller;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.salesforce.challenge.model.Tweet;
import com.salesforce.challenge.service.SalesForceTweetsService;

/**
 * @author ksarofem
 * controller which is handel request from the home page and call the service with the filter and return the tweets.
 */
@Controller
public class ViewTweetsController {
	private static final Logger logger = Logger.getLogger(ViewTweetsController.class);
	
	/**
	 * Just display the big page which has the header and filter and also include the sub page (tweets) which will be displayed by ajex
	 * @return the whole view of the page
	 */
	@RequestMapping("/viewTweets")
	public ModelAndView showTweetsPage() {

		//same name as JSP name!
		ModelAndView mv = new ModelAndView("viewTweets");
		return mv;
	}
	
	
	/**
	 * This page get call by ajex method every minute(as configured in java script function)
	 * @param filter the paramater use for filtering the tweets
	 * @return the view with tweets list
	 */
	@RequestMapping("/tweets")
	public ModelAndView tweets(
			@RequestParam(value = "filter", required = true, defaultValue = "") String filter) {
		/*just to record the time of the request*/
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		logger.info( "Filter is{"+filter+"}, datetime{"+dateFormat.format(date)+"}");

		//same name as JSP!
		ModelAndView mv = new ModelAndView("tweets");
		
		mv.addObject("tweets", getTweets(filter));
		/*set the filter back to the model to use it in ui to fill the filter area after it loaded*/
		mv.addObject("filter", filter);
		
		return mv;
	}
	
	/* auto inject the service class -*/
	@Autowired
	SalesForceTweetsService service;
	private List<Tweet> getTweets(String filter){
		//get all the tweets based on filter
		return service.getTweets(filter);
	}
}
