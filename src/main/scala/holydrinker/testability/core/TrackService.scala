package holydrinker.testability.core

import holydrinker.testability.models.{ListenEvent, Track}
import holydrinker.testability.repository.TrackRepository

object TrackService
    extends TrackSelectionSupport
    with TrackRebuildSupport {

  def rebuildLongTrack(
      events: Seq[ListenEvent],
      minSeconds: Int,
      trackRepository: TrackRepository
  ): Seq[Track] = {

    val longEvents = selectLongEvents(events, minSeconds)

    tracksFromEvents(longEvents, trackRepository)

  }

}