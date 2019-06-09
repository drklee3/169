class mySet(val f: Int => Boolean) {
    def contains(elem: Int): Boolean =
        this.f(elem)

    /**
     * Union of this and tc
     */
    def \/(t: mySet): mySet =
        new mySet(x => this.contains(x) || t.contains(x));

    /**
     * Intersection of this and t
     */
    def /\(t: mySet): mySet =
        new mySet(x => this.contains(x) && t.contains(x));

    /**
     * Difference of this and t
     */
    def -(t: mySet): mySet =
        new mySet(x => this.contains(x) && !t.contains(x));

    /**
     * New set of elements of s that satisfy p
     */
    def filter(p: Int => Boolean): mySet =
        new mySet(x => this.contains(x) && p(x));
    
    def forall(p: Int => Boolean): Boolean = {
        def apply(x: Int): Boolean =
            if (x > 1000) true
            else if (!this.contains(x)) apply(x + 1)
            else if (p(x)) apply(x + 1)
            else false;

        apply(-1000)
    };

    def forallI(p: Int => Boolean): Boolean =
        -1000.to(1000)
             .filter(f)
             .forall(p);
    
    override def toString =
        "[" +
        -1000.to(1000)
             .filter(f)
             .mkString(", ") + "]";
}
