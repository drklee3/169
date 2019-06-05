object Main {
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
        val ss1 = new singletonSet(1);
        val ss2 = new singletonSet(2);
        val ss3 = new singletonSet(3);
        val ss6 = new singletonSet(6);

        // using a List and contains just to make it easier to make larger sets
        val s1 = new mySet(x => List(3, 4, 5).contains(x));
        val s2 = new mySet(x => List(1, 2, 3, 4, 5).contains(x));
        val s3 = new mySet(x => List(1, 2, 3, 4, 5, 6, 7, 8, 9).contains(x));

        // list of sets
        val ss = ss1 :: ss2 :: ss3 :: ss6 :: s1 :: s2 :: s3 :: Nil;

        println(subs(s2, ss));
    }
}