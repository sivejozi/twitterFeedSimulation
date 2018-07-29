package simulation.twitter_feed.model.storage;

import java.util.Set;
import java.util.TreeSet;

import simulation.twitter_feed.model.TwitterAccount;

public class TwitterAccountStorage implements Storage<TwitterAccount> {

	private Set<TwitterAccount> accountsStorage;

	private static TwitterAccountStorage instance = null;

	private TwitterAccountStorage() {
		accountsStorage = new TreeSet<TwitterAccount>();
	}

	public static TwitterAccountStorage getInstance() {
		if (instance == null) {
			instance = new TwitterAccountStorage();
		}
		return instance;
	}

	public void add(TwitterAccount t) {
		accountsStorage.add(t);
	}

	public void remove(TwitterAccount t) {
		accountsStorage.remove(t);
	}

	public Set<TwitterAccount> getStorage() {
		return accountsStorage;
	}
	
	public void addAll(Set<TwitterAccount> t) {
		accountsStorage.addAll(t);
	}

	public void clear() {
		accountsStorage.clear();
	}

}
