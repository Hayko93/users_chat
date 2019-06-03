package am.users.chat.dao;

import am.users.chat.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UsersDao {

  User insert(Connection connection, User user) throws SQLException;

  Optional<User> fetch(int id) throws SQLException;

  Optional<User> fetch(String email, String password) throws SQLException;

  boolean userExist(String email) throws SQLException;

  List<User> fetchAll() throws SQLException;


}
