class Member(
    val id: String,
    val name: String,
    private val email: String,
    private val phone: String
) {
    private val transactions = mutableListOf<Transaction>()

    val transactionCount: Int
        get() = transactions.size

    val totalFines: Double
        get() = transactions.sumOf { trx ->
            val currentStatus = trx.status
            if (currentStatus is Overdue) {
                currentStatus.daysLate * trx.item.calculateFinePerDay()
            } else {
                0.0
            }
        }

    val activeBorrows: Int
        get() = transactions.count { it.status is Borrowed }

    fun getEmail(): String = email
    fun getPhone(): String = phone

    fun borrowItem(item: item): Transaction? {
        if (activeBorrows >= 3) {
            println("Error: Anggota $name sudah mencapai batas maksimal peminjaman (maksimal 3 item).")
            return null
        }

        val generatedId = "TRX-${System.currentTimeMillis()}"
        val newTransaction = Transaction(generatedId, item, this)
        transactions.add(newTransaction)

        println("Sukses: Peminjaman '${item.title}' berhasil dicatat.")
        return newTransaction
    }

    fun returnItem(item: item, daysLate: Int = 0): Double {
        val foundTransaction = transactions.find { it.item.id == item.id && it.status is Borrowed }

        if (foundTransaction == null) {
            println("Error: Transaksi aktif untuk item '${item.title}' tidak ditemukan.")
            return -1.0
        }

        return foundTransaction.returnItem(daysLate)
    }

    fun getTransactions(): List<Transaction> = transactions.toList()

    fun displayInfo() {
        println("=== Informasi Anggota ===")
        println("ID           : $id")
        println("Nama         : $name")
        println("Email        : ${getEmail()}")
        println("Telepon      : ${getPhone()}")
        println("Total Pinjam : $transactionCount")
        println("Pinjam Aktif : $activeBorrows")
        println("Total Denda  : Rp ${totalFines.toInt()}")
    }

    fun displayTransactions() {
        println("=== Riwayat Transaksi Anggota ===")
        println("Anggota: $name ($id)")
        println("---------------------------------")
        if (transactions.isEmpty()) {
            println("Belum ada riwayat transaksi.")
        } else {
            transactions.forEachIndexed { index, trx ->
                println("${index + 1}. ID Transaksi : ${trx.id}")
                println("   Item         : ${trx.item.title} [${trx.item.getItemType()}]")
                println("   Tanggal      : ${trx.borrowDate}")
                println("   Status       : ${trx.status.display()}")

            }
        }
    }
}