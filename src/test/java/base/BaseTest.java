/**
 * 
 */
package base;

import com.salesforce.challenge.service.OAuthConnection;
import com.salesforce.challenge.service.SalesForceTweetsService;

/**
 * @author ksarofem
 *
 */
public abstract class BaseTest {

	
	private static String oAuthConsumerKey = "1TtUd7VisfS4YJOCxudF41NOP";
	private static String oAuthConsumerSecret = "PBlti4Zglb4HO7jhEp1ARcAfHTAflfivxIS5ASye4sRrE3oDtI";
	private static String oAuthAccessToken = "45580229-ibaEeZNyMjgNXCwrnXZxoQt8NDLMqQHCrttnPFVc4";
	private static String oAuthAccessTokenSecret = "DuXgiJs820Ag6yI6c73U6ddvFc7xZSt2RzKV91S4yzgMs";
	public static int count = 10;
	public static String user = "salesforce";
			
	OAuthConnection connection= new OAuthConnection();
	
	public OAuthConnection getConnection(){
		connection.setoAuthConsumerKey(oAuthConsumerKey);
		connection.setoAuthConsumerSecret(oAuthConsumerSecret);
		connection.setoAuthAccessToken(oAuthAccessToken);
		connection.setoAuthAccessTokenSecret(oAuthAccessTokenSecret);
		return connection;
	}
	
	public SalesForceTweetsService getService(){
		SalesForceTweetsService service= new SalesForceTweetsService();
		service.COUNT=count;
		service.USER=user;
		service.setOAuthConnection(getConnection());
		return service;
	}
}
