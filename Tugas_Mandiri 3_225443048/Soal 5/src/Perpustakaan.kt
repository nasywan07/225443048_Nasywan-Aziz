class Perpustakaan(val nama: String) {
    private val koleksi: MutableList<ItemPerpustakaan> = mutableListOf()

    fun tambahItem(item: ItemPerpustakaan) {
        koleksi.add(item)
    }

    fun cariItem(keyword: String): List<ItemPerpustakaan> {
        val hasil = mutableListOf<ItemPerpustakaan>()
        for (item in koleksi) {
            if (item.judul.contains(keyword, ignoreCase = true) || item.id.contains(keyword, ignoreCase = true)) {
                hasil.add(item)
            }
        }
        return hasil
    }

    fun tampilkanSemuaItem() {
        println("==================================================")
        println("📚 ${nama.uppercase()}")
        println("==================================================")
        println()
        println("=== DAFTAR KOLEKSI ===")
        println()
        for (item in koleksi) {
            item.tampilkanInfo()
            println()
        }
    }

    fun tampilkanItemDipinjam() {
        println("=== ITEM DIPINJAM ===")
        for (item in koleksi) {
            if (item.isDipinjam) {
                val jenis = when (item) {
                    is BukuFiksi -> "Buku Fiksi"
                    is BukuNonFiksi -> "Buku Non-Fiksi"
                    is MajalahHarian -> "Majalah Harian"
                    is MajalahMingguan -> "Majalah Mingguan"
                    else -> "Item Perpustakaan"
                }
                println("- ${item.judul} ($jenis)")
            }
        }
        println()
    }

    fun tampilkanItemTersedia() {
        println("=== ITEM TERSEDIA ===")
        for (item in koleksi) {
            if (!item.isDipinjam) {
                val jenis = when (item) {
                    is BukuFiksi -> "Buku Fiksi"
                    is BukuNonFiksi -> "Buku Non-Fiksi"
                    is MajalahHarian -> "Majalah Harian"
                    is MajalahMingguan -> "Majalah Mingguan"
                    else -> "Item Perpustakaan"
                }
                println("- ${item.judul} ($jenis)")
            }
        }
        println()
    }

    fun hitungTotalDenda(hariTerlambat: Int): Double {
        var total = 0.0
        for (item in koleksi) {
            if (item.isDipinjam) {
                total += item.hitungDenda(hariTerlambat)
            }
        }
        return total
    }
}