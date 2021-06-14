package holydrinker.testability.core

import holydrinker.testability.configuration.PostProcessingInfo
import holydrinker.testability.models.Track

trait TrackPostprocessingSupport {

  def filterTrackFromFakeArtistPage(tracks: Seq[Track], info: PostProcessingInfo): Seq[Track] = {
    val ignoreList = info.ignoreList
    tracks.filter(track => !ignoreList.contains(track.artist))
  }

}
