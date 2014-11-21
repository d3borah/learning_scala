package week2

import math.abs

object fixed_point {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(76); 
	val tolerance = 0.0001;System.out.println("""tolerance  : Double = """ + $show(tolerance ));$skip(79); 
	
	def isCloseEnough(x: Double, y: Double) =
	  abs((x-y) / x) / x < tolerance;System.out.println("""isCloseEnough: (x: Double, y: Double)Boolean""");$skip(269); 
  
  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
	  	def iterate(guess: Double): Double = {
	  	//println("guess =" + guess)
	  		val next = f(guess)
	  		if (isCloseEnough(guess, next)) next
	  	  else iterate(next)
	  	}
	    iterate(firstGuess)
	  };System.out.println("""fixedPoint: (f: Double => Double)(firstGuess: Double)Double""");$skip(70); 
	  
	  def averageDamp(f: Double => Double)(x: Double) = (x + f(x))/2;System.out.println("""averageDamp: (f: Double => Double)(x: Double)Double""");$skip(62); 
	  def sqrt(x: Double) = fixedPoint(averageDamp(y => x/y))(1);System.out.println("""sqrt: (x: Double)Double""");$skip(34); val res$0 = 
	  
	  fixedPoint(x=> 1 + x/2)(1);System.out.println("""res0: Double = """ + $show(res$0));$skip(78); val res$1 = 
	  
	  //def sqrt(x: Double) = fixedPoint(y => (y + x/y)/2)(1)
	  
	  sqrt(2);System.out.println("""res1: Double = """ + $show(res$1))}
}
