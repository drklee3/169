object Main {
    /**
     * [#1] mimics the behavior of a typical procedural loop.
     *
     * Most important shortcoming compared to a C++ for loop is:
     * (not tail-call optimization)
     * maybe the parameters aren't generic?
     */
    def forLoop(
        i: Int,
        cond: Int => Boolean,
        inc: Int => Int
    )(
        body: => Unit
    ): Unit =
        if (cond(i)) {
            body;
            forLoop(inc(i), cond, inc)(body);
        };
    
    def singletonSet(elem: Int): Int => Boolean =
        (x: Int) => x == elem;

    def contains(set: Int => Boolean, elem: Int): Boolean =
        set(elem);

    def union(s1: Int => Boolean, s2: Int => Boolean): Int => Boolean =
        x => contains(s1, x) || contains(s2, x);
    
    def intersect(s1: Int => Boolean, s2: Int => Boolean): Int => Boolean =
        x => contains(s1, x) && contains(s2, x);
    
    def diff(s1: Int => Boolean, s2: Int => Boolean): Int => Boolean =
        x => contains(s1, x) && !contains(s2, x);
    
    /**
     * [#2a]
     */
    def setList(sets: List[Int]): Int => Boolean =
        sets.map(singletonSet(_))
            .reduce((x, y) => union(x, y));
    
    /**
     * [#2b]
     */
    def filter(s: Int => Boolean, p: Int => Boolean): Int => Boolean =
        intersect(s, p);
    
    /**
     * [#2c] 
     */
    def forall(s: Int => Boolean, p: Int => Boolean): Boolean =
        -1000.to(1000)
             .exists(p);

    def main(args: Array[String]): Unit = {
        forLoop(10, x => x > 0, x => x - 1) {
            println("Hello World");
        };
    }
}