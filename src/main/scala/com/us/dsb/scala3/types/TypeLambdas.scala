package com.us.dsb.scala3.types

object TypeLambdas {

  type Type = [V, K] =>> Map[K, V]

  val x1: Type[Int, String] = Map[String, Int]()
  val x2: Map[String, Int] = x1

  val x3: ([X, Y] =>> Map[Y, X])[Int, String] = x1



/*
  Scala 2: ({ type T[A] = Map[Int, A] })#T
  Scala 3: [A] =>> Map[Int, A]    (?)


  re currying:

  type TL = [X] =>> [Y] =>> ...
  is the same as
  type TL[X]  =     [Y] =>> ...

*/

// TODO:  explore uses (


}
