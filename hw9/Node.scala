case class Node(value: Int, left: BSTree, right: BSTree) extends BSTree {
    def member(x: Int): Boolean = {
        if (value == x) true
        else if (x < value) left.member(x)
            else right.member(x)
    }

    def insert(x: Int): BSTree =
        if (x < value) Node(value, left.insert(x), right)
        else if (x > value) Node(value, left, right insert x) 
        else this;

    def equal(other: BSTree): Boolean =
        other match {
            case Leaf => false
            case Node(v, l, r) => value == v &&
                                  left.equal(l) &&
                                  right.equal(r)
        };
    
    def depth: Int =
        1 + Math.max(left.depth, right.depth);

    def exactSubtree(that: BSTree): Boolean =
        that match {
            case Leaf => false
            case Node(v, l, r) =>
                if (value == v) equal(that)
                else if (value < v) exactSubtree(l)
                else exactSubtree(r)
        };

    override def toString = "{" +
                            left.toString +
                            value.toString +
                            right.toString + "}";
}