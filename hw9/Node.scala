import scala.math.max;

case class Node(value: Int, left: BSTree, right: BSTree) extends BSTree {
    def member(x: Int): Boolean = {
        if (value == x) true
        else if (x < value) left.member(x)
            else right.member(x)
    }

    def insert(x: Int): BSTree =
        if (x < value) new Node(value, left.insert(x), right)
        else if (x > value) new Node(value, left, right insert x) 
        else this;

    def equal(other: BSTree): Boolean =
        other match {
            case Leaf => false
            case Node(v, l, r) => value == v &&
                                  left.equal(l) &&
                                  right.equal(r)
        };
    
    def depth(): Int =
        max(1 + left.depth(), 1 + right.depth());

    def exactSubtree(that: BSTree): Boolean =
        true;

    override def toString = "{" +
                            left.toString +
                            value.toString +
                            right.toString +
                            "}";
}