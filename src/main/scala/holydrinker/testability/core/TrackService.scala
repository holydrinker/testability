package holydrinker.testability.core

import holydrinker.testability.models.{ListenEvent, Track}

import java.sql.ResultSet

object TrackService extends PostgresConnection {

  def rebuildLongTrack(events: Seq[ListenEvent], minSeconds: Int): Seq[Track] = {

    events
      .map(event => (event, event.endAt - event.startAt))
      .filter(eventWithDuration => eventWithDuration._2 >= minSeconds)
      .map { trackWithDuration =>
        val longTrackId = trackWithDuration._1.trackId
        val resultSet: ResultSet = selectTrack(longTrackId)
        val title = resultSet.getString("title")
        val artist = resultSet.getString("artist")
        Track(longTrackId, title, artist)
      }
  }

  private def selectTrack(trackId: Int): ResultSet = {
    val statement = postgres.createStatement()
    val resultSet = statement.executeQuery(s"select * from tracks where trackId = $trackId;")
    resultSet.next()
    resultSet
  }

}
