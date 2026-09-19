open class Hewan(
    open val nama : String,
    open val umur : Int,

    ) {
    open val jenis : String ="hewan"

    open fun suara(){
        println("$nama Bersuara")
    }
    open fun info() {
        println("Nama: $nama")
        println("Umur: $umur tahun")
        println("Jenis: $jenis")
    }
}