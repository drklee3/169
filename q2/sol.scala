object sol {
    def halve(xs: List[Int]): List[Int] =
        if (xs.isEmpty || xs.length == 1) Nil
        else if (xs.length <= 3) List(xs.head)
        else xs.head :: halve(xs.tail.tail);
    
    def main(args: Array[String]): Unit = {
        println(halve(List(1,2,3,4,5,6,7,8,9)));
    }
}