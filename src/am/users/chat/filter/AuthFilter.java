package am.users.chat.filter;

import am.users.chat.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebFilter(filterName = "AuthFilter",
    urlPatterns = {"/home", "/usersList", "/messages", "/createMessage", "/"})
public class AuthFilter implements Filter {

  private Map<Integer, Date> usersActivityMap = new ConcurrentHashMap<>();

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    filterConfig.getServletContext().setAttribute("users_activity", usersActivityMap);
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletResponse response = (HttpServletResponse) servletResponse;
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    User user = (User) request.getSession().getAttribute("user");
    if (user == null) {
      response.sendRedirect("login");
      return;
    } else {
      usersActivityMap.put(user.getId(), new Date());
    }
    filterChain.doFilter(request, response);
  }


  @Override
  public void destroy() {

  }
}
