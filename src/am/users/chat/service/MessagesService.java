package am.users.chat.service;

import am.users.chat.exceptions.DatabaseException;
import am.users.chat.model.Message;
import am.users.chat.model.User;

import java.util.List;
import java.util.Optional;

public interface MessagesService {

  Message add(Message message) throws DatabaseException;

  List<Message> getAllMessages(int senderId, int receiverId) throws DatabaseException;
}
