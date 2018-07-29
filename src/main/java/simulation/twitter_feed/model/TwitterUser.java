package simulation.twitter_feed.model;

import java.io.Serializable;
import java.util.List;

public class TwitterUser implements Serializable, Comparable<TwitterUser> {

	private static final long serialVersionUID = 1L;

	private String name;
	
	private List<String> tweets;

	public TwitterUser(String name, List<String> tweets) {
		this.name = name;
		this.tweets = tweets;
	}

	public TwitterUser() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getTweets() {
		return tweets;
	}

	public void setTweets(List<String> tweets) {
		this.tweets = tweets;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tweets == null) ? 0 : tweets.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		TwitterUser other = (TwitterUser) obj;
		if (tweets == null) {
			if (other.tweets != null)
				return false;
		} else if (!tweets.equals(other.tweets))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public int compareTo(TwitterUser o) {
		if (this == o)
			return 0;
		return this.getName().compareTo(o.getName());
	}

}
