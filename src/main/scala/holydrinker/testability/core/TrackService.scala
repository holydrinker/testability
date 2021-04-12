package holydrinker.testability.core

import holydrinker.testability.models.{ListenEvent, Track}

import java.sql.{Connection, DriverManager, ResultSet}
import java.util.Properties

object TrackService {

  private val postgres = getConnection()

  def rebuildLongTrack(events: Seq[ListenEvent], minSeconds: Int): Seq[Track] = {

    events
      .map(event => (event, event.endAt - event.startAt))
      .filter(eventWithDuration => eventWithDuration._2 >= minSeconds)
      .map { trackWithDuration =>
        val longTrackId = trackWithDuration._1.trackId
        val resultSet: ResultSet = selectAllTrakcs()
        resultSet.next()
        val title = resultSet.getString("title")
        val artist = resultSet.getString("artist")
        Track(longTrackId, title, artist)
      }
  }

  private def getConnection(databaseName: Option[String] = None): Connection = {
    classOf[org.postgresql.Driver]
    val database = databaseName.getOrElse("")
    val url = s"jdbc:postgresql://localhost:5432/$database"
    val props = new Properties()
    props.setProperty("user", "peppo")
    props.setProperty("password", "password")
    DriverManager.getConnection(url, props)
  }

  private def selectAllTrakcs(): ResultSet = {
    val statement = postgres.createStatement()
    statement.executeQuery("select * from tracks;")
  }

}
