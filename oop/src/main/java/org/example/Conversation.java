package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Conversation {
    protected ArrayList<User> participants = new ArrayList<>();
    protected ArrayList<Message> messages = new ArrayList<>();
    protected int id;

    public List getMessages() {
        return messages;
    }

    public boolean addMessage(Message m) {
        messages.add(m);
        return true;
    }

    public int getId() {
        return id;
    }
}



