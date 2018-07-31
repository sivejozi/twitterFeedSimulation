package simulation.twitter_feed.model.factory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import simulation.twitter_feed.model.Tweet;

public class TweetFactory extends Factory {
	
	public static List<Tweet> createTweetsFromFile(String tweetFileName) throws FileNotFoundException {
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

}
