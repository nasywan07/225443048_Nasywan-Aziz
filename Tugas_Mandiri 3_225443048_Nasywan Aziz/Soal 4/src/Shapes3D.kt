class Cube(val sisi: Double) : ThreeDimensionalShape("Cube") {
    override fun luas(): Double = 6 * sisi * sisi
    override fun volume(): Double = sisi * sisi * sisi
}

class Sphere(val jariJari: Double) : ThreeDimensionalShape("Sphere") {
    val pi = 3.141592653589793

    override fun luas(): Double = 4 * pi * jariJari * jariJari
    override fun volume(): Double = (4.0 / 3.0) * pi * jariJari * jariJari * jariJari
}