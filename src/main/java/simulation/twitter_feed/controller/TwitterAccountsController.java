package simulation.twitter_feed.controller;

import java.util.Set;

import simulation.twitter_feed.model.TwitterAccount;
import simulation.twitter_feed.model.storage.TwitterAccountStorage;
import simulation.twitter_feed.model.TwitterUser;

public class TwitterAccountsController {

	private TwitterAccountStorage storage = TwitterAccountStorage.getInstance();

	public TwitterAccountsController() {
	}

	public Set<TwitterAccount> getAllTwitterAccounts() {
		return storage.getStorage();
	}

	public void addTwitterAccount(TwitterAccount twitterAccount) {
		mergeAccountHolderFollows(twitterAccount);
		storage.add(twitterAccount);
	}

	public void removeTwitterAcount(TwitterAccount twitterAccount) {
		storage.remove(twitterAccount);
	}

	public void addAll(Set<TwitterAccount> accounts) {
		storage.addAll(accounts);
	}

	public void clearAccounts() {
		storage.clear();
	}

	public void mergeAccountHolderFollows(TwitterAccount twitterAccount) {
		for (TwitterAccount exsitingAccount : getAllTwitterAccounts()) {
			if (exsitingAccount.getAccountHolder().equals(twitterAccount.getAccountHolder())) {
				for (TwitterUser userToAddsFollow : twitterAccount.getFollows()) {
					if (!(exsitingAccount.getFollows().contains(userToAddsFollow)))
						exsitingAccount.getFollows().add(userToAddsFollow);
				}
			}
		}
	}
}
