package org.example;

import java.util.Date;
import java.util.HashMap;

/* UserManager — центральный класс для основных действий пользователя. */
public class UserManager {
    private static UserManager instance;
    /* Связывает идентификатор с пользователем */
    private HashMap<Integer, User> usersById = new HashMap<>();
    /* Связывает имя учётной записи с пользователем */
    private HashMap<String, User> usersByAccountName = new HashMap<>();
    /* Связывает идентификатор пользователя с подключённым пользователем */
    private HashMap<Integer, User> onlineUsers = new HashMap<>();

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    //добавление пользователя в список контактов
    public void addUser(User fromUser, String toAccountName) {
        User toUser = usersByAccountName.get(toAccountName);
        AddRequest req = new AddRequest(fromUser, toUser, new Date());
        toUser.receivedAddRequest(req);
        fromUser.sentAddRequest(req);
    }

    //принять запрос на добавление в список контактов
    public void approveAddRequest(AddRequest req) {
        req.status = RequestStatus.Accepted;
        User from = req.getFromUser();
        User to = req.getToUser();
        from.addContact(to);
        to.addContact(from);
    }

    //отклонить запрос на добавление в список контактов
    public void rejectAddRequest(AddRequest req) {
        req.status = RequestStatus.Rejected;
        User from = req.getFromUser();
        User to = req.getToUser();
        from.removeAddRequest(req);
        to.removeAddRequest(req);
    }

    public void userSignedOn(String accountName) {
        User user = usersByAccountName.get(accountName);
        if (user != null) {
            user.setStatus(new UserStatus(UserStatusType.Available, ""));
            onlineUsers.put(user.getId(), user);
        }
    }

    public void userSignedOff(String accountName) {
        User user = usersByAccountName.get(accountName);
        if (user != null) {
            user.setStatus(new UserStatus(UserStatusType.Offline, ""));
            onlineUsers.remove(user.getId());
        }
    }
}
