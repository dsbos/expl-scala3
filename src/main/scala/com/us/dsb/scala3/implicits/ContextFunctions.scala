package com.us.dsb.scala3.implicits

import scala.util.chaining._

object ContextFunctions extends App {

  // Base syntaxes and similarities:
  locally {
    trait ArgType
    trait ResultType

    // Regular and context function _types_--(reserved-)non-identifier-symbol infix syntax:
    type RegFnType1     = ArgType  => ResultType
    type ContextFnType1 = ArgType ?=> ResultType

    // Regular and context function _types_--identifier-symbol prefix syntax:
    val rf1: Function1       [ArgType, ResultType] = null: RegFnType1
    val ct1: ContextFunction1[ArgType, ResultType] = null: ContextFnType1

    // (Regular and context function _types_--identifier-symbol infix syntax:)
    type RegFnType1b     = ArgType Function1       ResultType
    type ContextFnType1b = ArgType ContextFunction1 ResultType

    // (Regular and context function _types_--no non-identifier-symbol prefix syntax (because reserved?):)
    //val rf1b:  =>[ArgType, ResultType] = null: RegFnType1
    //val ct1b: ?=>[ArgType, ResultType] = null: ContextFnType1

    // ????????????????????????????????????????????????????????

    // Regular and context function literal syntax:
    val rf2: RegFnType1     = (a: ArgType)  => null: ResultType
    val cf2: ContextFnType1 = (a: ArgType) ?=> null: ResultType


//???????????

    val x1a: RegFnType1 = rf2
    val x1b: ResultType = rf2(null: ArgType)
    //val x1c = rf1 _ // "Only function types can be followed by _ but the current expression has type ArgType => ResultType"

    val x2a: ContextFnType1 = cf2
    //val x2b: ContextFnType1 = cf2(null: ArgType) // "method apply in trait ContextFunction1 does not take more parameters"

    val x2c: ResultType     = cf2(using null: ArgType)
    val x2d: ContextFnType1 = cf2(using null: ArgType)
    val x2e                 = cf2(using null: ArgType) // type is ResultType

    //val x2f: ResultType     = cf2() // "No given instance ..."
    //val x2g: ContextFnType1 = cf2()  // "method apply in trait ContextFunction1 does not take more parameters"
    val x2h: ContextFnType1 = cf2
    //val x2i                 = cf2() // "No given instance ..."

    {
      given ArgType = null
      val x2j                 = cf2
    }



  }


  
  locally {
    case class SomeExplicitContextThing()
    case class SomeContextThing()
    case class SomeResultThing()

    type ContextFunctionType = SomeContextThing ?=> SomeResultThing

    def m(x: SomeExplicitContextThing): ContextFunctionType = {
      ???
    }

    //m(SomeExplicitContextThing())  // "No given instance of type SomeContextThing"

    {
      given SomeContextThing()

      m.apply(SomeExplicitContextThing())

      val x1: SomeExplicitContextThing => SomeResultThing = m

      m(SomeExplicitContextThing())
      val x3: SomeResultThing = m(SomeExplicitContextThing())
    }


  }

  // Scala 2 features (mostly--compiled in Scala 3?):

  locally {
    val f1 = {
      implicit x: Int =>
        assert(implicitly[Int] == x)  // gets x
        x.toString.tap(r => println("f1: = " + r))
    }
    val x1: Int => String = f1

    implicit val i1: Int = 11
    f1.apply(123)
    f1(19)
    //f1()  // missing argument because nothing gets i1
  }

  locally {
    def m2(implicit x: Int): String = {
      assert(implicitly[Int] == x)  // gets x
      //implicitly[Double]          // error--no Double instance
      val r = x.toString
      println("m2: r = " + r)
      r
    }
    val x2: Int => String = m2
    val x2b: Int => String = m2 _
    //val x2c = m2 // i2 is a forward reference extending over the definition of x2c

    implicit val i2: Int = 21
    val x2d: String = m2
    //val x2e: Int => Double = m2
    val x2f = m2
    //val x2g: Double = x2f
    val x2h: String = x2f
    //val x2i: Int => String = x2f


    m2
    m2(29)
    //m2.apply(123)
  }

  // Scala 3:
  locally {
    type NameThis3 = Int ?=> String

    def m3: NameThis3 = {
      summon[Int]          // gets given Int from somwhere
      //summon[Double]          // error--no Double instance
      val r = summon[Int].toString
      println("m2: r = " + r)
      r
    }
    val x3: Int ?=> String = m3
    //val x3b: Int ?=> String = m3 _  // "Only function types can be followed by _ but the current expression has type String"

    given i3: Int = 31
    //m3.apply(123)
    m3
    //m3(39)
  }

  locally {
    type NameThis4 = Int ?=> String

    def m4(other: Char): NameThis4 = {
      summon[Int]          // gets given Int from somwhere
      //summon[Double]          // error--no Double instance
      (summon[Int].toString + other).tap(r => println("m4: = " + r))
    }
    given i4: Int = 41
    val x4a1 = m4
    val x4a2 = m4('y')
    x4a1('z')

//    val x4: Int ?=> String = m4
//
//    //val x4xxxb: Int ?=> String = m4xxx _  // "Only function types can be followed by _ but the current expression has type String"
//
//    //m4xxx.apply(124xxx)
//    m4xxx
//    //m4xxx(4xxx9)
  }

}
