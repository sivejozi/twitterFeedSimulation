package simulation.twitter_feed.view;

import java.util.List;
import java.util.Set;

import simulation.twitter_feed.model.Tweet;
import simulation.twitter_feed.model.TwitterAccount;

public class TwitterAccountsDisplay {

	private Set<TwitterAccount> twitteraccounts;
	
	private Set<String> distinctUsers;

	public TwitterAccountsDisplay(Set<TwitterAccount> twitteraccounts, Set<String> distinctUsers) {
		this.twitteraccounts = twitteraccounts;
		this.distinctUsers = distinctUsers;
	}

	public void displayAll() {
		for (String accountHolder : this.distinctUsers) {
			System.out.println(accountHolder);
			for (TwitterAccount account : this.twitteraccounts) {
				if(accountHolder.equals(account.getAccountHolder()))
					displayUserTweets(account.getTweets());
			}
		}
	}

	private void displayUserTweets(List<Tweet> tweets) {
		for (Tweet tweet : tweets) {
			System.out.println("@" + tweet.getUsersName() + ": " + tweet.getTweet());
		}
	}
}
