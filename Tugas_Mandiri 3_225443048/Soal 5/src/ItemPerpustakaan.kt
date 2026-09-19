open class ItemPerpustakaan(
    val id: String,
    val judul: String,
    val tahunTerbit: Int
) {
    var isDipinjam: Boolean = false
        private set

    fun dipinjam(): Boolean {
        return if (!isDipinjam) {
            isDipinjam = true
            true
        } else {
            false
        }
    }

    fun dikembalikan(): Boolean {
        return if (isDipinjam) {
            isDipinjam = false
            true
        } else {
            false
        }
    }

    open fun hitungDenda(hariTerlambat: Int): Double {
        return hariTerlambat * 1000.0
    }

    open fun tampilkanInfo() {
        println("ID     : $id")
        println("Judul  : $judul")
        println("Tahun  : $tahunTerbit")
        println("Status : ${if (isDipinjam) "Dipinjam" else "Tersedia"}")
    }
}