package com.example.task04;

import java.util.ArrayList;
import java.util.Arrays;

public class MemoryHandler implements MessageHandler{
    private final int MaxSize;
    private final ArrayList<String> Messages = new ArrayList<>();
    private final ArrayList<MessageHandler> Handlers = new ArrayList<>();

    public MemoryHandler(int maxSize, MessageHandler... handlers) {
        MaxSize = maxSize;
        ArrayList<MessageHandler> newHandlers = new ArrayList<>(Arrays.asList(handlers));
        Handlers.addAll(newHandlers);
    }

    @Override
    public void HandleMessage(String message) {
        Messages.add(message);
        if (Messages.size() > MaxSize){
            sendMsgToHandler();
        }
    }

    public void sendMsgToHandler() {
        for (MessageHandler handler : Handlers) {
            for (String message : Messages){
                handler.HandleMessage(message);
            }
            Messages.clear();
        }
    }
}