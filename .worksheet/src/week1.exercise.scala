package week1

//higher order functions are essential in scala. currying. a function that returns a locally defined function.
//function applications associate to the left
// sum(cube)(1,10) == (sum (cube))(1,10)
// the definition of functions that return functions have special syntax. it doesn't look like the nested function:
//combine the parameter lists of the outer function and the nested function.
//result is nested anonymous functions that each take one parameter.
//def f = (args1 => (args2 => ..(argsn => E) ...))
//function types associate to the right
//eg. function returns a function which takes two parameters and returns and int
//(Int => Int) => ((Int, Int) => Int)

object exercise {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(851); 

//summing with higher-order functions. linear recursion.
def sum1(f: Int => Int, a: Int, b: Int): Int =
  if (a>b) 0
  else f(a) + sum1(f, a+1, b);System.out.println("""sum1: (f: Int => Int, a: Int, b: Int)Int""");$skip(26); 

def id(x: Int) : Int = x;System.out.println("""id: (x: Int)Int""");$skip(45); 
def sumInts(a: Int, b: Int) = sum1(id, a, b);System.out.println("""sumInts: (a: Int, b: Int)Int""");$skip(34); 
def cube(x: Int): Int = x * x * x;System.out.println("""cube: (x: Int)Int""");$skip(47); 
def sumCubes(a: Int, b: Int) = sum(cube, a, b);System.out.println("""sumCubes: (a: Int, b: Int)Int""");$skip(54); 
def fact1(x:Int): Int = if (x == 0) 1 else fact1(x-1);System.out.println("""fact1: (x: Int)Int""");$skip(51); 
def sumFactorials(a: Int, b: Int) = sum(fact1,a,b);System.out.println("""sumFactorials: (a: Int, b: Int)Int""");$skip(306); 


//we don't have to define a string using def (eg prinln("abc"),
//we want to do the same for functions. anonymous functions.
// eg (x: Int) => x * x * x
//every AF can be also expressed using a def
// {def f(X1 : T1 ... :) = E; f} where f is a fresh name
def sumInts2(a: Int, b: Int) = sum1(x => x, a,b);System.out.println("""sumInts2: (a: Int, b: Int)Int""");$skip(54); 
def sumCubes2(a:Int, b: Int) = sum1(x => x*x*x, a, b);System.out.println("""sumCubes2: (a: Int, b: Int)Int""");$skip(273); 

//tail recursive version of sum. with linear recursion,
// if the interval between a and b
// is large, you might risk stack overflow.
def sum(f: Int => Int, a: Int, b: Int): Int = {
	def loop(a: Int, acc:Int): Int =
		if(a>b) acc
		else loop(a+1,f(a) + acc)
	loop(a,0)
};System.out.println("""sum: (f: Int => Int, a: Int, b: Int)Int""");$skip(99); 
	


def product(f: Int => Int)(a: Int, b: Int): Int =
	if (a > b) 1
	else f(a) * product(f)(a+1,b);System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(41); 

def fact(n: Int) = product(x => x)(1,n);System.out.println("""fact: (n: Int)Int""");$skip(163); 

def mapReduce(f: Int => Int, combine: (Int,Int) => Int, zero: Int)(a:Int, b:Int): Int =
		if (a>b) zero
		else combine(f(a), mapReduce(f, combine, zero)(a+1, b));System.out.println("""mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int)Int""");$skip(93); 


def productgen(f: Int => Int)(a: Int, b: Int): Int =
	mapReduce(f, (x,y) => x * y, 1)(a,b);System.out.println("""productgen: (f: Int => Int)(a: Int, b: Int)Int""");$skip(47); 

def factgen(n: Int) = productgen(x => x)(1,n);System.out.println("""factgen: (n: Int)Int""");$skip(42); val res$0 = 


sum((x => x*x), 3,5);System.out.println("""res0: Int = """ + $show(res$0));$skip(8); val res$1 =    //sum of squares
fact(5);System.out.println("""res1: Int = """ + $show(res$1));$skip(11); val res$2 = 
factgen(5);System.out.println("""res2: Int = """ + $show(res$2));$skip(23); val res$3 = 
product(x => x*x)(3,4);System.out.println("""res3: Int = """ + $show(res$3));$skip(26); val res$4 = 
productgen(x => x*x)(3,4);System.out.println("""res4: Int = """ + $show(res$4))}

}
