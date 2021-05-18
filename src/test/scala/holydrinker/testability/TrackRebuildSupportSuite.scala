package holydrinker.testability

import holydrinker.testability.core.TrackRebuildSupport
import holydrinker.testability.models.{ListenEvent, Track}
import holydrinker.testability.repository.TrackRepository
import org.scalatest.funsuite.AnyFunSuite

class TrackRebuildSupportSuite
    extends AnyFunSuite
    with TrackRebuildSupport {

  test("track rebuild support base case") {

    val events = Seq(
      ListenEvent(1000, 0, 100)
    )

    val trackName = "best of you"
    val artistName = "foo fighters"

    val trackRepository = new TrackRepository {
      override def getTrack(trackId: Int): Track = Track(trackId, trackName, artistName)
    }

    val actual = tracksFromEvents(events, trackRepository)

    val expected = Seq(
      Track(1000, trackName, artistName)
    )

    assert(actual == expected)
  }

}
