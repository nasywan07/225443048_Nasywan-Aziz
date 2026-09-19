open class Majalah(
    id: String,
    judul: String,
    tahunTerbit: Int,
    val edisi: Int,
    val bulanTerbit: String
) : ItemPerpustakaan(id, judul, tahunTerbit) {

    override fun hitungDenda(hariTerlambat: Int): Double {
        return hariTerlambat * 500.0
    }

    override fun tampilkanInfo() {
        println("ID     : $id")
        println("Judul  : $judul")
        println("Edisi  : $edisi")
        println("Bulan  : $bulanTerbit")
        println("Tahun  : $tahunTerbit")
    }
}