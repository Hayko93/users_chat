package am.users.chat.servlets.messages;

import am.users.chat.service.MessagesService;
import am.users.chat.service.impl.MessagesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public abstract class BaseMessagesServlet extends HttpServlet {

  protected MessagesService messagesService;

  @Override
  public void init() throws ServletException {
    super.init();
    this.messagesService = new MessagesServiceImpl();
  }
}
