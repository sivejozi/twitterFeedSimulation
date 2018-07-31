package simulation.twitter_feed;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import simulation.twitter_feed.controller.TwitterAccountsController;
import simulation.twitter_feed.model.Tweet;
import simulation.twitter_feed.model.TwitterAccount;
import simulation.twitter_feed.model.factory.TwitterAccountFactory;
import simulation.twitter_feed.view.TwitterAccountsDisplay;


public class TwitterFeedSimulationApp {
	
	public static void main(String[] args) throws FileNotFoundException {
		List<TwitterAccount> rawData = TwitterAccountFactory.createTwitterAccountsFromFile(args[0]);		
		List<Tweet> rawTweets = TwitterAccountFactory.createTweetsFromFile(args[1]);
		
		TwitterAccountsController controller = new TwitterAccountsController(rawTweets);
		for(TwitterAccount account : rawData){
			controller.addTwitterAccount(account);
		}
		
		Set<TwitterAccount> twitterAccounts = controller.getAllTwitterAccounts();
		Set<String> distinctUsers = controller.getDistinctUsers();
		TwitterAccountsDisplay accountsDisplay = new TwitterAccountsDisplay(twitterAccounts, distinctUsers);
		accountsDisplay.displayAll();
	}
}
