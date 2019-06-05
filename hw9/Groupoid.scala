class Groupoid[T <: mySet](s: T, op: (Int, Int) => Int) {
    // if op applied to applied to any 2 elements, it is also in s
    // question is how to apply op if we don't have any way to actually get
    // values in a set unless we brute force it
    // something with forall but we still can't use values in the set

    // essentially a nested for loop that iterates all pairs
    // then we check when op is applied to each pair if the result is in s
    val closed: Boolean =
        s.forall(x => s.forall(y => s.contains(op(x, y))));
}