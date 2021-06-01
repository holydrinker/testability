package holydrinker.testability.core

import holydrinker.testability.configuration.PostProcessingInfo
import holydrinker.testability.models.{ListenEvent, Track}
import holydrinker.testability.repository.TrackRepository

object TrackService
    extends TrackSelectionSupport
    with TrackRebuildSupport
    with TrackPostprocessingSupport {

  def rebuildLongTrack(
      events: Seq[ListenEvent],
      minSeconds: Int,
      trackRepository: TrackRepository,
      postProcessingInfo: PostProcessingInfo
  ): Seq[Track] = {

    val longEvents = selectLongEvents(events, minSeconds)

    val allTracks = tracksFromEvents(longEvents, trackRepository)

    filterTrackFromFakeArtistPage(allTracks, postProcessingInfo)

  }

}