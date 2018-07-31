package simulation.twitter_feed.model.factory;

import java.io.FileNotFoundException;
import java.io.InputStream;

public abstract class Factory {

	protected static InputStream getFilePath(String fileName) throws FileNotFoundException {
		InputStream path = TwitterAccountFactory.class.getClassLoader().getResourceAsStream(fileName);
		if (path == null) {
			String errorMsg = "Could not find file: " + fileName;
			throw new FileNotFoundException(errorMsg);
		}
		return path;
	}
}
