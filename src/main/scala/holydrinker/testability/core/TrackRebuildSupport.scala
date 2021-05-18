package holydrinker.testability.core

import holydrinker.testability.models.{ListenEvent, Track}
import holydrinker.testability.repository.TrackRepository


trait TrackRebuildSupport {

  def tracksFromEvents(
      events: Seq[ListenEvent],
      trackRepository: TrackRepository
  ): Seq[Track] = {

    events
      .map {
        case ListenEvent(trackId, _, _) =>
          trackRepository.getTrack(trackId)
      }

  }

}
