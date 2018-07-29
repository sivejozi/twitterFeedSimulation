package simulation.twitter_feed.view;

import java.util.Set;

import simulation.twitter_feed.model.TwitterAccount;
import simulation.twitter_feed.model.TwitterUser;

public class TwitterAccountsDisplay {
	
	private Set<TwitterAccount> twitteraccounts;
	
	public TwitterAccountsDisplay(Set<TwitterAccount> twitteraccounts){
		this.twitteraccounts = twitteraccounts;
	}
	
	public void displayAll(){
		for(TwitterAccount account : this.twitteraccounts){
			displayUserTweets(account.getAccountHolder());
			for(TwitterUser follow : account.getFollows() ){
				displayUserTweets(follow);
			}
		}
	}
	
	
	private void displayUserTweets(TwitterUser user){
		System.out.println(user.getName());
		if(!(user.getTweets().isEmpty())){
			for(String feed : user.getTweets()){
				System.out.println("@"+user.getName()+":"+feed);
			}
		}
	}
	
	/**
	 * So invoking your program with user.txt and tweet.txt as arguments should produce the following console output:
		Alan
		@Alan: If you have a procedure with 10 parameters, you probably missed some.
		@Alan: Random numbers should not be generated with a method chosen at random.
		Martin
		Ward
		@Alan: If you have a procedure with 10 parameters, you probably missed some.
		@Ward: There are only two hard things in Computer Science: cache invalidation, naming things and off-by-1 errors.
		@Alan: Random numbers should not be generated with a method chosen at random.
	
	 */
}
