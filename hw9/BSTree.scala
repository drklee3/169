abstract class BSTree {
    /**
     * True if x is in BSTree
     */ 
    def member(x: Int): Boolean;

    /**
     * Creates a copy of the current tree with x added
     */ 
    def insert(x: Int): BSTree;

    /**
     * True this and that trees have identical values and structure
     */
    def equal(that: BSTree): Boolean;

    /**
     * Depth of deepest Leaf
     */
    def depth: Int;
    
    /**
     * True if this is an exact subtree of that
     */
    def exactSubtree(that: BSTree): Boolean;
}
