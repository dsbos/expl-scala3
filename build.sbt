ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.2"

lazy val root = (project in file("."))
  .settings(
    name := "expl-scala3"
  )

scalacOptions ++= Seq(
  "-explain",
  "-feature",

  // as of 3.2.2:
  //"-Xlint",                       // "[warn] bad option '-Xlint' was ignored"
  //"-Xlint:unused",                // "[warn] bad option '-Xlint:unused' was ignored"
  //"-Wdead-code",                  // "[warn] bad option '-Wdead-code' was ignored"
  //"-Wwarn-dead-code",             // "[warn] bad option '-Wwarn-dead-code' was ignored"
  //"-Xwarn-dead-code",             // "[warn] bad option '-Xwarn-dead-code' was ignored"
  //"-Ywarn-dead-code",             // "[warn] bad option '-Ywarn-dead-code' was ignored"
  //"-Wunused:imports",             // "[error] invalid choice(s) for -Wunused: imports"

  //"-Wunused",                     // "[error] missing argument for option -Wunused"
  //"-Wunused:x",                   // "[error] invalid choice(s) for -Wunused: x"
  //"-Wunused:givens",              // "[error] invalid choice(s) for -Wunused: XXX"
  //"-Wunused:imports",             // "[error] invalid choice(s) for -Wunused: XXX"
  //"-Wunused:implicits",           // "[error] invalid choice(s) for -Wunused: XXX"
  //"-Wunused:linted",              // "[error] invalid choice(s) for -Wunused: XXX"
  //"-Wunused:locals",              // "[error] invalid choice(s) for -Wunused: XXX"
  "-Wunused:nowarn",
  //"-Wunused:params",              // "[error] invalid choice(s) for -Wunused: XXX"
  //"-Wunused:patvars",             // "[error] invalid choice(s) for -Wunused: XXX"
  //"-Wunused:privates",            // "[error] invalid choice(s) for -Wunused: XXX"
  //"-Wunused:unsafe-warn-patvars", // "[error] invalid choice(s) for -Wunused: XXX"
)
