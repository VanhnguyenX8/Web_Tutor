
<%@ page import="Model.BinhLuan"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<link rel="stylesheet" href="css/comment.css">
<body>

	<%
	List<BinhLuan> listcmt = (List<BinhLuan>) request.getAttribute("datacmt");
	%>
	<div class="comments-section">

		<form id="comment-form" action="CommetSevlet" method="post">
			<label for="comment">Bình luận:</label>
			<textarea id="comment" name="comment" rows="1" required></textarea>
			<button type="submit">Gửi</button>
		</form>

		<div class="comment-list">
			<!-- Hiển thị danh sách bình luận -->
			<%
			for (BinhLuan cmt : listcmt) {
			%>
			<div class="comment">
				<span class="comment-content"><%=cmt.getUsernamebl()%> (<%=cmt.getCreatedAt() %>):
					<div id="suahienthitinnhan">
						<p style="color: black !important; margin-right: 10px;"><%=cmt.getChat()%></p>
						<% if (cmt.canDelete()) { %>
                    <form action="DeleteCommentServlet" method="post">
                        <input type="hidden" name="commentId" value="<%= cmt.getId() %>">
                        <button type="submit">Xóa</button>
                    </form>
                     <% } %>
					</div> </span>
			</div>
			<%
			}
			%>
		</div>
	</div>

</body>
</html>