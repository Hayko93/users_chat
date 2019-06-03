package am.users.chat.service.impl;

import am.users.chat.dao.MessagesDao;
import am.users.chat.dao.sql.MessagesDaoSql;
import am.users.chat.exceptions.DatabaseException;
import am.users.chat.model.Message;
import am.users.chat.service.MessagesService;

import java.sql.SQLException;
import java.util.List;

public class MessagesServiceImpl implements MessagesService {

  private MessagesDao messagesDao;

  public MessagesServiceImpl() {
    this.messagesDao = new MessagesDaoSql();
  }

  @Override
  public Message add(Message message) throws DatabaseException {
    try {
      return this.messagesDao.insert(message);
    } catch (SQLException e) {
      throw new DatabaseException(e);
    }
  }

  @Override
  public List<Message> getAllMessages(int senderId, int receiverId) throws DatabaseException {
    try {
      return this.messagesDao.fetchAll(senderId, receiverId);
    } catch (SQLException e) {
      throw new DatabaseException(e);
    }
  }
}
