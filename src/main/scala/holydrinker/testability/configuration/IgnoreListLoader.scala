package holydrinker.testability.configuration

import com.typesafe.config.Config
import scala.collection.JavaConverters._

trait IgnoreListLoader {

  def typesafeConfigToIgnoreList(config: Config): Seq[String] = {

    config.getStringList("ignoreList").asScala

  }

}
