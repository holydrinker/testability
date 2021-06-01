package holydrinker.testability.core

import holydrinker.testability.configuration.PostProcessingInfo
import holydrinker.testability.models.Track

trait TrackPostprocessingSupport {

  def filterTrackFromFakeArtistPage(tracks: Seq[Track], postProcessingInfo: PostProcessingInfo): Seq[Track] = {
    tracks.filter { track =>
      postProcessingInfo.ignoreMap.get(track.artist)
        .map(_ < postProcessingInfo.falsenessThreshold)
        .getOrElse(true)
    }
  }

}
