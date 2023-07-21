package com.us.dsb.scala3.types.opaque

object OpaqueTypeScope {

  object DeclaringBlock {
    opaque type SomethingOpaque = String

    // NOT opaque in declaring context:
    "": DeclaringBlock.SomethingOpaque

    // NOT opaque in descendents of declaring context:
    object ChildBlock {
      "": DeclaringBlock.SomethingOpaque

      object GrandChildBlock {
        "": DeclaringBlock.SomethingOpaque
      }
    }
  }

  object SiblingBlock {
    // IS opaque outside of  declaring context:
    // "": DeclaringBlock.SomethingOpaque  //  "Found ... String ... Required ... SomethingOpaque"
  }

}
