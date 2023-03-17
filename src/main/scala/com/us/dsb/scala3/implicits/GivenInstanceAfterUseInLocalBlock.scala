package com.us.dsb.scala3.implicits

object GivenInstanceAfterUseInLocalBlock {

  locally {
    def m1()(using u: Int): Unit = ()

    m1()              // works even though before g and in non-class/etc. block
                      // (Scala 2: "forward reference to value g defined on line
                      //    ... extends over definition of value g")
    given g: Int = 1
    m1()              // (normal/expected/familiar after-given case)
  }
}
