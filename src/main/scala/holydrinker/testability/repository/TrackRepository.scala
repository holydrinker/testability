package holydrinker.testability.repository

import holydrinker.testability.core.PostgresConnection
import holydrinker.testability.models.Track

trait TrackRepository {

  def getTrack(trackId: Int): Track

}

trait PostgresTrackRepository extends TrackRepository with PostgresConnection {

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
