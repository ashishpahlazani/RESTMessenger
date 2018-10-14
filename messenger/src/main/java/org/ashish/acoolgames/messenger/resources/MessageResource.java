package org.ashish.acoolgames.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.ashish.acoolgames.messenger.exception.DataNotFoundException;
import org.ashish.acoolgames.messenger.model.Message;
import org.ashish.acoolgames.messenger.resources.beans.MessageFilterBean;
import org.ashish.acoolgames.messenger.service.MessageService;

/**
 * Root resource (exposed at "messages" path)
 */
@Path("messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	MessageService messageService = new MessageService();
	
    /*@GET
    public List<Message> getMessages() {
        return messageService.getAllMessages();
    }*/
    
    @GET
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
		if (filterBean.getYear() > 0) {
			System.out.println("Year : " + filterBean.getYear());
			return messageService.getMessagesForYear(filterBean.getYear());
		}
		if(filterBean.getStart()>0 && filterBean.getSize()>0)
		{
			System.out.println("Start: " + filterBean.getStart() + " Size: " + filterBean.getSize());
			return messageService.getAllMessages();
		}
		return messageService.getAllMessages();
	}
    
    @GET
    @Path("{messageId}")
    public Message getMessage(@PathParam("messageId") Long messageId) {
    	Message message = messageService.getMessage(messageId);
    	if(message == null)
    	{
    		throw new DataNotFoundException("Message ID : " + messageId + " Not Found");
    	}
        return message;
    }
    
    @DELETE
    @Path("{messageId}")
    public Message deleteMessage(@PathParam("messageId") Long messageId) {
    	System.out.println("removning message " + messageId + " " + messageService.getMessage(messageId));
        return messageService.removeMessage(messageId);
    }
    
    @POST
    public Response addMessage(Message message, @Context UriInfo uriInfo) {
    	Message newMessage = messageService.addMessage(message);
    	URI uri = uriInfo.getAbsolutePathBuilder().path(newMessage.getId().toString()).build();
    	return Response.created(uri).entity(newMessage).build();
        //return messageService.addMessage(message);
    }
    
    @PUT
    public Message updateMessage(Message message) {
        return messageService.updateMessage(message);
    }
    
    @PUT
    @Path("{messageId}")
    public Message updateMessage(@PathParam("messageId") Long messageId, Message message) {
    	message.setId(messageId);
        return messageService.updateMessage(message);
    }
    
    /*@GET
    @Path("{messageId}/comments")
    public CommentResource getCommentsResource()
    {
    	System.out.println("inside getCommentsResource");
    	return new CommentResource();
    }*/
}
