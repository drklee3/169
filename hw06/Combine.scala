object Combine {
  def add(x: Int, y: Int): Int = x + y;

  def square(x: Int): Int = x * x;

  def applyCombine(f: Int => Int, x: Int, g: (Int, Int) => Int): Int =
    if (x == 1) f(x)
    else g(f(x), applyCombine(f, x - 1, g));
  
  def applyCombine2(f: Int => Int): Int => (((Int, Int) => Int) => Int) =
    (x: Int) => {
      (g: (Int, Int) => Int) => {
        if (x == 1) f(x)
        else g(f(x), applyCombine2(f)(x - 1)(g))
      }
    };
  
  def applyCombine3(f: Int => Int)(x: Int)(g: (Int, Int) => Int): Int =
    if (x == 1) f(x)
    else g(f(x), applyCombine(f, x - 1, g));

  def main(args: Array[String]): Unit = {
    println(applyCombine(square, 4, add));
    println(applyCombine2(square)(4)(add));
    println(applyCombine3(square)(4)(add));
  }
}
