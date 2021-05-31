package holydrinker.testability.core

import com.typesafe.config.Config
import holydrinker.testability.models.Track
import scala.collection.JavaConverters._

trait TrackPostprocessingSupport {

  def filterTrackFromFakeArtistPage(tracks: Seq[Track], config: Config): Seq[Track] = {
    val ignoreList = config.getStringList("ignoreList").asScala.toList
    tracks.filter(track => !ignoreList.contains(track.artist))
  }

}
