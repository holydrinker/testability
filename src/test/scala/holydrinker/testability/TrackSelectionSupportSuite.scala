package holydrinker.testability

import holydrinker.testability.core.{TrackSelectionSupport, TrackService}
import holydrinker.testability.models.{ListenEvent, Track}
import org.scalatest.funsuite.AnyFunSuite

class TrackSelectionSupportSuite
    extends AnyFunSuite
    with TrackSelectionSupport {

  test("track selection support base case") {

    val longEvent = ListenEvent(1000, 0, 100)
    val shortEvent = ListenEvent(1001, 0, 2)

    val events = Seq(
      longEvent,
      shortEvent
    )

    val actual = selectLongEvents(events, minSeconds = 10)

    val expected = Seq(
      longEvent
    )

    assert(actual == expected)

  }

}
