object MatchWarnings {

  def m1(i: 3 | 5): Unit = {
    i match
      case 3 =>
        println
      case 4 =>  // *** Not reported dead/unreachable case
        println  // *** Not reported as dead code
      case 5 =>
        println
  }


  def m2(i: 2 | 4): Unit = {
    i match
      case 2 =>
        println
      case 4 =>
        println
      case 3 =>  // (Compiler warns "Unreachable case" (because exhaustive watch))
        println
  }

  def m3(i: 2 | 4): Unit = {
    i match
      case 2 =>
        println
      // no case 4 =>  (Compiler warns "match may not be exhaustive.")
  }






  ???
  println()  // Hmm.  Also not reported as dead code.

}
