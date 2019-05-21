object Main {
    /**
     * [#1] Merges two Lists in alternating order with extra elements at the end
     */
    def alternateList(a: List[Int], b: List[Int]): List[Int] =
        a.zip(b)
         .flatMap(x => List(x._1, x._2)) ++ {
            if (a.length > b.length) a.takeRight(a.length - b.length)
            else                     b.takeRight(b.length - a.length)
        };
    
    /**
     * Alternative way for #1 with zipAll and without concatenation but with
     * more iterations
     */
    def alternateListZ(a: List[Int], b: List[Int]): List[Int] = {
        a.map(Option(_))
         .zipAll(b.map(Option(_)), None, None)
         .flatMap(x => List(x._1, x._2))
         .flatten // get values out of Option(T)s (also removes Nones)
    };

    /**
     * Another alternative way for #1 by applying zipWithIndex on both Lists,
     * sorting the combined list by the indexes then getting the value back.
     * This only works because sortBy is stable.
     */
    def alternateListM(a: List[Int], b: List[Int]): List[Int] =
        List(a, b)
            .flatMap(_.zipWithIndex) // merges a and b with (val, index)
            .sortBy(_._2)            // sorts based on index
            .map(_._1);              // get the value instead of tuples
    
    
    /**
     * [#2] Applies f to corresponding elements of xs and ys
     */
    def applyList(
        xs: List[Int],
        ys: List[Int],
        f: (Int, Int) => Int,
    ): List[Int] =
        xs.zip(ys)
          .map(t => f(t._1, t._2));
    
    /**
     * Alternative recursive way for #2
     */
    def applyListR(
        xs: List[Int],
        ys: List[Int],
        f: (Int, Int) => Int,
    ): List[Int] =
        if (xs.isEmpty || ys.isEmpty) Nil
        else f(xs.head, ys.head) ::
            applyListR(xs.drop(1), ys.drop(1), f);

    
    /**
     * [#3] Filters a list based on items tested with f
     */
    def filterList(xs: List[Int], f: Int => Boolean): List[Int] =
        xs.filter(f);
    
    /**
     * Alternative recursive way for #3 
     */
    def filterListR(xs: List[Int], f: Int => Boolean): List[Int] =
        if (xs.isEmpty) List()
        else if (f(xs.head)) xs.head :: filterListR(xs.drop(1), f)
        else filterListR(xs.drop(1), f);
    
    /**
     * [#4] Curried version of #3
     */
    def filterList2(f: Int => Boolean): List[Int] => List[Int] =
        (xs) => xs.filter(f);
    
    /**
     * Prints variable number of Lists converted to strings
     */
    def printLists(lists: List[Int]*): Unit =
        lists.map(_.mkString(", "))
             .foreach(println);

    def main(args: Array[String]): Unit = {
        // #1 inputs
        val arr1 = List(1, 2, 3, 4);
        val arr2 = List(7, 8, 9, 10, 11, 12);

        // #2 inputs
        val xs = List(3, 8, 1, 5);
        val ys = List(12, 6, 23, 1, 8, 4);

        // #3 inputs
        val xs2 = 1.to(20).toList;

        printLists(
            // #1
            alternateList (arr1, arr2),
            alternateListZ(arr1, arr2),
            alternateListM(arr1, arr2),

            alternateList (arr2, arr1),
            alternateListZ(arr2, arr1),
            alternateListM(arr2, arr1),

            // #2
            applyList (xs, ys, (x, y) => x + y    ),
            applyListR(xs, ys, (x, y) => x + y    ),

            applyList (xs, ys, (x, y) => x * x + y),
            applyListR(xs, ys, (x, y) => x * x + y),

            // #3
            filterList (xs2, x => x % 2 == 0),
            filterListR(xs2, x => x % 2 == 0),

            filterList (xs2, x => x > 10    ),
            filterListR(xs2, x => x > 10    ),

            // #4
            filterList2(x => x % 2 == 0)(xs2),
            filterList2(x => x > 10    )(xs2),
        );
    }
}