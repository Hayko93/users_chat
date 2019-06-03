package am.users.chat.servlets.users;

import am.users.chat.model.Message;
import am.users.chat.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/home", ""})
public class HomeServlet extends BaseUserServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    try {
      User user = (User) req.getSession().getAttribute("user");
      List<User> users = this.usersService.getAll();
      List<Message> messages = this.messagesService.getAllMessages(user.getId(), user.getId());
      req.setAttribute("users", users);
      req.setAttribute("messages", messages);
      req.getRequestDispatcher("WEB-INF/pages/home.jsp").forward(req, resp);
    } catch (Exception e) {
      e.printStackTrace();
      resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
  }


  private String getClientToken(HttpServletRequest request) {
    for (Cookie cookie : request.getCookies()) {
      if ("CLIENT_TOKEN".equals(cookie.getName())) {
        return cookie.getValue();
      }
    }
    return null;
  }
}
