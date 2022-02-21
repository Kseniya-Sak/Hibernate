package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class Util {
    private static final String NAME = "user";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String HOST = "jdbc:mysql://localhost:3306/" + NAME + "?serverTimezone=Europe/Moscow";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "12345";
    private static SessionFactory sessions = null;

    public static SessionFactory getSessions() {
        try {

            Properties properties = new Properties();
            properties.put(Environment.DRIVER, DRIVER);
            properties.put(Environment.URL, HOST);
            properties.put(Environment.USER, LOGIN);
            properties.put(Environment.PASS, PASSWORD);
            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
            properties.put(Environment.SHOW_SQL, true);
            properties.put(Environment.FORMAT_SQL, true);
            properties.put(Environment.HBM2DDL_AUTO, "update");

            sessions = new Configuration()
                    .addProperties(properties)
                    .addPackage("jm.task.core.jdbc.model")
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sessions;
    }

    public static void closeSessions() {
        if (getSessions() != null) {
            getSessions().close();
        }
    }
}
