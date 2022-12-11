package org.example;

import java.util.Date;

public class Message {
    private Content content;
    private Date date;
    private ContentType messageType;

    public Message(Content content, Date date) {
        this.content = content;
        this.date = date;
    }

    public Content getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }

    public void setMessageType(ContentType messageType) {
        this.messageType = messageType;
    }

    public ContentType getMessageType() {
        return messageType;
    }
}
