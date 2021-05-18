package holydrinker.testability

import holydrinker.testability.core.{PostgresConnection, TrackRebuildSupport}
import holydrinker.testability.models.{ListenEvent, Track}
import org.scalatest.funsuite.AnyFunSuite

class TrackRebuildSupportSuite
    extends AnyFunSuite
    with TrackRebuildSupport {

  test("track rebuild support base case") {

    val events = Seq(
      ListenEvent(1000, 0, 100)
    )

    val actual = tracksFromEvents(events)

    val expected = Seq(
      Track(1000, "best of you", "foo fighters")
    )

    assert(actual == expected)
  }

}
