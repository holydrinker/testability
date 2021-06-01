package holydrinker.testability.configuration

import com.typesafe.config.Config
import scala.collection.JavaConverters._

trait PostProcessingSupportConfigurationLoader {

  def fromTypesafeConfig(config: Config): PostProcessingInfo = {
    val fakenessThreshold = config.getDouble("falsenessThreshold")
    val ignoreMap = config.getConfigList("ignoreList").asScala.map { c =>
      val artist = c.getString("artist")
      val falseness = c.getDouble("falseness")
      artist -> falseness
    }.toMap
    PostProcessingInfo(ignoreMap, fakenessThreshold)
  }

}