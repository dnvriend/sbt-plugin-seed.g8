// https://github.com/sbt/sbt-scalariform
// to format scala source code
addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.8.2")

// enable updating file headers eg. for copyright
addSbtPlugin("de.heikoseeberger" % "sbt-header" % "3.0.2")

// added scripted
libraryDependencies += "org.scala-sbt" %% "scripted-plugin" % sbtVersion.value