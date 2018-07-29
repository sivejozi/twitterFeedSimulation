package simulation.twitter_feed;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import simulation.twitter_feed.controller.TwitterAccountsController;
import simulation.twitter_feed.model.TwitterAccount;
import simulation.twitter_feed.model.TwitterUser;
import simulation.twitter_feed.model.factory.TwitterAccountFactory;
import simulation.twitter_feed.model.storage.TwitterAccountStorage;
import simulation.twitter_feed.view.TwitterAccountsDisplay;


public class App {

	public static void main(String[] args) {
		List<TwitterAccount> rawData = TwitterAccountFactory.createTwitterAccountsFromFile();

		TwitterAccountsController controller = new TwitterAccountsController();

		for(TwitterAccount account : rawData){
			controller.addTwitterAccount(account);
		}
		
		System.out.println(TwitterAccountStorage.getInstance().getStorage().size());
		
		
		Set<TwitterAccount> twitterAccounts = controller.getAllTwitterAccounts();

		for(TwitterAccount acc : twitterAccounts){
			System.out.println("Holder : "+acc.getAccountHolder().getName());
			for(TwitterUser ff : acc.getFollows()){
				System.out.println("Follows : "+ff.getName());
			}
			System.out.println("-----------------------------------------");
		}
		
		
		TwitterAccountsDisplay accountsDisplay = new TwitterAccountsDisplay(twitterAccounts);
		accountsDisplay.displayAll();
	}
}
