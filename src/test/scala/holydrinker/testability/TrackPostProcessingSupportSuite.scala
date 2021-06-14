package holydrinker.testability

import holydrinker.testability.configuration.PostProcessingInfo
import holydrinker.testability.core.TrackPostprocessingSupport
import holydrinker.testability.models.Track
import org.scalatest.funsuite.AnyFunSuite

class TrackPostProcessingSupportSuite extends AnyFunSuite with TrackPostprocessingSupport {

  test("simple case") {

    val tracks = Seq(
      Track(1000, "best of you", "foo fighters"),
      Track(1001, "enjoy the silence", "depeche mode")
    )

    val postProcessingInfo = PostProcessingInfo(Seq("depeche mode"))

    val actual = filterTrackFromFakeArtistPage(tracks, postProcessingInfo)

    val expected = Seq(
      Track(1000, "best of you", "foo fighters")
    )

    assert(actual == expected)

  }

  test("simple empty case") {

    val tracks = Seq(
      Track(1000, "best of you", "foo fighters"),
      Track(1001, "enjoy the silence", "depeche mode")
    )

    val postProcessingInfo = PostProcessingInfo(Seq.empty[String])

    val actual = filterTrackFromFakeArtistPage(tracks, postProcessingInfo)

    assert(actual == tracks)

  }

}
