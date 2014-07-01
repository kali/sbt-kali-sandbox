package plu

import sbt._
import Keys._

object Plu extends AutoPlugin {

    lazy val myBeforeRun = taskKey[Unit]("run before run too")

    def pluHi = { println("Hi from plugin!") }

    override def requires = sbt.plugins.CorePlugin
    override def trigger = allRequirements

    override lazy val projectSettings =
        inConfig(Compile)(Seq(
            myBeforeRun := pluHi,
            (run) <<= (run) dependsOn(myBeforeRun)
        ))

}

