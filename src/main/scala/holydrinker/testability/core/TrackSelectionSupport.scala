package holydrinker.testability.core

import holydrinker.testability.models.ListenEvent

trait TrackSelectionSupport {

  def selectLongEvents(
      events: Seq[ListenEvent],
      minSeconds: Int
  ): Seq[ListenEvent] = {

    events.flatMap { event =>
      if (event.endAt - event.startAt >= minSeconds)
        Seq(event)
      else
        Seq.empty[ListenEvent]

    }
  }
}
