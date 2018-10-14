package database;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.ashish.acoolgames.messenger.model.Author;
import org.ashish.acoolgames.messenger.model.Message;

public class DatabaseMock {
	AtomicInteger messageIDSequence = new AtomicInteger(0);
	private static Map<Long, Message> messageMap = new ConcurrentHashMap<>();
	private static Map<Long, Author> authorMap = new ConcurrentHashMap<>();
	
	static {
		Author ashish = new Author("Ashish", "ATDM", "Software Engineer");
		Author mahek = new Author("Mahek", "Delivey Lead", "Zeolearn Delivery Lead");
		messageMap.put(1L, new Message(1L, "How are you?", ashish));
		messageMap.put(2L, new Message(2L, "Great!", mahek));
		messageMap.put(3L, new Message(3L, "Howz U?", mahek));
		System.out.println("Database Mock initialized");
	}
	
	public static Map<Long, Message> getMessages()
	{
		return messageMap;
	}
	
	public static Map<Long, Author> getAuthors()
	{
		return authorMap;
	}
}
