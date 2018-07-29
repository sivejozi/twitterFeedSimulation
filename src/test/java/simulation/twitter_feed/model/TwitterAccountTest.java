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
	private TwitterUser accountHolder;
	private List<String> accountHolderTweets;

	@Before
	public void setUp() throws Exception {
		twitterAccount = new TwitterAccount();
	}

	@Test
	public void testAccountHolderOfTwitterAccount() {
		accountHolder = new TwitterUser();
		accountHolder.setName("Cole");
		accountHolderTweets = new ArrayList<String>();
		accountHolderTweets.add("Coles first tweet");
		accountHolder.setTweets(accountHolderTweets);
		twitterAccount.setAccountHolder(accountHolder);
		
		assertEquals("Cole", accountHolder.getName());
		assertTrue(accountHolder.getTweets().get(0).equals("Coles first tweet"));
		assertNotNull(twitterAccount.getAccountHolder());
	}
	
	@Test
	public void testThisTwitterAccountsFollows() {
		Set<TwitterUser> follows = new TreeSet<TwitterUser>();
		TwitterUser firstFollow = new TwitterUser();
		firstFollow.setName("Eric");
		follows.add(firstFollow);
		twitterAccount.setFollows(follows);
		
		assertTrue(twitterAccount.getFollows().size() == 1);
	}

}
