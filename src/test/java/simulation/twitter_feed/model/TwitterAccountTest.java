package simulation.twitter_feed.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

public class TwitterAccountTest {
	
	private TwitterAccount twitterAccount;
	
	private List<Tweet> accountHolderTweets;

	@Before
	public void setUp() throws Exception {
		twitterAccount = new TwitterAccount();
	}

	@Test
	public void testAccountHolderOfTwitterAccount() {
		accountHolderTweets = new ArrayList<Tweet>();
		accountHolderTweets.add(new Tweet("Cole", "Coles first tweet"));
		twitterAccount.setTweets(accountHolderTweets);
		twitterAccount.setAccountHolder("Cole");
		
		assertEquals("Cole", twitterAccount.getAccountHolder());
		assertTrue(twitterAccount.getTweets().get(0).getTweet().equals("Coles first tweet"));
		assertNotNull(twitterAccount.getAccountHolder());
	}
	
	@Test
	public void testThisTwitterAccountsFollows() {
		Set<String> follows = new TreeSet<String>();
		follows.add("Eric");
		twitterAccount.setFollows(follows);
		assertTrue(twitterAccount.getFollows().size() == 1);
	}

}
