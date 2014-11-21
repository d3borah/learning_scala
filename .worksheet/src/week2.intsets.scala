package week2

object intsets {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(72); 
  val t1 = new NonEmpty(3, Empty, Empty);System.out.println("""t1  : week2.NonEmpty = """ + $show(t1 ));$skip(21); 
  val t2 = t1 incl 4;System.out.println("""t2  : week2.IntSet = """ + $show(t2 ))}

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
