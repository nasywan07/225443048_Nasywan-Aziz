class Sapi(nama: String, umur: Int) : Hewan(nama, umur) {
    override val jenis: String = "Sapi"

    override fun suara() {
        println("Mooo!")
    }

    override fun info() {
        super.info()
        println()
    }
}