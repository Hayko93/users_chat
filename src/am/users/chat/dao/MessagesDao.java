package am.users.chat.dao;

import am.users.chat.model.Message;

import java.sql.SQLException;
import java.util.List;

public interface MessagesDao {

  Message insert(Message message) throws SQLException;

  List<Message> fetchAll(int senderId, int receiverId) throws SQLException;

}
