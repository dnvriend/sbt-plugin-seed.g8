version := "1.0.0-SNAPSHOT"

scalaVersion := "2.12.4"

val testHelloWorld = taskKey[Unit]("Tests the helloWorld task")

testHelloWorld := {
  assert(helloWorldText.value == "Hi there!")
}