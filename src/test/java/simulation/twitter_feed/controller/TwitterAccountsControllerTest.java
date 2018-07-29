package simulation.twitter_feed.controller;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import simulation.twitter_feed.model.TwitterAccount;
import simulation.twitter_feed.model.TwitterUser;

public class TwitterAccountsControllerTest {

	private TwitterAccountsController controller;
	
	@Before
	public void setUp() throws Exception {
		controller = new TwitterAccountsController();
	}

	@Test
	public void testAddAndRemoveFromController() {
		Set<TwitterAccount> tempList = new TreeSet<TwitterAccount>();
		TwitterAccount first = new TwitterAccount();
		TwitterAccount second = new TwitterAccount();
		first.setAccountHolder(new TwitterUser() {{setName("User1");}});
		second.setAccountHolder(new TwitterUser() {{setName("User2");}});
		tempList.add(first);
		tempList.add(second);
		
		controller.addAll(tempList);
		assertEquals(2, controller.getAllTwitterAccounts().size());
	
		controller.clearAccounts();
		assertTrue(controller.getAllTwitterAccounts().isEmpty());
	}

}
