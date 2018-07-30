package simulation.twitter_feed.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import simulation.twitter_feed.model.Tweet;
import simulation.twitter_feed.model.TwitterAccount;

public class TwitterAccountsControllerTest {

	private TwitterAccountsController controller;
	
	@Before
	public void setUp() throws Exception {
		controller = new TwitterAccountsController(new ArrayList<Tweet>());
	}

	@Test
	public void testAddAndRemoveFromController() {
		Set<TwitterAccount> tempList = new TreeSet<TwitterAccount>();
		TwitterAccount first = new TwitterAccount();
		TwitterAccount second = new TwitterAccount();
		first.setAccountHolder("User1");
		second.setAccountHolder("User2");
		tempList.add(first);
		tempList.add(second);
		
		controller.addAll(tempList);
		assertEquals(2, controller.getAllTwitterAccounts().size());
	
		controller.clearAccounts();
		assertTrue(controller.getAllTwitterAccounts().isEmpty());
	}

}
