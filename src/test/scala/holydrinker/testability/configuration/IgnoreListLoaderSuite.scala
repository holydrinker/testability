package holydrinker.testability.configuration

import com.typesafe.config.ConfigFactory
import org.scalatest.funsuite.AnyFunSuite

class IgnoreListLoaderSuite extends AnyFunSuite with IgnoreListLoader {

  test("non empty list"){

    val config = ConfigFactory.parseString(
      """
        |ignoreList = [
        |    "foo fighters"
        |]
        |""".stripMargin)

    val actual = typesafeConfigToIgnoreList(config)

    val expected = Seq("foo fighters")

    assert(actual == expected)

  }

  test("empty list"){

    val config = ConfigFactory.parseString(
      """
        |ignoreList = []
        |""".stripMargin)

    val actual = typesafeConfigToIgnoreList(config)

    val expected = Seq.empty[String]

    assert(actual == expected)

  }

}
