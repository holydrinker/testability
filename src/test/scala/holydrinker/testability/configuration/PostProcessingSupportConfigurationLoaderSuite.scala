package holydrinker.testability.configuration

import com.typesafe.config.ConfigFactory
import org.scalatest.funsuite.AnyFunSuite

class PostProcessingSupportConfigurationLoaderSuite extends AnyFunSuite with PostProcessingSupportConfigurationLoader {

  test("non empty list"){

    val config = ConfigFactory.parseString(
      """
        |ignoreList = [
        |    "foo fighters"
        |]
        |""".stripMargin)

    val actual = fromTypesafeConfig(config)

    val expected = PostProcessingInfo(Seq("foo fighters"))

    assert(actual == expected)

  }

  test("empty list"){

    val config = ConfigFactory.parseString(
      """
        |ignoreList = []
        |""".stripMargin)

    val actual = fromTypesafeConfig(config)

    val expected = PostProcessingInfo(Seq.empty[String])

    assert(actual == expected)

  }

}
