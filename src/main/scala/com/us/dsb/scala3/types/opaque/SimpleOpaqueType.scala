package com.us.dsb.scala3.types.opaque

// not explored:  type parameters
// not explored:  type bounds, e.g.:
// - type T1       = ...
// - type T2 <: T1 = ...
// - (...: T2): T1

object SimpleOpaqueType {

  object DeclaringContext {

    // 1. Type alias(?):
    opaque type SomethingOpaque = String

    // 2. Type ~alias companion object typically constructors (static methods):
    //
    // (static) constructor(s)/etc.:
    object SomethingOpaque {
      def apply(raw: String): SomethingOpaque = raw
      def safeApply(raw: String): Option[SomethingOpaque] = ???
      def otherStaticMethod: Int = 0
    }

    // 3. Extension method(s) for logical instance methods:
    extension (raw: SomethingOpaque) {
      def getRaw: String  = raw
      def length = raw.length
      def otherInstanceMethod: Int = 0
    }

    // not opaque in declaring context (also see extension methods):
    val v1: SomethingOpaque = ""
    val v2: String = v1
  }

  {
    import DeclaringContext.*  // new    wildcard syntax
    import DeclaringContext._  // legacy wildcard syntax

    val x1: String = ""
    //val x2: SomethingOpaque = ""          //  type error
    val x3: SomethingOpaque = SomethingOpaque("")
    //val x4: String = SomethingOpaque("")  // type error

    val y1: String = x3.getRaw
    x3.length
    x3.otherInstanceMethod
  }
}
