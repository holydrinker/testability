package holydrinker.testability.core

import holydrinker.testability.models.{ListenEvent, Track}

import java.sql.{Connection, ResultSet}

trait TrackRebuildSupport {

  def tracksFromEvents(
      events: Seq[ListenEvent]
  ): Seq[Track] = {

    events
      .map {
        case ListenEvent(trackId, _, _) =>
          TrackRepository.getTrack(trackId)
      }
  }
}

object TrackRepository extends PostgresConnection {

  def getTrack(trackId: Int): Track = {
    val statement = postgres.createStatement()
    val resultSet =
      statement.executeQuery(s"select * from tracks where trackId = $trackId;")
    resultSet.next()
    val title = resultSet.getString("title")
    val artist = resultSet.getString("artist")
    Track(trackId, title, artist)
  }
}
