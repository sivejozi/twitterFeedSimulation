package simulation.twitter_feed.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import simulation.twitter_feed.model.Tweet;
import simulation.twitter_feed.model.TwitterAccount;
import simulation.twitter_feed.model.storage.TwitterAccountStorage;

public class TwitterAccountsController {

	private TwitterAccountStorage storage = TwitterAccountStorage.getInstance();

	private List<Tweet> tweets;

	public TwitterAccountsController(List<Tweet> tweets) {
		this.tweets = tweets;
	}

	public Set<TwitterAccount> getAllTwitterAccounts() {
		return storage.getStorage();
	}

	public void addTwitterAccount(TwitterAccount twitterAccount) {
		mergeAccountHolderFollows(twitterAccount);
		twitterAccount.setTweets(getAccountTweets(twitterAccount));
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

	private List<Tweet> getAccountTweets(TwitterAccount twitterAccount) {
		Set<String> allUsers = new TreeSet<String>();
		List<Tweet> orderedTweets = new ArrayList<Tweet>();
		allUsers.add(twitterAccount.getAccountHolder());
		allUsers.addAll(twitterAccount.getFollows());
		for (Tweet tweet : tweets) {
			for (String user : allUsers) {
				if (tweet.getUsersName().equals(user)) {
					orderedTweets.add(tweet);
				}
			}
		}
		return orderedTweets;
	}

	public void mergeAccountHolderFollows(TwitterAccount twitterAccount) {
		for (TwitterAccount exsitingAccount : getAllTwitterAccounts()) {
			if (exsitingAccount.getAccountHolder().equals(twitterAccount.getAccountHolder())) {
				for (String userToAddsFollow : twitterAccount.getFollows()) {
					if (!(exsitingAccount.getFollows().contains(userToAddsFollow)))
						exsitingAccount.getFollows().add(userToAddsFollow);
				}
			}
		}
	}

	public Set<String> getDistinctUsers() {
		Set<String> distinctUsers = new TreeSet<String>();
		for (TwitterAccount acc : getAllTwitterAccounts()) {
			distinctUsers.add(acc.getAccountHolder());
			distinctUsers.addAll(acc.getFollows());
		}
		return distinctUsers;
	}
}
