package holydrinker.testability

import holydrinker.testability.core.TrackService
import holydrinker.testability.models.{ListenEvent, Track}
import holydrinker.testability.repository.TrackRepository
import org.scalatest.funsuite.AnyFunSuite

class TrackServiceSuite extends AnyFunSuite {

  test("track service works fine with artists in ignore list") {

    val events = Seq(
      ListenEvent(1000, 0, 100)
    )

    val trackName = "best of you"

    val artistName = "foo fighters"

    val trackRepository = new TrackRepository {
      override def getTrack(trackId: Int): Track = Track(trackId, trackName, artistName)
    }

    val ignoreList = Seq("foo fighters")

    val actual = TrackService.rebuildLongTrack(events, minSeconds = 10, trackRepository, ignoreList)

    val expected = Seq.empty[Track]

    assert(actual == expected)
  }

  test("track service works fine with artists not in ignore list") {

    val events = Seq(
      ListenEvent(1000, 0, 100)
    )

    val trackName = "best of you"

    val artistName = "foo fighters"

    val trackRepository = new TrackRepository {
      override def getTrack(trackId: Int): Track = Track(trackId, trackName, artistName)
    }

    val ignoreList = Seq.empty[String]

    val actual = TrackService.rebuildLongTrack(events, minSeconds = 10, trackRepository, ignoreList)

    val expected = Seq(
      Track(1000, trackName, artistName)
    )

    assert(actual == expected)
  }

}
