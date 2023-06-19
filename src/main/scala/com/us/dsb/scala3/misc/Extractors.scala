package com.us.dsb.scala3.misc


object Extractors {

  {
    case class CaseClass(p1: Int, p2: String)
    val x1 = CaseClass(1, "1")
    val x12 = new CaseClass(2, "2")
    val x13 = CaseClass.apply(3, "3")
    x1 match
      case CaseClass(p1Out: Int, p2Out: String) =>
    // Note: signature is apparently unapply(CaseClass): CaseClass
    val x2: Function1[CaseClass, CaseClass] = CaseClass.unapply
    val x3: CaseClass = CaseClass.unapply(x1)
  }

  {
    class NoncaseClass(val p1: Int, val p2: String)
    val x1 = NoncaseClass(1, "1")
    val x12 = new NoncaseClass(2, "2")
    val x13 = NoncaseClass.apply(3, "3")

    object NoncaseClass:
      //def unapply(scrutinee: NoncaseClass): NoncaseClass = ???
      def unapply(scrutinee: NoncaseClass): Option[NoncaseClass] = ???

    x1 match
      case NoncaseClass(x) =>
      case NoncaseClass(x: List[_]) =>
      //??case NoncaseClass(p1Out: Int, p2Out: String) =>

    //val x2: Function1[NoncaseClass, NoncaseClass] = NoncaseClass.unapply
    //val x3: NoncaseClass = NoncaseClass.unapply(x1)
  }


  { // Boolean extractor--simple:

    trait SomeInputType

    object IsSomething:
      def unapply(x: SomeInputType): Boolean = ???

    (null: AnyRef) match
      case something       @ IsSomething()  =>
      case extractorObject @ IsSomething    =>  // (atypical)
  }

  { // Product extractor--simple case class:

    trait SomeInputType

    trait SomeProductType extends Product
    case class SomeProductTypeImpl(val atLeastOneMember: String) extends SomeProductType
    object  SomeProductTypeImpl:
      def apply(atLeastOneMember: String): SomeProductTypeImpl = new SomeProductTypeImpl(atLeastOneMember)

    (null: Product).productElementNames
    (null: SomeProductTypeImpl).productElementNames

    object Extractor:
      def unapply(x: SomeInputType): SomeProductTypeImpl = ???

    (null: AnyRef) match
      case in @ Extractor( out1 ) => in: SomeInputType
  }

  locally { // Product extractor--try non-case class:

  }

  locally { // Single-match extractor--??"

    trait SomeInputType


//    type R = {
//      def isEmpty: Boolean
//      def get: S
//    }
//    class S extends R



//    object Extractor:
//      def unapply(x: SomeInputType): U = ???



  }





  /*
    - fixed-arity extractors
      - boolean match
      - product match
      - ?:
        - single match
        - name-based match
    - variadic extractors (unapplySeq)
      - sequence match
      - product-sequence match
      - other?

    */


}
