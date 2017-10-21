name := "$name$"

organization := "$organization$"

version := "$version$"

scalaVersion := "2.12.4"

sbtPlugin := true

libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.2.16"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.3" % Test

// enable scala code formatting //
import scalariform.formatter.preferences._
import com.typesafe.sbt.SbtScalariform

// Scalariform settings
SbtScalariform.autoImport.scalariformPreferences := SbtScalariform.autoImport.scalariformPreferences.value
   .setPreference(AlignSingleLineCaseStatements, true)
   .setPreference(AlignSingleLineCaseStatements.MaxArrowIndent, 100)
   .setPreference(DoubleIndentConstructorArguments, true)
   .setPreference(DanglingCloseParenthesis, Preserve)

// enable updating file headers //
organizationName := "$author_name$"
startYear := Some(2017)
licenses := Seq(("Apache-2.0", new URL("https://www.apache.org/licenses/LICENSE-2.0.txt")))
headerMappings := headerMappings.value + (HeaderFileType.scala -> HeaderCommentStyle.CppStyleLineComment)

// Scripted settings
scriptedLaunchOpts := {
    scriptedLaunchOpts.value ++
    Seq("-Xmx1024M", "-Dplugin.version=" + version.value)
}
scriptedBufferLog := false

enablePlugins(AutomateHeaderPlugin, SbtScalariform, ScriptedPlugin)
