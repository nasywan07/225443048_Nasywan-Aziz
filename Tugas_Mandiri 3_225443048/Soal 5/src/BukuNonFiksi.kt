class BukuNonFiksi(
    id: String,
    judul: String,
    tahunTerbit: Int,
    penulis: String,
    jumlahHalaman: Int,
    val bidang: String
) : Buku(id, judul, tahunTerbit, penulis, jumlahHalaman) {

    override fun tampilkanInfo() {
        println("[Buku Non-Fiksi] ID: $id")
        println("Judul   : $judul")
        println("Penulis : $penulis")
        println("Tahun   : $tahunTerbit")
        println("Halaman : $jumlahHalaman")
        println("Bidang  : $bidang")
        println("Status  : ${if (isDipinjam) "Dipinjam" else "Tersedia"}")
    }
}