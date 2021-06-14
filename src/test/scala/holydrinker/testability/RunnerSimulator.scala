package holydrinker.testability

import com.typesafe.config.ConfigFactory
import holydrinker.testability.configuration.PostProcessingSupportConfigurationLoader
import holydrinker.testability.core.TrackService
import holydrinker.testability.models.{ListenEvent, Track}
import holydrinker.testability.repository.TrackRepository
import org.scalatest.funsuite.AnyFunSuite

trait RunnerSimulator extends AnyFunSuite with PostProcessingSupportConfigurationLoader {

  test("main") {

    val events = Seq(
      ListenEvent(1000, 0, 100)
    )

    val trackName = "best of you"

    val artistName = "foo fighters"

    val trackRepository = new TrackRepository {
      override def getTrack(trackId: Int): Track = Track(trackId, trackName, artistName)
    }

    val config = ConfigFactory.parseString(
      """
        |ignoreList = [
        |    "foo fighters"
        |]
        |""".stripMargin)

    val postProcessingInfo = fromTypesafeConfig(config)

    val actual = TrackService.rebuildLongTrack(events, minSeconds = 10, trackRepository, postProcessingInfo)

    val expected = Seq.empty[Track]

    assert(actual == expected)
  }

}
