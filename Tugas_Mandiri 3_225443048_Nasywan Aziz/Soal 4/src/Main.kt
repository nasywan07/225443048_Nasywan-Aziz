fun main() {
    val circle = Circle(5.0)
    val rectangle = Rectangle(10.0, 5.0)
    val cube = Cube(4.0)

    circle.tampilkanInfo()
    println()
    rectangle.tampilkanInfo()
    println()
    cube.tampilkanInfo()
    println()

    val shapes2D: List<TwoDimensionalShape> = listOf(circle, rectangle)
    val shapes3D: List<ThreeDimensionalShape> = listOf(cube)

    var totalLuas2D = 0.0
    for (shape in shapes2D) {
        totalLuas2D += shape.luas()
    }

    var totalVolume3D = 0.0
    for (shape in shapes3D) {
        totalVolume3D += shape.volume()
    }

    println("Total Luas Bangun 2D: ${"%.2f".format(totalLuas2D)}")
    println("Total Volume Bangun 3D: ${"%.2f".format(totalVolume3D)}")
}