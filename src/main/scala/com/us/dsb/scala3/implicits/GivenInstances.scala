package com.us.dsb.scala3.implicits

object GivenInstances extends App {

  // Basic/minimal:
  locally {
    given i: Int = 1
    def m()(using i: Int) = null
    m()
  }

  // Explicit passing:
  locally {
    given i: Int = 1
    def m(using i: Int) = null

    m(using 123)
    //m(using 123)() // actual-param lists must be in order; "Missing arguments for method m"
  }

  // Default values:
  locally {
    println
    println("Default values:")
    def m(label: String)(using i: String = "<default>"): Unit = {
      println(s"m: $label: i = $i")
    }
    {
      m("no context 'given', no call 'using'")                   // uses default
      m("no context 'given',         'using'")(using "<using>")  // uses explicit
    }
    {
      given String = "<given>"
      m("   context 'given', no call 'using'")                   // uses given
      m("   context 'given',         'using'")(using "<using>")  // uses explicit
    }
    println
  }

  locally {
    given i: Int = 1
    def m()()(using i: Int)(): String = "2"
    m()()()
    //m()()()(using 3)  // Huh?: "Missing arguments for method apply in class StringOps"
    m()()(using 4)()
    //m()(using 5)()()  // Note unclear: "Missing arguments for method m"
    //m(using 6)()()()  // Note unclear: "Missing arguments for method m"
  }

  // Multiple implicit parameters:
  locally {
    given Int = 1
    given Float = 2
    def m()()(using i: Int)(using j: Float)(): String = "2"

    m()()()
    m()()(using 3)()     // Can omit implicit arguments _after_ explicit "using"
    //m()()(using 4f)()  // Cannot omit  omit implicit arguments _before_ explicit "using"
    m()()(using 5)(using 6f)()

    def m2()(using i: Int , j: Float)(): String = "2"
    m()()()
    m()()(using 3)()     // Can omit implicit arguments _after_ explicit "using"
    //m()()(using 4f)()  // Cannot omit  omit implicit arguments _before_ explicit "using"
    m()()(using 5)(using 6f)()

  }

  //???? TODO:  Do given instances beyond simple primitive values (e.g.,
  // "implicit def" equivalent (givens defined with "using"), syntax
  // "<abstract type> with ... def ..."/etc.)

  // ????????????????????????????????????????????????????????????????????????????????

  {
    trait Logger:
      def log(msg: String): Unit

    def m1(input: String)(using logger: Logger): Unit =
      logger.log("")

    def m2(input: String)(using logger: Logger): Unit =
      m1("")

    def m3(input: String)(using logger: Logger): Unit =
      m2("")

    m1("A")
    given logger: Logger = new Logger {
      def log(msg: String): Unit = {
        println("Logger 1: " + msg)
      }
    }
    m1("A")



      val logger2: Logger = new Logger {
        def log(msg: String): Unit = {
          println("Logger 2: " + msg)
        }
      }

    println("----------")
    m1("A")
    println("----------")
    m2("B")
    println("----------")
    m2("C")(using logger2)
    println("----------")



    //  {
    //    // simple values (like "implicit val"):
    //
    //    given gi: Int = 1
    //    given Long = 2     // name optional; gets generated name
    //
    //    //
    //
    //
    //  }
    //
    //
    //
    //  given gi: Int = 1
    //  given gL: Long = 2
    //  summon[Int]
    //
    //  {
    //    given gi1: Int = 1
    //    given gi2: Int = 1  //
    //
    //    summon[Int]
    //
    //  }
    //
    //  summon[Int]
    //
    //  //given gs: Short with { } // object gs cannot extend final class Short
    //
    //  case class CC()
    //  given gcc: CC = CC()
    //
    //
    //
    ////
    ////  trait T
    ////  given gl: T with {
    ////
    ////  }
    //
  }
}
