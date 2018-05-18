/**
 * @(#)NamexTwitter2.java
 *
 * NamexTwitter2 application
 *
 * @author 
 * @version 1.00 2018/5/15
 */
 

import java.io.IOException;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class NamexTwitter {
    private final static String CONSUMER_KEY = "keFKNUL9joRtJGn23VVqdjWoI";
    private final static String CONSUMER_KEY_SECRET = "yVlKql1Ed2kfnwkQzqj0gbKM3Xed6UvwO0aTvnxxB76nJbidAq";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("Hai	, im updating status again from Namex Tweet for Demo");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "qx1XPIXUgmEIAK3lwSLFv7ywA9k6aMK4J2maRe4wAthP4";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "1636821277-TbFczppMeZQkzx3yw4hc8R5kUI0HxuOD21tB6uq";
    }

    public static void main(String[] args) throws Exception {
	new NamexTwitter().start();
    }
}

