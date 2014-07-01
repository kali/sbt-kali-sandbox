import sbt._

import sbt.Keys._

object MyBuild extends Build {

    lazy val beforeRun = taskKey[Unit]("run before run")

    lazy val pro = Project ("pro", file("."), settings=Seq(
        (run in Compile) <<= (run in Compile) dependsOn( beforeRun ),
        beforeRun := sayHi
    ) /* ++ plu.Plu.projectSettings */
    )

    def sayHi = { println("Hi from project") }
}
