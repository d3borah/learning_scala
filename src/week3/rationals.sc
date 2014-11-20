package week3

object rationals {
  val x = new Rational(1,2)                       //> x  : week3.Rational = week3.Rational@56406199
	x.numer                                   //> res0: Int = 1

}

class Rational(x:Int,y: Int) {
 def numer = x
 def demon = y
}