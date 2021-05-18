package holydrinker.testability.core

import java.sql.{Connection, DriverManager}
import java.util.Properties

trait PostgresConnection {

  val postgres = getConnection()

  private def getConnection(databaseName: Option[String] = None): Connection = {
    classOf[org.postgresql.Driver]
    val database = databaseName.getOrElse("")
    val url = s"jdbc:postgresql://localhost:5432/$database"
    val props = new Properties()
    props.setProperty("user", "peppo")
    props.setProperty("password", "password")
    DriverManager.getConnection(url, props)
  }
}
