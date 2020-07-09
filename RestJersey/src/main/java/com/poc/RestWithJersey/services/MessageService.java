package com.poc.RestWithJersey.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/Messages")
public class MessageService {

	@GET
//	@Produces(MediaType.APPLICATION_JSON)
	public String getMessage() {
		return "getMessage() EX: /Messages/ :";
	}
	
	@GET
	@Path("/{messageId}")
//	@Produces(MediaType.APPLICATION_JSON)
	public String getMessageById(@PathParam("messageId") String messageId) {
		return "getMessageById() EX: Messages/111 :" + messageId;
	}
	
//	@GET
	@Path("/{messageId}/comment")
//	@Produces(MediaType.APPLICATION_JSON)
	public CommentService getComment(@PathParam("messageId") String messageId) {
		return new CommentService();
	}
}
