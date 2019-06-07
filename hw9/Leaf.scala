case object Leaf extends BSTree {
    def member(x: Int): Boolean = false;

    def insert(x: Int): BSTree = Node(x, Leaf, Leaf);

    def equal(that: BSTree): Boolean = this == that;

    def depth: Int = 0;

    def exactSubtree(that: BSTree): Boolean =
        that match {
            case Leaf => true
            case Node(_, _, _) => false
        };

    override def toString = "."
}