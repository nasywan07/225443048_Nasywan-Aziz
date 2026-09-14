abstract class item(
    val id: String,
    val title: String,
    val year: Int
) {
    var isAvailable: Boolean = true
        private set

    abstract fun calculateFinePerDay(): Double
    abstract fun getItemType(): String
    abstract fun getMaxBorrowDays(): Int

    fun borrow(): Boolean {
        if (isAvailable) {
            isAvailable = false
            println("Peminjaman ${getItemType()} '$title' Berhasil")
            return true
        } else {
            println("Error: ${getItemType()} '$title' sedang tidak tersedia (sedang dipinjam).")
            return false
        }
    }

    fun returnItem(daysLate: Int = 0): Double {
        if (isAvailable) {
            return 0.0
        }

        isAvailable = true
        val totalFine = daysLate * calculateFinePerDay()

        println("Sukses mengembalikan ${getItemType()} '$title'.")
        if (totalFine > 0) {
            println("Total denda keterlambatan ($daysLate hari): Rp ${totalFine.toInt()}")
        }
        return totalFine
    }

    open fun displayInfo() {
        val statusText = if (isAvailable) "Tersedia" else "Dipinjam"
        println("===== Informasi =====")
        println("Id : $id")
        println("Judul : $title")
        println("Tahun : $year")
        println("Status : $statusText")
        println("Denda : RP ${calculateFinePerDay().toInt()}")
        println("Maks Pinjaman : ${getMaxBorrowDays()} hari")
    }
}