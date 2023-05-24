document.getElementById("sendButton").addEventListener("click", function() {
    var message = document.getElementById("messageInput").value;
    var messageElement = document.createElement("div");
    messageElement.className = "message";
    messageElement.innerHTML = '<span class="username">User:</span> <span class="content">' + message + '</span>';
    document.getElementById("chatMessages").appendChild(messageElement);
    document.getElementById("messageInput").value = "";
  });
  