open class Kucing(nama: String, umur: Int) : Hewan(nama,umur) {
    override val jenis: String = "Kucing"

    final override fun suara() {
        println("Meong! Meong!")
    }

    override fun info() {
        super.info()
        println()
    }
}
class KucingAnggora(nama: String, umur: Int) : Kucing(nama, umur) {
}