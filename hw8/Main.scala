object Main {
    /**
     * [#1] mimics the behavior of a typical procedural loop.
     *
     * Most important shortcoming compared to a C++ for loop is:
     * the parameters are required and aren't generic (they must be
     * Int => Boolean and Int => Int) making it more restrictive
     *
     * (not memory usage because of tail-call optimization, it won't run into a
     * stack overflow or have unnecessary overhead as the compiler will optimize
     * the recursive tail call into a while loop, preventing the need for stack
     * usage)
     */
    def forLoop(
        i: Int,
        cond: Int => Boolean,
        inc: Int => Int,
    )(
        body: => Unit,
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
     * [#2a] recursive method of set consisting of all Ints in provided List
     */
    def setList(sets: List[Int]): Int => Boolean =
        if (sets.isEmpty) x => false // base case, empty set
        else union(singletonSet(sets.head), setList(sets.tail));

    /**
     * iterative method w/ map & reduce of #2a
     */
    def setListM(sets: List[Int]): Int => Boolean =
        sets.map(singletonSet(_))
            .reduce(union(_, _));
    
    /**
     * [#2b] Creates a set with elements of s that satisfy p
     */
    def filter(s: Int => Boolean, p: Int => Boolean): Int => Boolean =
        intersect(s, p);
    
    /**
     * literally just the intersect body
     */
    def filterR(s: Int => Boolean, p: Int => Boolean): Int => Boolean =
        x => contains(s, x) && contains(p, x);
    
    /**
     * [#2c] Recursive function to test if p is true for all elements of s
     * 
     * Short circuits when there is an element in s that is false for p
     * instead of doing p(x) && apply(x + 1) which will check all values even if
     * it finds a false
     */
    def forall(s: Int => Boolean, p: Int => Boolean): Boolean = {
        def apply(x: Int): Boolean =
            if (x > 1000) true                     // reached the end
            else if (!contains(s, x)) apply(x + 1) // not in set, next value
            else if (p(x)) apply(x + 1)            // in set, true  for p
            else false;                            // in set, false for p

        apply(-1000)
    };

    /**
     * Iterative forall function
     */
    def forallI(s: Int => Boolean, p: Int => Boolean): Boolean =
        -1000.to(1000)
             .filter(s)
             .forall(p);
    
    /**
     * Prints the values in a set
     */
    def printSet(s: Int => Boolean): Unit =
        println(-1000.to(1000)
                     .filter(s)
                     .mkString(", "));

    def main(args: Array[String]): Unit = {
        forLoop(10, x => x > 0, x => x - 1) {
            println("Hello World");
        };

        val l1 = setList(List(1, 3, 5, 9, 11));
        val l2 = setList(List(1, 3, 5, 9, 11, 12));

        printSet(l1);
        printSet(l2);

        println(forall(l1, x => x % 2 == 1)); // true
        println(forall(l2, x => x % 2 == 1)); // false
    }
}