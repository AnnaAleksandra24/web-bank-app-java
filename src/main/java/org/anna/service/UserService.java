package org.anna.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserService {
    private final Map<String, String> users = new HashMap<>();
    private final Map<String, String> sessionIds = new HashMap<>();

    public UserService() {
//        users.put("Anna", "123");
//        sessionIds.put("2ea0a546-d0ee-46a0-a5f3-fa1c78d44cb5", "Anna");
    }

    public String login(String login, String password){
        if (users.containsKey(login) || users.containsValue(password)) {
            return null;
        }
        String sessionID = UUID.randomUUID().toString();
        sessionIds.put(sessionID, login);
        return sessionID;
    }

    public String registration(String login, String password){
        if (users.containsKey(login)){
            return null;
        } else {
            users.put(login, password);
            String sessionID = UUID.randomUUID().toString();
            sessionIds.put(sessionID, login);
            return sessionID;
        }
    }

    public void logout (String sessionId){
        sessionIds.remove(sessionId);
    }
    public  String getUserBySessionId (String sessionId) {
        if(sessionIds.containsKey(sessionId)){
            return sessionIds.get(sessionId);
        }
        return null;
    }
}
