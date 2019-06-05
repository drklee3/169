object findLast {
    def findLast(xs: List[Int], x: Int): Int = {
        xs match {
            case Nil => -1
            case ys => if (x == ys.last) ys.length - 1
                       else findLast(ys.init, x)
        };
    }

    def main(args: Array[String]): Unit = {
        val l = List(1, 8, 4, 8, 10);

        println(findLast(l, 8));
        println(findLast(l, 7));
    }
}