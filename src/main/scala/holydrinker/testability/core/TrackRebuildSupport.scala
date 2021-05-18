package holydrinker.testability.core

import holydrinker.testability.models.{ListenEvent, Track}

import java.sql.{Connection, ResultSet}

trait TrackRebuildSupport {

  def tracksFromEvents(
      events: Seq[ListenEvent],
      postgres: Connection
  ): Seq[Track] = {

    events
      .map {
        case ListenEvent(trackId, _, _) =>
          val completeTrack = selectTrack(trackId, postgres)
          val title = completeTrack.getString("title")
          val artist = completeTrack.getString("artist")
          Track(trackId, title, artist)
      }

  }

  private def selectTrack(trackId: Int, postgres: Connection): ResultSet = {
    val statement = postgres.createStatement()
    val resultSet =
      statement.executeQuery(s"select * from tracks where trackId = $trackId;")
    resultSet.next()
    resultSet
  }

}
