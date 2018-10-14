package org.ashish.acoolgames.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.ashish.acoolgames.messenger.model.Message;
import org.ashish.acoolgames.messenger.service.MessageService;

@Path("/")
/*@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)*/
public class CommentResource {
	MessageService messageService = new MessageService();
	
	/*int id = 1;
	
	public int getId() {
		System.out.println("inside comments.getId()");
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}*/
	
	static
	{
		System.out.println("CommentResource Initialzed");
	}

	@GET
	public Message getComments()
	{
		System.out.println("inside getComments()");
		return messageService.getAllMessages().get(0);
	}

	@GET
	@Path("/{commentId}")
	public String getComment(@PathParam("messageId") int messageId,
			@PathParam("commentId") int commentId)
	{
		return "messageId: " + messageId + " commentId: " + commentId;
	}
}
