package am.users.chat.dao.sql;

import am.users.chat.util.DatabaseConnectionFactory;

abstract class BaseSql {

  protected DatabaseConnectionFactory dbConnectionFactory;

  BaseSql() {
    this.dbConnectionFactory = DatabaseConnectionFactory.getInstance();
  }
}
