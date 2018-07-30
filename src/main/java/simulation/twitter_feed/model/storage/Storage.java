package simulation.twitter_feed.model.storage;

import java.util.Set;

public interface Storage<T> {

	public void add(T t);
	
	public void remove(T t);
	
	public Set<T> getStorage();
	
	public void addAll(Set<T> t);
	
	public void clear();
}
