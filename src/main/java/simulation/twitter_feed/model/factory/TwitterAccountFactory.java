package simulation.twitter_feed.model.factory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import simulation.twitter_feed.model.Tweet;
import simulation.twitter_feed.model.TwitterAccount;

public class TwitterAccountFactory {

	public static List<TwitterAccount> createTwitterAccountsFromFile(String userFileName) throws FileNotFoundException {
		List<TwitterAccount> accounts = new ArrayList<TwitterAccount>();
		InputStream inputStream = getFilePath(userFileName);
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new InputStreamReader(inputStream));
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
		account.setAccountHolder(name);

		Set<String> followsSet = new TreeSet<String>();
		for (String followsName : follows) {
			followsSet.add(followsName);
		}
		account.setFollows(followsSet);
		return account;
	}

	public static List<Tweet> loadTweetsFromFile(String tweetFileName) throws FileNotFoundException {
		List<Tweet> tweets = new ArrayList<Tweet>();
		InputStream inputStream = getFilePath(tweetFileName);
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new InputStreamReader(inputStream));
			while ((line = br.readLine()) != null) {
				String[] parts = line.split("> ");
				String user = parts[0].trim();
				String tweet = parts[1].trim();
				tweets.add(new Tweet(user, tweet));
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
	
	private static InputStream getFilePath(String fileName) throws FileNotFoundException {
		InputStream path = TwitterAccountFactory.class.getClassLoader().getResourceAsStream(fileName);
		if (path == null) {
			throw new FileNotFoundException("Could not find file: " + fileName);
		}
		return path;
	}
}
