package simulation.twitter_feed.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import static org.junit.Assert.*;

public class TwitterUserTest extends TestCase {

	private TwitterUser user;
	
	private List<String> tweets;
	
	@Before
	protected void setUp() throws Exception {
		tweets = new ArrayList<String>();
		user = new TwitterUser();
	}
	
	@Test
	public void testGettersAndSetterOfUserTwitterUserObject(){
		user.setName("John");
		tweets.add("Johns first tweet");
		user.setTweets(tweets);
		assertEquals("John", user.getName());
		assertEquals(1, user.getTweets().size());
		assertTrue(user.getTweets().get(0).equals("Johns first tweet"));
	}

}
