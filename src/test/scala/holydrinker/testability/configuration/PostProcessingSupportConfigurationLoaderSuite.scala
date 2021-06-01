package holydrinker.testability.configuration

import com.typesafe.config.ConfigFactory
import org.scalatest.funsuite.AnyFunSuite

class PostProcessingSupportConfigurationLoaderSuite extends AnyFunSuite with PostProcessingSupportConfigurationLoader {

  test("simple configuration loading") {

    val configStr =
      """
        |ignoreList = [
        |    {
        |        artist = "opeth"
        |        falseness = 0.8
        |    }
        |    {
        |        artist = "slipknot"
        |        falseness = 0.2
        |    }
        |    {
        |        artist = "inude"
        |        falseness = 0.35
        |    }
        |    {
        |        artist = "vulfpeck"
        |        falseness = 0.65
        |    }
        |    {
        |        artist = "cure"
        |        falseness = 0.2
        |    }
        |    {
        |        artist = "eelst"
        |        falseness = 0.5
        |    }
        |]
        |
        |falsenessThreshold = 0.4
        |""".stripMargin

    val config = ConfigFactory.parseString(configStr)

    val actual = fromTypesafeConfig(config)

    val expectedIgnoreMap = Map(
      "opeth" -> 0.8,
      "slipknot" -> 0.2,
      "inude" -> 0.35,
      "vulfpeck" -> 0.65,
      "cure" -> 0.2,
      "eelst" -> 0.5
    )

    val expected = PostProcessingInfo(
      ignoreMap = expectedIgnoreMap,
      falsenessThreshold = 0.4
    )

    assert(actual == expected)

  }

}
