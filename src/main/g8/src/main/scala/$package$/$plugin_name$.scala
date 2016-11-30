package $package$

import sbt._
import sbt.Keys._

object $plugin_name$ extends AutoPlugin {
 override def trigger: PluginTrigger = allRequirements

 override def requires: Plugins = plugins.JvmPlugin

 object autoImport {
 	val thisIsTrue: SettingKey[Boolean] = settingKey[Boolean]("Defines whether or not this is true")
 	val helloWorldText: SettingKey[String] = settingKey[String]("The text to show for the task helloWorld")
 	val helloWorld: TaskKey[String] = taskKey[String]("Prints the helloworld message to the console")
 }

 import autoImport._

 lazy val defaultSettings: Seq[Setting[_]] = Seq(
 	thisIsTrue := false,
 	helloWorldText := "Hi there!",
 	helloWorld := HelloWorld.runHelloWorld.value
 )

  override def projectSettings: Seq[Setting[_]] =
    defaultSettings
}

object HelloWorld {
	import $plugin_name$.autoImport._
	def runHelloWorld:  Def.Initialize[Task[String]] = Def.task {
	   val logger: Logger = streams.value.log
	   val _thisIsTrue: Boolean = thisIsTrue.value
	   val _helloWorldText: String = helloWorldText.value

	   logger.info(
      s"""
         |Running task: helloWorld
         |========================
         |thisIsTrue: \${_thisIsTrue}
         |helloWorldText: \${_helloWorldText}
      """.stripMargin)

	   _helloWorldText
	}
}
