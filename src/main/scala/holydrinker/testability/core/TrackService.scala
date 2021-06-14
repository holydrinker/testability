package holydrinker.testability.core

import holydrinker.testability.models.{ListenEvent, Track}
import holydrinker.testability.repository.TrackRepository

trait TrackService
    extends TrackSelectionSupport
    with TrackRebuildSupport
    with TrackPostprocessingSupport {

  def rebuildLongTrack(
      events: Seq[ListenEvent],
      minSeconds: Int,
      trackRepository: TrackRepository,
      ignoreList: Seq[String]
  ): Seq[Track] = {

    val longEvents = selectLongEvents(events, minSeconds)

    val allTracks = tracksFromEvents(longEvents, trackRepository)

    filterTrackFromFakeArtistPage(allTracks, ignoreList)

  }

}

object TrackService extends TrackService