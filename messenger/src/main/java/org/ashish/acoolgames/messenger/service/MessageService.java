package org.ashish.acoolgames.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.Sides;

import org.ashish.acoolgames.messenger.model.Message;

import database.DatabaseMock;

/**
 * class to handle all message related requests
 * 
 * @author Ashish Pahlazani
 */
public class MessageService {
	
	Map<Long, Message> messageMap = DatabaseMock.getMessages();

	public List<Message> getAllMessages() {
		return new ArrayList<>(messageMap.values());
	}
	
	public List<Message> getMessagesForYear(int year) {
		List<Message> messagesForYear = new ArrayList<Message>(); 
		Calendar cal = Calendar.getInstance();
		for( Message message : messageMap.values())
		{
			cal.setTime(message.getCreated());
			
			/*System.out.println("message Date : " + message.getCreated() +
			" Cal.getYear: " + cal.get(Calendar.YEAR) + year);*/
			if( cal.get(Calendar.YEAR) == year)
			{
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}

	public Message getMessage(Long messageId) {
		return messageMap.get(messageId);
	}

	public Message addMessage(Message message) {
		message.setId((long)messageMap.size()+1);
		messageMap.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() == null)
		{
			return null;
		}
		
		return messageMap.put(message.getId(), message);
	}

	public Message removeMessage(Long messageId) {
		return messageMap.remove(messageId);
	}
}
