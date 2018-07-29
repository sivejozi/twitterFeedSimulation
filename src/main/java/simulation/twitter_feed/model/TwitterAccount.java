package simulation.twitter_feed.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class TwitterAccount implements Serializable, Comparable<TwitterAccount> {

	private static final long serialVersionUID = 1L;

	private TwitterUser accountHolder;
	
	private Set<TwitterUser> follows;
	
	public TwitterAccount(TwitterUser accountHolder, Set<TwitterUser> follows) {
		this.accountHolder = accountHolder;
		this.follows = follows;
	}
	
	public TwitterAccount() {
	}

	public TwitterUser getAccountHolder() {
		return accountHolder;
	}
	
	public void setAccountHolder(TwitterUser accountHolder) {
		this.accountHolder = accountHolder;
	}
	
	public Set<TwitterUser> getFollows() {
		return follows;
	}
	
	public void setFollows(Set<TwitterUser> follows) {
		this.follows = follows;
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
