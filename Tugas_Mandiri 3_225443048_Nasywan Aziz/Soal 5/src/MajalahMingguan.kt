class MajalahMingguan(
    id: String,
    judul: String,
    tahunTerbit: Int,
    edisi: Int,
    bulanTerbit: String,
    val hariTerbit: String
) : Majalah(id, judul, tahunTerbit, edisi, bulanTerbit) {

    override fun hitungDenda(hariTerlambat: Int): Double {
        return hariTerlambat * 700.0
    }

    override fun tampilkanInfo() {
        println("[Majalah Mingguan] ID: $id")
        println("Judul   : $judul")
        println("Edisi   : $edisi")
        println("Bulan   : $bulanTerbit")
        println("Hari    : $hariTerbit")
        println("Tahun   : $tahunTerbit")
        println("Status  : ${if (isDipinjam) "Dipinjam" else "Tersedia"}")
    }
}