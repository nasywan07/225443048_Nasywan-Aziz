fun main() {
    val library = Library()

    val book1 = Book("Budi Santoso", 350, "Programming", "B001", "Pemrograman Kotlin", 2023)
    val book2 = Book("Siti Rahayu", 280, "Education", "B002", "Dasar-Dasar OOP", 2022)

    val journal1 = Journal("ITB", 15, 2, "J001", "Jurnal Teknologi Informasi", 2023)
    val journal2 = Journal("UGM", 10, 1, "J002", "Jurnal Pendidikan", 2022)

    val dvd1 = DVD("Christopher Nolan", 148, "Sci-Fi", "D001", "Inception", 2010)
    val dvd2 = DVD("Wachowski", 136, "Action", "D002", "The Matrix", 1999)

    library.addItem(book1)
    library.addItem(book2)
    library.addItem(journal1)
    library.addItem(journal2)
    library.addItem(dvd1)
    library.addItem(dvd2)

    val member1 = Member("M001", "Ahmad Fauzi", "ahmad@email.com", "08123456789")
    val member2 = Member("M002", "Dewi Lestari", "dewi@email.com", "08129876543")
    val member3 = Member("M003", "Rizky Pratama", "rizky@email.com", "08125678901")

    library.addMember(member1)
    library.addMember(member2)
    library.addMember(member3)

    println("\n--- Tampilan Daftar Seluruh Item ---")
    library.displayAllItems()

    println("\n--- Tampilan Daftar Seluruh Anggota ---")
    library.displayAllMembers()

    println("\n--- Simulasi Alur Proses Peminjaman ---")
    library.borrowItem("M001", "B001")
    library.borrowItem("M001", "J001")
    library.borrowItem("M002", "B001")

    println("\n--- Status Koleksi Setelah Dipinjam ---")
    library.displayAllItems()

    println("\n--- Simulasi Alur Proses Pengembalian ---")
    library.returnItem("M001", "B001", daysLate = 0)
    library.returnItem("M001", "J001", daysLate = 3)

    println("\n--- Laporan Riwayat Transaksi Perpustakaan ---")
    library.displayAllTransactions()
}