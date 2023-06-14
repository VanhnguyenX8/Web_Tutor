<%@ page import="Model.BinhLuan"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<body>

<%
List<BinhLuan> listcmt = (List<BinhLuan>) request.getAttribute("datacmt");
%>
<style>
    .comments-section {
        width: 66.67%;
        margin: 0 auto;
        color: #2a70b8;
    }
    
    .comment-list {
        margin-top: 20px;
    }
    
    .comment {
        border: 1px solid #2a70b8;
        padding: 10px;
        margin-bottom: 10px;
        box-sizing: border-box;
        background-color: #f5f5f5;
        border-radius: 10px;
    }
    
    .comment-content {
        color: #2a70b8;
    }
    
    #comment-form {
        margin-top: 20px;
        background-color: #f5f5f5;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    
    #comment-form label {
        display: block;
        margin-bottom: 10px;
        color: #2a70b8;
    }
    
    #comment {
        width: 100%;
        height: 20px;
        border: 1px solid #2a70b8;
        padding: 5px;
        resize: vertical;
    }
    
    button[type="submit"] {
        margin-top: 10px;
        background-color: #2a70b8;
        color: #fff;
        border: none;
        padding: 8px 20px;
        border-radius: 5px;
        cursor: pointer;
    }
    
    button[type="submit"]:hover {
        background-color: #1e5481;
    }
</style>

<div class="comments-section">
  
    <form id="comment-form" action="CommetSevlet" method="post">
        <label for="comment">Bình luận:</label>
        <textarea id="comment" name="comment" rows="1" required></textarea>
        <button type="submit">Gửi</button>
    </form>
    
    <div class="comment-list">
        <!-- Hiển thị danh sách bình luận -->
        <% for (BinhLuan cmt : listcmt) { %>
            <div class="comment">
                <span class="comment-content"><%=cmt.getUsernamebl()%>: <p style="color: black !important"><%=cmt.getChat()%><p></span>
            </div>
        <% } %>
    </div>
</div>

</body>
</html>