package ru.stqa.pft.mantis.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Users extends ForwardingSet<UserData> {

    private Set<UserData> delegate;
    public Users(Users users) {
        this.delegate = new HashSet<UserData>(users.delegate);
    }
    public Users(Collection<UserData> users) {
        this.delegate = new HashSet<UserData>(users);
    }

    @Override
    protected Set<UserData> delegate() {
        return delegate;
    }

    public Users without(String username) {
        Users users = new Users(this);
        UserData deletedUser = null;
        Iterator<UserData> itr= users.iterator();
        while (itr.hasNext()){
           UserData user = itr.next();
           if (user.getUsername().equals(username)){
               deletedUser = user;
               break;
           }
        }
        users.remove(deletedUser);
        return users;
    }
}
