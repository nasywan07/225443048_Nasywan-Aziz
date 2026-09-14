class Transaction(
    val id: String,
    val item: item,
    val member: Member
) {
    val borrowDate: String = java.time.LocalDate.now().toString()
    var status: TransactionStatus = Borrowed

    fun returnItem(daysLate: Int): Double {
        if (status.isFinal()) {
            println("Error: Transaksi sudah selesai dan tidak bisa diproses kembali.")
            return 0.0
        }

        val totalFine = item.returnItem(daysLate)

        status = if (daysLate > 0) {
            Overdue(daysLate)
        } else {
            Returned
        }

        return totalFine
    }

    fun cancel() {
        if (status.isFinal()) {
            println("Error: Transaksi tidak dapat dibatalkan karena sudah berstatus final.")
        } else {
            status = Cancelled
            item.returnItem(0)
        }
    }

    fun displayTransaction() {
        println("=== Informasi Transaksi ===")
        println("ID Transaksi : $id")
        println("Tanggal      : $borrowDate")
        println("Peminjam     : ${member.name} (${member.id})")
        println("Item         : ${item.title} [${item.getItemType()}]")
        println("Status       : ${status.display()}")
        println("===========================")
    }
}