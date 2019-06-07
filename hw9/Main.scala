object Main {
    /**
     * Returns index of last instance of x in xs
     */
    def findLast(xs: List[Int], x: Int): Int = {
        xs match {
            case Nil => -1 // end of list / edge case of empty list
            case y :: ys => {
                val i = findLast(ys, x);

                if (i != -1) i + 1 // if it does exist
                else if (y == x) 0 // has to be after i != 1, last occurrence
                else -1            // still doesn't exist, -1
            }
        };
    }

    def findLast2(xs: List[Int], x: Int): Int = {
        xs match {
            case Nil => -1
            case ys => if (x == ys.last) ys.length - 1
                       else findLast2(ys.init, x)
        };
    }

    /**
     * Returns a list containing all of the sets in ss that are subsets of s
     */
    def subs[T <: mySet](s: T, ss: List[T]): List[T] =
        ss match {
            case Nil => Nil
            case x :: xs =>
                // this requires f in Set to be a val!! not sure if we can do that
                if (x.forall(s.f)) x :: subs(s, xs)
                else subs(s, xs)
        };

    def main(args: Array[String]): Unit = {
        // [#2] BSTree
        val t1 = Node(5, Leaf, Leaf); // 5
        val t2 = t1.insert(4);        // 4, 5
        val t3 = Node(4, Leaf, Leaf); // 4
        val t4 = t2.insert(6)
                   .insert(8);        // 4, 5, 6, 8
        val t5 = Node(6, Leaf, Leaf)  // 6
        val t6 = t5.insert(8);        // 6, 8

        println("t1: " + t1); // {.5.}
        println("t2: " + t2); // {{.4.}5.}
        println("t3: " + t3); // {.4.}
        println("t4: " + t4); // {{.4.}5{.6{.8.}}}
        println("t5: " + t5); // {.6.}
        println("t6: " + t6); // {.6{.8.}}

        // depth
        println(t2.depth);

        // exactSubtree
        println("t1 substree of t3: " + t1.exactSubtree(t3)); // false
        println("t1 substree of t2: " + t1.exactSubtree(t2)); // false
        println("t3 substree of t2: " + t3.exactSubtree(t2)); // true
        println("t5 substree of t4: " + t5.exactSubtree(t4)); // false
        println("t6 substree of t4: " + t6.exactSubtree(t4)); // true


        // [#3] findlast
        val l = List(1, 8, 4, 8, 10);

        println(findLast(l, 8)); // 3
        println(findLast(l, 7)); // -1

        println(findLast2(l, 8)); // 3
        println(findLast2(l, 7)); // -1

        // [#4] singleton set testing
        val ss1 = new singletonSet(1);
        val ss2 = new singletonSet(2);
        val ss3 = new singletonSet(3);
        val ss6 = new singletonSet(6);

        // using a List and contains just to make it easier to make larger sets
        val s1 = new mySet(x => List(3, 4, 5                  ).contains(x));
        val s2 = new mySet(x => List(1, 2, 3, 4, 5            ).contains(x));
        val s3 = new mySet(x => List(1, 2, 3, 4, 5, 6, 7, 8, 9).contains(x));

        // list of sets
        val ss = ss1 :: ss2 :: ss3 :: ss6 :: s1 :: s2 :: s3 :: Nil;

        println(subs(s2, ss)); // [1], [2], [3], [3, 4, 5], [1, 2, 3, 4, 5]

        // [#5] groupoid testing
        val gs1 = new mySet(x => List(0, 1, 2, 3, 4, 5).contains(x));
        val g1 = new Groupoid(gs1, (x, y) => (x + y) % 5);
        val g2 = new Groupoid(gs1, (x, y) => (x + y) % 7);

        println(g1.closed); // true
        println(g2.closed); // false
    }
}