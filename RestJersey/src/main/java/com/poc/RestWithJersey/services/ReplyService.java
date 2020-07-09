package com.poc.RestWithJersey.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public class ReplyService {

	@GET
	public String getReply(
			@PathParam("messageId") String messageId,
			@PathParam("commentId") String commentId) {
		return "getReply() EX: /Messages/111/comment/22/reply :messageId :" + messageId + " commentId "+ commentId;
	}

	@GET
	@Path("/{replyId}")
	//http://localhost:8080/RestWithJersey/webresources/Messages/111/comment/22/reply/22
	public String getReplyById(
			@PathParam("messageId") String messageId,
			@PathParam("commentId") String commentId,
			@PathParam("replyId") String replyId) {
		return "getReplyById() EX: /Messages/111/comment/22/reply/22 messageId :" + messageId + " commentId " + commentId + " replyId " + replyId;
	}
}
