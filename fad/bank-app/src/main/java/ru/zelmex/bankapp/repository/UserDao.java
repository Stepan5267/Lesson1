package ru.zelmex.bankapp.repository;
import ru.zelmex.bankapp.model.User;
public class UserDao extends BaseDao<User> {
    public UserDao() {
        super(User.class);
    }
}