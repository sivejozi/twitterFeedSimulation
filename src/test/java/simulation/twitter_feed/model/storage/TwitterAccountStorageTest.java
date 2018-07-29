package simulation.twitter_feed.model.storage;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import simulation.twitter_feed.model.TwitterAccount;
import simulation.twitter_feed.model.TwitterUser;

public class TwitterAccountStorageTest {
	
	private TwitterAccount twitterAccount;
	private TwitterUser accountHolder;
	private TwitterAccountStorage storage;

	@Before
	public void setUp() throws Exception {
		storage = TwitterAccountStorage.getInstance();
	}
	
	@Test
	public void testAddAndRemoveTwitterAccountsToAndFromStorageRespectively(){
		accountHolder = new TwitterUser();
		twitterAccount = new TwitterAccount();
		accountHolder.setName("Cole");
		twitterAccount.setAccountHolder(accountHolder);
		
		storage.add(twitterAccount);
		assertEquals(1, storage.getStorage().size());
		
		storage.remove(twitterAccount);
		assertTrue(storage.getStorage().isEmpty());
	}
	
	@Test
	public void testAddallAndClearStorageFunctions(){
		Set<TwitterAccount> tempList = new TreeSet<TwitterAccount>();
		TwitterAccount first = new TwitterAccount();
		TwitterAccount second = new TwitterAccount();
		first.setAccountHolder(new TwitterUser() {{setName("User1");}});
		second.setAccountHolder(new TwitterUser() {{setName("User2");}});
		tempList.add(first);
		tempList.add(second);
		
		storage.addAll(tempList);
		assertEquals(2, storage.getStorage().size());
	
		storage.clear();
		assertTrue(storage.getStorage().isEmpty());
	}
}
