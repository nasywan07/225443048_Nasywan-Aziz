open class Buku(
    id: String,
    judul: String,
    tahunTerbit: Int,
    val penulis: String,
    val jumlahHalaman: Int
) : ItemPerpustakaan(id, judul, tahunTerbit) {

    override fun hitungDenda(hariTerlambat: Int): Double {
        return hariTerlambat * 2000.0
    }

    override fun tampilkanInfo() {
        println("ID      : $id")
        println("Judul   : $judul")
        println("Penulis : $penulis")
        println("Tahun   : $tahunTerbit")
        println("Halaman : $jumlahHalaman")
    }
}