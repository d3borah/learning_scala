package week2

object Rationals {
  val x = new Rational(1,3)                       //> x  : week2.Rational = 1/3
  val y = new Rational(5,7)                       //> y  : week2.Rational = 5/7
  val z = new Rational(3,2)                       //> z  : week2.Rational = 3/2                                       //> res1: Int = 3
  x - y - z                                       //> res2: week2.Rational = -79/42
  y + y                                           //> res3: week2.Rational = 10/7
  x < y                                           //> res4: Boolean = true
  x max y                                         //> res5: week2.Rational = 5/7
  new Rational(2)                                 //> res6: week2.Rational = 2/1
}

class Rational(x: Int, y:Int) {
	require(y != 0, "denominator must be nonzero")
	
	//alternate constructor
	//calls another constructor with 2 arguments, the implicit primary constructor of class Rational
	def this(x:Int) = this(x,1)
	
		private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
	//private val g = gcd(x,y)
  //def numer = x/g
	//def denom = y/g
	//turn into vals so they are computed only once
	//val numer = x/ gcd(x,y)
	//val denom = y/ gcd(x,y)
	val numer = x
	val denom = y
	
	def < (that: Rational) =
	numer * that.denom < that.numer * denom
	
	def max(that: Rational) = if (this < that) that else this
	
	def + (that: Rational) =
	new Rational(
	numer * that.denom + that.numer * denom,
	denom * that.denom)
	
	def unary_- : Rational =
	new Rational(-numer, denom )
	
	//def sub(that:Rational) = add(that.neg)
	def - (that: Rational) = this + -that
	
	override def toString = {
	val g = gcd(numer, denom)
	numer/g + "/" + denom/g
	}
		
}