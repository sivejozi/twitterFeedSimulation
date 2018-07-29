package simulation.twitter_feed.model.factory;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import simulation.twitter_feed.model.TwitterAccount;

public class TwitterAccountFactoryTest {

	TwitterAccountFactory factory; 
	
	@Before
	public void setUp() throws Exception {
		factory = new TwitterAccountFactory();
	}

	@Test
	public void testReadAllanAndWardsTweetsFromRawDataFile() {
		List<String> allansTweets = factory.getAccountHolderTweets("Alan");
		assertTrue(allansTweets.size() == 2);
		
		List<String> wardsTweet = factory.getAccountHolderTweets("Ward");
		assertTrue(wardsTweet.size() == 1);
	}

	@Test
	public void testCreatedTwitterAccountObjectsFromRawData(){
		List<TwitterAccount> rawTwitterAccountsData = factory.createTwitterAccountsFromFile();
		assertEquals(3, rawTwitterAccountsData.size());
		
		TwitterAccount lastItem = rawTwitterAccountsData.get(2);
		assertTrue(lastItem.getAccountHolder().getName().equals("Ward"));
		
		assertTrue(lastItem.getFollows().size() == 2);
	}

}
