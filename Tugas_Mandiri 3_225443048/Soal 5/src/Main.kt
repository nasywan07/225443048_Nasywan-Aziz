fun main() {
    val perpustakaan = Perpustakaan("Perpustakaan Digital Nusantara")

    val b1 = BukuFiksi("B001", "Laskar Pelangi", 2005, "Andrea Hirata", 529, "Drama")
    val b2 = BukuFiksi("B002", "Bumi", 2014, "Tere Liye", 440, "Petualangan")
    val b3 = BukuNonFiksi("B003", "Sapiens", 2011, "Yuval Noah Harari", 498, "Sejarah")
    val b4 = BukuNonFiksi("B004", "Atomic Habits", 2018, "James Clear", 320, "Pengembangan Diri")

    val m1 = MajalahHarian("M001", "National Geographic", 2023, 101, "Oktober", "Senin")
    val m2 = MajalahHarian("M002", "Kompas Harian", 2023, 45, "November", "Selasa")
    val m3 = MajalahMingguan("M003", "Tempo", 2023, 12, "Agustus", "Kamis")
    val m4 = MajalahMingguan("M004", "Gatra", 2023, 8, "September", "Jumat")

    perpustakaan.tambahItem(b1)
    perpustakaan.tambahItem(b2)
    perpustakaan.tambahItem(b3)
    perpustakaan.tambahItem(b4)
    perpustakaan.tambahItem(m1)
    perpustakaan.tambahItem(m2)
    perpustakaan.tambahItem(m3)
    perpustakaan.tambahItem(m4)

    perpustakaan.tampilkanSemuaItem()

    println("=== PEMINJAMAN ===")
    if (b1.dipinjam()) println("✅ Buku \"${b1.judul}\" berhasil dipinjam")
    if (m1.dipinjam()) println("✅ Majalah \"${m1.judul}\" berhasil dipinjam")
    println()

    perpustakaan.tampilkanItemDipinjam()
    perpustakaan.tampilkanItemTersedia()

    val hariTerlambat = 5
    val totalDenda = perpustakaan.hitungTotalDenda(hariTerlambat)

    println("=== TOTAL DENDA ($hariTerlambat hari terlambat) ===")
    val dendaFormatted = String.format("%,.0f", totalDenda).replace(',', '.')
    println("Total denda: Rp $dendaFormatted")
}