class singletonSet(elem: Int) extends mySet(x => x == elem) {
    //This class creates a set with only one element, elem.
    //Now that we have a set with only one element, we can do better with
    //forall.  Implement this functions to work for ALL integers,
    //not just those in the range -1000 to 1000
    override def forall(p: Int => Boolean): Boolean = p(elem);

    override def toString = "[" + elem.toString + "]";
}
