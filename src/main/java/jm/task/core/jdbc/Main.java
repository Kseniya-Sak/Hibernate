package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    private static final UserService userService = new UserServiceImpl();
    private static final User USER1 = new User("Vova", "Taky", (byte) 74);
    private static final User USER2 = new User("Lida", "Ryry", (byte) 29);
    private static final User USER3 = new User("Sveta", "Yern", (byte) 27);
    private static final User USER4 = new User("Lika", "Yunona", (byte) 45);

    public static void main(String[] args) {
        userService.createUsersTable();

        userService.saveUser(USER1.getName(), USER1.getLastName(), USER1.getAge());
        System.out.println("User с именем – " + USER1.getName() + " добавлен в базу данных");

        userService.saveUser(USER2.getName(), USER2.getLastName(), USER2.getAge());
        System.out.println("User с именем – " + USER2.getName() + " добавлен в базу данных");

        userService.saveUser(USER3.getName(), USER3.getLastName(), USER3.getAge());
        System.out.println("User с именем – " + USER3.getName() + " добавлен в базу данных");

        userService.saveUser(USER4.getName(), USER4.getLastName(), USER4.getAge());
        System.out.println("User с именем – " + USER4.getName() + " добавлен в базу данных");

        System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();

        userService.dropUsersTable();

        Util.closeSessions();
    }
}
