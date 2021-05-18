package holydrinker.testability.core

import holydrinker.testability.models.{ListenEvent, Track}

object TrackService
    extends TrackSelectionSupport
    with TrackRebuildSupport {

  def rebuildLongTrack(
      events: Seq[ListenEvent],
      minSeconds: Int
  ): Seq[Track] = {

    val longEvents = selectLongEvents(events, minSeconds)

    tracksFromEvents(longEvents)

  }

}