package simulation.twitter_feed.model;

import org.apache.commons.lang3.builder.CompareToBuilder;

public class Tweet implements Comparable<Tweet> {

	private String usersName;
	
	private String tweet;

	public Tweet(String usersName, String tweet) {
		super();
		this.usersName = usersName;
		this.tweet = tweet;
	}

	public String getUsersName() {
		return usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tweet == null) ? 0 : tweet.hashCode());
		result = prime * result + ((usersName == null) ? 0 : usersName.hashCode());
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
		Tweet other = (Tweet) obj;
		if (tweet == null) {
			if (other.tweet != null)
				return false;
		} else if (!tweet.equals(other.tweet))
			return false;
		if (usersName == null) {
			if (other.usersName != null)
				return false;
		} else if (!usersName.equals(other.usersName))
			return false;
		return true;
	}

	public int compareTo(Tweet o) {
		CompareToBuilder compareToBuilder = new CompareToBuilder();
		compareToBuilder.append(usersName, o.usersName);          
        compareToBuilder.append(tweet, o.tweet);
        return compareToBuilder.toComparison();
	}
}
