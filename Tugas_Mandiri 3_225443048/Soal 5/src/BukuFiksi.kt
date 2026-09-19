class BukuFiksi(
    id: String,
    judul: String,
    tahunTerbit: Int,
    penulis: String,
    jumlahHalaman: Int,
    val genre: String
) : Buku(id, judul, tahunTerbit, penulis, jumlahHalaman) {

    override fun tampilkanInfo() {
        println("[Buku Fiksi] ID: $id")
        println("Judul   : $judul")
        println("Penulis : $penulis")
        println("Tahun   : $tahunTerbit")
        println("Halaman : $jumlahHalaman")
        println("Genre   : $genre")
        println("Status  : ${if (isDipinjam) "Dipinjam" else "Tersedia"}")
    }
}