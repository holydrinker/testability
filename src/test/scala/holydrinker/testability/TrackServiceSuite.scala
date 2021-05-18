package holydrinker.testability

import holydrinker.testability.core.TrackService
import holydrinker.testability.models.{ListenEvent, Track}
import holydrinker.testability.repository.TrackRepository
import org.scalatest.funsuite.AnyFunSuite

class TrackServiceSuite extends AnyFunSuite {

  test("track service works fine") {

    val events = Seq(
      ListenEvent(1000, 0, 100)
    )

    val trackName = "best of you"
    val artistName = "foo fighters"
    val trackRepository = new TrackRepository {
      override def getTrack(trackId: Int): Track = Track(trackId, trackName, artistName)
    }

    val actual = TrackService.rebuildLongTrack(events, minSeconds = 10, trackRepository)

    val expected = Seq(
      Track(1000, "best of you", "foo fighters")
    )

    assert(actual == expected)
  }

}
