package com.poc.RestWithJersey.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public class CommentService {

	@GET
	public String getComment(@PathParam("messageId") String messageId) {
		return "getComment() EX: /Messages/111/comment: messageId" + messageId;
	}

	@GET
	@Path("/{commentId}")
	public String getCommentByid(
			@PathParam("messageId") String messageId,
			@PathParam("commentId") String commentId) {
		return "getCommentByid() EX: /Messages/111/comment/22 messageId :" + messageId + " commentId "+ commentId;
	}
	
	@Path("/{commentId}/reply")
	public Class<ReplyService> getCommentByidAndMsgIdAndReply(
			@PathParam("messageId") String messageId,
			@PathParam("commentId") String commentId) {
		return ReplyService.class;
	}
}
