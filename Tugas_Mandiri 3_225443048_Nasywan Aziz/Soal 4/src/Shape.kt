open class Shape(val name: String) {
    open fun luas(): Double = 0.0
    open fun keliling(): Double = 0.0
    open fun volume(): Double = 0.0

    open fun tampilkanInfo() {
        println("=== $name ===")
        println("Luas     : ${"%.2f".format(luas())}")
        println("Keliling : ${"%.2f".format(keliling())}")
        println("Volume   : ${"%.2f".format(volume())}")
    }
}