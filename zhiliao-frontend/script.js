const sendButton = document.getElementById('sendButton');
const messageInput = document.getElementById('messageInput');
const messageList = document.getElementById('message-list');

sendButton.addEventListener('click', function() {
    const messageText = messageInput.value;
    if (messageText.trim()!== '') {
        const itemDiv = document.createElement('div');
        itemDiv.className ='message-item';
        const authorSpan = document.createElement('span');
        authorSpan.className ='message-author';
        authorSpan.textContent = "你: ";
        const contentSpan = document.createElement('span');
        contentSpan.className ='message-content';
        contentSpan.textContent = messageText;
        itemDiv.appendChild(authorSpan);
        itemDiv.appendChild(contentSpan);
        messageList.appendChild(itemDiv);
        messageInput.value = '';
    }
});