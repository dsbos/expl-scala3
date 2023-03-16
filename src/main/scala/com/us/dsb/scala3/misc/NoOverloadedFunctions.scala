package com.us.dsb.scala3.misc

// Still no overloaded _functions_ / _local_ methods:
object NoOverloadedFunctions extends App {
  locally {
    def f(): Unit = ()
    // def f(x: Int): Unit = () // "m is already defined as method ..."
  }
}
