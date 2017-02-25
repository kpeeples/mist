package io.hydrosphere.mist.lib

import io.hydrosphere.mist.MistConfig
import io.hydrosphere.mist.master.async.AsyncInterface

trait MqttPublisher extends Publisher{
  override def publish(message: String): Unit = {
    if (MistConfig.Mqtt.isOn) {
      AsyncInterface.publisher(AsyncInterface.Provider.Mqtt, null) ! message
    }
  }
}