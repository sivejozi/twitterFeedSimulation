package simulation.twitter_feed.model.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import simulation.twitter_feed.model.TwitterAccount;

public class TwitterAccountFactoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreatedTwitterAccountObjectsFromRawData() throws FileNotFoundException{
		List<TwitterAccount> rawTwitterAccountsData = TwitterAccountFactory.createTwitterAccountsFromFile("user.txt");
		assertEquals(3, rawTwitterAccountsData.size());
		
		TwitterAccount lastItem = rawTwitterAccountsData.get(2);
		assertTrue(lastItem.getAccountHolder().equals("Ward"));
		
		assertTrue(lastItem.getFollows().size() == 2);
	}

}
