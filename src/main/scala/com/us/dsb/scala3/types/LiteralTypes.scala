package com.us.dsb.scala3.types

/**
 * Literal-based singleton types (base already in Scala 2.13).
 */
object LiteralTypes {

  // Literal types with union type:
  def m(i: 1 | 2 | 4): Unit = {
    i match
      case 1 => println("r--")
      case 2 => println("-w-")
      case 3 => println("--x")  // No warning for _value_ match impossible per type (3.2.2)
      case 4 => println("--x")
      //case 5 => println("--x")  // ("Unreachable case" detected if all values covered before.)
      // Note:  Exhaustive-match check can identify missed values.
  }

  def m2(i: 1 | 2 | 4): Unit = {
    i match
      case _: 1 => println("r--")
      case _: 2 => println("-w-")
      case _: 3 => println("--x")  // No warning for _type_ match impossible per type (3.2.2)
      case _: 4 => println("--x")
      case _: 5 => println("--x")  // ("Unreachable case" detected if all types covered before.)
    // Note:  Exhaustive-match check can identify missed values.
  }

}
