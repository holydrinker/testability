package holydrinker.testability.configuration

import com.typesafe.config.Config
import scala.collection.JavaConverters._

trait PostProcessingSupportConfigurationLoader {

  def fromTypesafeConfig(config: Config): PostProcessingInfo = {

    val ignoreList = config.getStringList("ignoreList").asScala

    PostProcessingInfo(ignoreList)

  }

}