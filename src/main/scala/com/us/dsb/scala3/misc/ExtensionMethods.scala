package com.us.dsb.scala3.misc

class ExtensionMethods {
  {
    extension (extendee: String) def single(p1: String, p2: Int): String = ""
    // (Not draft syntax def (extendee: String) m(...) = ...)
    "".single("", 0)
  }
  {
    extension (extendee: String) {
      def multi1(): String = ""
      def multi2(): String = ""
    }
    "".multi1()
    "".multi2()
  }
  {
    extension (extendee: String)  // (Note: No colon vs. class/trait decl. syntax.)
      def multi1(): String = ""
      def multi2(): String = ""

    "".multi1()
    "".multi2()
  }
}
