package cn.ght.demo.service;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ght
 * @Date: 2020/11/24
 */
public class UserDetailsRepository {

    private Map<String, UserDetails> users = new HashMap<>();

    public void createUser(UserDetails user) {
        users.putIfAbsent(user.getUsername(), user);
    }

    public void updateUser(UserDetails user) {
        users.put(user.getUsername(),user);
    }

    public void deleteUser(String username) {
        users.remove(username);
    }

    public void changePassword(String oldPassword,String newPassword) {
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        if (null==currentUser) {
            throw new AccessDeniedException("异常1");
        }
        String username = currentUser.getName();
        UserDetails user = users.get(username);
        if (null==user) {
            throw new IllegalStateException("current user doesn't exist");
        }
    }

    public boolean userExists(String username) {
        return users.containsKey(username);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.get(username);
    }
}
