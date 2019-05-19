object Main {
    /**
     * [#1] Merges two Lists in alternating order with extra elements at the end
     */
    def alternateList(a: List[Int], b: List[Int]): List[Int] =
        a.zip(b).flatMap(x => List(x._1, x._2)) ++ {
            if (a.length > b.length) a.takeRight(a.length - b.length)
            else b.takeRight(b.length - a.length)
        };
    
    /**
     * [#2] Applies f to corresponding elements of xs and ys
     */
    def applyList(xs: List[Int],
        ys: List[Int],
        f: (Int, Int) => Int
    ): List[Int] =
        xs.zip(ys)
         .map(t => f(t._1, t._2));
    
    /**
     * [#3] Filters a list based on items tested with f
     */
    def filterList(xs: List[Int], f: Int => Boolean): List[Int] =
        xs.filter(f);
    
    /**
     * [#4] Curried version of #3
     */
    def filterList2(f: Int => Boolean): List[Int] => List[Int] =
        (xs) => xs.filter(f);

    def main(args: Array[String]): Unit = {
        // #1
        val arr1 = List(1, 2, 3, 4);
        val arr2 = List(7, 8, 9, 10, 11, 12);

        println(alternateList(arr1, arr2).mkString(", "));
        println(alternateList(arr2, arr1).mkString(", "));

        // #2
        val xs = List(3, 8, 1, 5);
        val ys = List(12, 6, 23, 1, 8, 4);

        println(applyList(xs, ys, (x, y) => x + y    ).mkString(", "));
        println(applyList(xs, ys, (x, y) => x * x + y).mkString(", "));

        // #3
        val xs2 = 1.to(20).toList;
        println(filterList(xs2, x => x % 2 == 0).mkString(", "));
        println(filterList(xs2, x => x > 10    ).mkString(", "));

        // #4
        println(filterList2(x => x % 2 == 0)(xs2).mkString(", "));
        println(filterList2(x => x > 10    )(xs2).mkString(", "));
    }
}