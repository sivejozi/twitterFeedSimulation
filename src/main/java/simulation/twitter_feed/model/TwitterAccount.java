package simulation.twitter_feed.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class TwitterAccount implements Serializable, Comparable<TwitterAccount> {

	private static final long serialVersionUID = 1L;

	private String accountHolder;
	
	private Set<String> follows;
	
	private List<Tweet> tweets;
	
	public TwitterAccount(String accountHolder, Set<String> follows, List<Tweet> tweets) {
		this.accountHolder = accountHolder;
		this.follows = follows;
		this.tweets = tweets;
	}
	
	public TwitterAccount() {
	}

	public String getAccountHolder() {
		return accountHolder;
	}
	
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	
	public Set<String> getFollows() {
		return follows;
	}
	
	public void setFollows(Set<String> follows) {
		this.follows = follows;
	}

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountHolder == null) ? 0 : accountHolder.hashCode());
		result = prime * result + ((follows == null) ? 0 : follows.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TwitterAccount other = (TwitterAccount) obj;
		if (accountHolder == null) {
			if (other.accountHolder != null)
				return false;
		} else if (!accountHolder.equals(other.accountHolder))
			return false;
		if (follows == null) {
			if (other.follows != null)
				return false;
		} else if (!follows.equals(other.follows))
			return false;
		return true;
	}

	public int compareTo(TwitterAccount o) {
		if (this == o)
			return 0;
		return this.getAccountHolder().compareTo(o.getAccountHolder());
	}
}
