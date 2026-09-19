class Anjing(nama: String, umur: Int) : Hewan(nama, umur) {
    override val jenis: String = "Anjing"

    override fun suara() {
        println("Guk! Guk!")
    }

    override fun info() {
        super.info()
        println()
    }
}