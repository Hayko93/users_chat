package am.users.chat.service;

import am.users.chat.exceptions.DatabaseException;
import am.users.chat.exceptions.FileUploadException;
import am.users.chat.model.User;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UsersService {

  User add(User user, InputStream imageContent) throws DatabaseException, FileUploadException;

  Optional<User> get(int id) throws DatabaseException;

  Optional<User> get(String email, String password) throws DatabaseException;

  boolean userExist(String email) throws DatabaseException;

  List<User> getAll() throws DatabaseException;
}
