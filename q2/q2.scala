object q2 {
    def range(xs: List[Int], start: Int, end: Int):List[Int] = {
        // if i < start, continue 
        def skip(xs: List[Int], i: Int):List[Int] ={
            if (xs.isEmpty) Nil
            else if (i < start) skip(xs.tail, i+1)
            else if (i < end) xs.head :: skip(xs.tail, i+1)
            else Nil
        }
        skip(xs, 0)
    }

    def avg(xs: List[Int]): Int = {
        def sum(xs: List[Int]): Int = {
            if (xs.isEmpty) 0
            else xs.head + sum(xs.tail)
        }
        sum(xs) / xs.length
    }

    def applyrange(xs: List[Int], start: Int, end:Int, f:Int=>Int):List[Int] = {
        // if i < start, continue 
        def skip(xs: List[Int], i:Int):List[Int] ={
            if (xs.isEmpty) Nil
            else if (i < start || i > end) xs.head::skip(xs.tail, i+1)
            //assume inclusive of end
            else f(xs.head)::skip(xs.tail, i+1)
        }
        skip(xs, 0)
    }

    def curryrange(f:Int=>Int): (List[Int], Int, Int) => List[Int] = {
        def inner(xs: List[Int], start:Int, end:Int): List[Int] = {
            def skip(xs: List[Int], i:Int):List[Int] ={
                if (xs.isEmpty) Nil
                else if (i < start || i > end) xs.head::skip(xs.tail, i+1)
                //assume inclusive of end
                else f(xs.head)::skip(xs.tail, i+1)
            }

            skip(xs, 0)
        }

        inner
    }

    def curryrange2(f:Int=>Int): (List[Int], Int, Int)=>List[Int] = {
        (xs: List[Int], start:Int, end:Int) => {
            def skip(xs: List[Int], i:Int):List[Int] ={
                if (xs.isEmpty) Nil
                else if (i < start || i > end) xs.head::skip(xs.tail, i+1)
                //assume inclusive of end
                else f(xs.head)::skip(xs.tail, i+1)
            }

            skip(xs, 0)
        }
    }

    def double(f: Int => Int): Int => Int =
        x => f(f(x));
    
    def compose(f: Int => Int, g: Int => Int): Int => Int =
        x => f(g(x));
    
    def composeCurry(f: Int => Int): (Int => Int) => Int => Int =
        g => x => f(g(x));

    
    def square(x: Int) = x * x;

    def inc(x: Int) = x + 1;

    def main(args: Array[String]): Unit = {
        //println(range(List(1, 2, 3, 4, 5), 2, 4));

        //println(avg(List(2,3,4)));

        println(applyrange(List(1,3,5,2,4,10,15), 2, 4, (x:Int) => x * x));

        println(composeCurry(square)(inc)(6));
    }
}
