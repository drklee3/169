class Set(f: Int => Boolean) {
    def contains(elem: Int): Boolean =
        this.f(elem)

    /**
     * Union
     */
    def \/(t: Set): Set =
        new Set(x => this.contains(x) || t.contains(x));

    /**
     * Intersection
     */
    def /\(t: Set): Set =
        new Set(x => this.contains(x) && t.contains(x));

    /**
     * Difference
     */
    def -(t: Set): Set =
        new Set(x => this.contains(x) && !t.contains(x));

    def filter(p: Int => Boolean): Set =
        new Set(x => this.contains(x) && p(x));

    def forall(p: Int => Boolean): Boolean =
        -1000.to(1000)
             .forall(p);
}