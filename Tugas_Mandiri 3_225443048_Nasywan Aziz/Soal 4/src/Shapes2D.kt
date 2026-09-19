class Circle(val jariJari: Double) : TwoDimensionalShape("Circle") {
    val pi = 3.141592653589793

    override fun luas(): Double = pi * jariJari * jariJari
    override fun keliling(): Double = 2 * pi * jariJari
}

class Rectangle(val panjang: Double, val lebar: Double) : TwoDimensionalShape("Rectangle") {
    override fun luas(): Double = panjang * lebar
    override fun keliling(): Double = 2 * (panjang + lebar)
}

class Triangle(
    val alas: Double,
    val tinggi: Double,
    val sisiA: Double,
    val sisiB: Double,
    val sisiC: Double
) : TwoDimensionalShape("Triangle") {
    override fun luas(): Double = 0.5 * alas * tinggi
    override fun keliling(): Double = sisiA + sisiB + sisiC
}