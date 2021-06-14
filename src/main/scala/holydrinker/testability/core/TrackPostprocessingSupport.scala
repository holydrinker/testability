package holydrinker.testability.core

import holydrinker.testability.models.Track

trait TrackPostprocessingSupport {

  def filterTrackFromFakeArtistPage(tracks: Seq[Track], ignoreList: Seq[String]): Seq[Track] = {
    tracks.filter(track => !ignoreList.contains(track.artist))
  }

}
