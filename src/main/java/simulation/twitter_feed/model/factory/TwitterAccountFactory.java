package simulation.twitter_feed.model.factory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import simulation.twitter_feed.model.TwitterAccount;
import simulation.twitter_feed.model.TwitterUser;

public class TwitterAccountFactory {

	private static String USER_FILENAME = "user.txt";

	private static String TWEET_FILENAME = "tweet.txt";

	public static List<TwitterAccount> createTwitterAccountsFromFile() {
		List<TwitterAccount> accounts = new ArrayList<TwitterAccount>();
		URL path = TwitterAccountFactory.class.getResource(USER_FILENAME);
		File file = null;
		BufferedReader br = null;
		try {
			String line;
			file = new File(path.getFile());
			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {
				String[] parts = line.split("follows");
				String name = parts[0].trim();
				String followsParts = parts[1].trim();
				String[] follows = followsParts.split(", ");

				TwitterAccount account = populateTwitterAccount(name, follows);
				accounts.add(account);
			}
		} catch (IOException e) {
			throw new RuntimeException("Error creating twitter account objects : " + e);
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException ex) {
				throw new RuntimeException("Problem occured. Cannot close reader : " + ex.getMessage());
			}
		}
		return accounts;
	}

	public static TwitterAccount populateTwitterAccount(String name, String[] follows) {
		TwitterAccount account = new TwitterAccount();
		List<String> feeds = getAccountHolderTweets(name);
		TwitterUser accountHolder = new TwitterUser(name, feeds);
		account.setAccountHolder(accountHolder);

		Set<TwitterUser> followsSet = new TreeSet<TwitterUser>();
		for (String followsName : follows) {
			followsSet.add(new TwitterUser(followsName, getAccountHolderTweets(followsName)));
		}
		account.setFollows(followsSet);
		return account;
	}

	public static List<String> getAccountHolderTweets(String name) {
		List<String> tweets = new ArrayList<String>();
		URL path = TwitterAccountFactory.class.getResource(TWEET_FILENAME);
		File file = new File(path.getFile());
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {
				String[] parts = line.split("> ");
				String user = parts[0].trim();
				String tweet = parts[1].trim();
				if (name.equals(user))
					tweets.add(tweet);
			}
		} catch (IOException e) {
			throw new RuntimeException("Error getting account holders tweets : " + e);
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException ex) {
				throw new RuntimeException("Problem occured. Cannot close reader : " + ex.getMessage());
			}
		}
		return tweets;
	}
}
