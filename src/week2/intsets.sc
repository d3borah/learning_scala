package week2

object intsets {
  val t1 = new NonEmpty(3, Empty, Empty)          //> t1  : week2.NonEmpty = {.3.}
  val t2 = t1 incl 4                              //> t2  : week2.IntSet = {.3{.4.}}

}

abstract class IntSet {
   def incl(x:Int): IntSet
   def contains(x:Int): Boolean
   def union(other: IntSet): IntSet
}


//class Empty extends IntSet {
// def contains(x: Int): Boolean = false
// def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
// override def toString = "."
//}

object Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  override def toString = "."
  def union(other: IntSet): IntSet = other
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  
  def contains(x: Int):Boolean =
  if (x < elem) left contains x
  else if (x > elem) right contains x
  else true
  
  def incl(x:Int): IntSet =
  if (x < elem) new NonEmpty(elem, left incl x, right incl x)
  else if (x > elem) new NonEmpty(elem, left, right incl x)
  else this
  
  override def toString = "{" + left + elem + right + "}"
  
  def union(other: IntSet): IntSet =
  ((left union right) union other) incl elem
}
//class Union(set1: IntSet, set2: IntSet) extends IntSet {}