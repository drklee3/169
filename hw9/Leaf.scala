case object Leaf extends BSTree {
    def member(x: Int): Boolean = false;

    def insert(x: Int): BSTree = new Node(x, Leaf, Leaf);

    def equal(other:BSTree): Boolean = this == other;

    def depth(): Int = 0;

    def exactSubtree(that: BSTree): Boolean = true;

    override def toString = "."
}