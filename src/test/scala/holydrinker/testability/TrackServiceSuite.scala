package holydrinker.testability

import holydrinker.testability.core.TrackService
import holydrinker.testability.models.{ListenEvent, Track}
import org.scalatest.funsuite.AnyFunSuite

class TrackServiceSuite extends AnyFunSuite {

  test("track service works fine for long song") {

    val events = Seq(
      ListenEvent(1000, 0, 100)
    )

    val actual = TrackService.rebuildLongTrack(events, minSeconds = 10)

    val expected = Seq(
      Track(1000, "best of you", "foo fighters")
    )

    assert(actual == expected)
  }

  test("track service works fine for short song") {

    val events = Seq(
      ListenEvent(1000, 0, 5)
    )

    val actual = TrackService.rebuildLongTrack(events, minSeconds = 10)

    val expected = Seq.empty[Track]

    assert(actual == expected)
  }

}
