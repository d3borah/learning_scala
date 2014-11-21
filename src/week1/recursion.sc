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

object exercise {

//summing with higher-order functions. linear recursion.
def sum1(f: Int => Int, a: Int, b: Int): Int =
  if (a>b) 0
  else f(a) + sum1(f, a+1, b)                     //> sum1: (f: Int => Int, a: Int, b: Int)Int

def id(x: Int) : Int = x                          //> id: (x: Int)Int
def sumInts(a: Int, b: Int) = sum1(id, a, b)      //> sumInts: (a: Int, b: Int)Int
def cube(x: Int): Int = x * x * x                 //> cube: (x: Int)Int
def sumCubes(a: Int, b: Int) = sum(cube, a, b)    //> sumCubes: (a: Int, b: Int)Int
def fact1(x:Int): Int = if (x == 0) 1 else fact1(x-1)
                                                  //> fact1: (x: Int)Int
def sumFactorials(a: Int, b: Int) = sum(fact1,a,b)//> sumFactorials: (a: Int, b: Int)Int


//we don't have to define a string using def (eg prinln("abc"),
//we want to do the same for functions. anonymous functions.
// eg (x: Int) => x * x * x
//every AF can be also expressed using a def
// {def f(X1 : T1 ... :) = E; f} where f is a fresh name
def sumInts2(a: Int, b: Int) = sum1(x => x, a,b)  //> sumInts2: (a: Int, b: Int)Int
def sumCubes2(a:Int, b: Int) = sum1(x => x*x*x, a, b)
                                                  //> sumCubes2: (a: Int, b: Int)Int

//tail recursive version of sum. with linear recursion,
// if the interval between a and b
// is large, you might risk stack overflow.
def sum(f: Int => Int, a: Int, b: Int): Int = {
	def loop(a: Int, acc:Int): Int =
		if(a>b) acc
		else loop(a+1,f(a) + acc)
	loop(a,0)
}                                                 //> sum: (f: Int => Int, a: Int, b: Int)Int
	


def product(f: Int => Int)(a: Int, b: Int): Int =
	if (a > b) 1
	else f(a) * product(f)(a+1,b)             //> product: (f: Int => Int)(a: Int, b: Int)Int

def fact(n: Int) = product(x => x)(1,n)           //> fact: (n: Int)Int

def mapReduce(f: Int => Int, combine: (Int,Int) => Int, zero: Int)(a:Int, b:Int): Int =
		if (a>b) zero
		else combine(f(a), mapReduce(f, combine, zero)(a+1, b))
                                                  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b
                                                  //| : Int)Int


def productgen(f: Int => Int)(a: Int, b: Int): Int =
	mapReduce(f, (x,y) => x * y, 1)(a,b)      //> productgen: (f: Int => Int)(a: Int, b: Int)Int

def factgen(n: Int) = productgen(x => x)(1,n)     //> factgen: (n: Int)Int


sum((x => x*x), 3,5)   //sum of squares           //> res0: Int = 50
fact(5)                                           //> res1: Int = 120
factgen(5)                                        //> res2: Int = 120
product(x => x*x)(3,4)                            //> res3: Int = 144
productgen(x => x*x)(3,4)                         //> res4: Int = 144

}