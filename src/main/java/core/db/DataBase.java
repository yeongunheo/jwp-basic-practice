package core.db;

import java.util.Collection;
import java.util.Map;

import com.google.common.collect.Maps;

import next.model.User;

public class DataBase {
    private static Map<String, User> users = Maps.newHashMap();

    public static void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public static User findUserById(String userId) {
        return users.get(userId);
    }

    public static Collection<User> findAll() {
        return users.values();
    }
    
    public static void updateUser(User user) {
    	User updateUser = new User(
    			user.getUserId(),
    			user.getPassword(),
    			user.getName(),
    			user.getEmail());
    	users.remove(user.getUserId());
    	users.put(updateUser.getUserId(), updateUser);
    }
}
