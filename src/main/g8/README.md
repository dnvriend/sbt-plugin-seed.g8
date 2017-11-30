# $name$

## Testing the plugin
Use the `scripted` command in sbt to execute scripts in `src/sbt-test/$plugin_name$/`.

## Cross Sbt builds
[sbt-cross-building](http://www.scala-sbt.org/0.13/docs/sbt-0.13-Tech-Previews.html#sbt-cross-building) is integrated in sbt v0.13.16 and higher.  It adds cross command `^` and sbtVersion switch command `^^`, similar to `+` and `++`, but for switching between multiple sbt versions across major versions. sbt 0.13.16 merges these commands into sbt because the feature it provides is useful as we migrate plugins to sbt 1.0.

If you need to make changes specific to a sbt version, you can now include them into `src/main/scala-sbt-0.13`, and `src/main/scala-sbt-1.0`, where the binary sbt version number is used as postfix.