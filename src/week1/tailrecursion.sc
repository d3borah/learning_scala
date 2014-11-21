package week1


object exercise {

//import scala.annotation.tailrec
//gcd euclid's algorithm

  def gcd(a: Int, b: Int) : Int =
	if (b == 0) a else gcd(b, a%b)            //> gcd: (a: Int, b: Int)Int

gcd(14,21)                                        //> res0: Int = 7
//bounces continuously back to form of calling gcd()
//iterative!! a loop.
// if (21 == 0 ) 14 else gcd(21, 14 %21)
// if (false) 14 else gcd(21, 14 %21)
//gcd(21, 14 % 21)
// gcd(21, 14)
///if *14 ==0) 21 else gcd(14,21%14)
///gcd(14,7)
///gcd(7,0)
//if (0 ==0) 7 else gcd(0, 7%0)
// if a function calls itself as its last action, the function's stack frame
//can be re-used. constant stack frame. this is called tail-recursion.

	def factorial(n: Int) : Int =
		if (n == 0) 1 else n * factorial(n-1)
                                                  //> factorial: (n: Int)Int

factorial(4)                                      //> res1: Int = 24
//in each step we add one more to our growing expression
//if (4 == 0) 1 else 4 * factorial(4-1)
///4 * factorial(3)
/// 4 * (3 * factorial(2))
// 4 * (3 * (2 * (1 * 1)))
// because of final multiplication of n, this is not tail-recursive.
// this would be good if depth of recursion is limited (eg to 1000
// stack frames) because tail recursion could blow up if recursion is
//very deep, like in factorial. Nonetheless, we will write a tail recursive
// version of factorial


def tailRecursiveFactorial(n:Int): Int = {
	def loop(acc: Int, n: Int) : Int =
		if (n == 0) acc
		else loop(acc * n, n-1)
	loop(1,n)
 }                                                //> tailRecursiveFactorial: (n: Int)Int
tailRecursiveFactorial(4)                         //> res2: Int = 24
}