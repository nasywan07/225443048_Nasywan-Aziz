class Library {
    private val items = mutableListOf<item>()
    private val members = mutableListOf<Member>()

    fun addItem(item: item) {
        items.add(item)
        println("Sukses: ${item.getItemType()} '${item.title}' berhasil ditambahkan ke perpustakaan.")
    }

    fun addMember(member: Member) {
        members.add(member)
        println("Sukses: Anggota baru '${member.name}' berhasil terdaftar.")
    }

    fun borrowItem(memberId: String, itemId: String): Transaction? {
        val member = members.find { it.id == memberId }
        if (member == null) {
            println("Error: Anggota dengan ID '$memberId' tidak ditemukan.")
            return null
        }

        val targetItem = items.find { it.id == itemId }
        if (targetItem == null) {
            println("Error: Item dengan ID '$itemId' tidak ditemukan.")
            return null
        }

        val trx = member.borrowItem(targetItem)
        if (trx != null) {
            targetItem.borrow()
        }
        return trx
    }

    fun returnItem(memberId: String, itemId: String, daysLate: Int = 0): Double {
        val member = members.find { it.id == memberId }
        if (member == null) {
            println("Error: Anggota dengan ID '$memberId' tidak ditemukan.")
            return 0.0
        }

        val targetItem = items.find { it.id == itemId }
        if (targetItem == null) {
            println("Error: Item dengan ID '$itemId' tidak ditemukan.")
            return 0.0
        }

        val fine = member.returnItem(targetItem, daysLate)
        if (fine >= 0.0) {
            targetItem.returnItem(daysLate)
        }
        return fine
    }

    fun displayAllItems() {
        println("\n==================================")
        println("     DAFTAR ITEM PERPUSTAKAAN     ")
        println("==================================")
        if (items.isEmpty()) {
            println("Perpustakaan tidak memiliki koleksi barang.")
        } else {
            items.forEach { it.displayInfo() }
        }
    }

    fun displayAllMembers() {
        println("\n==================================")
        println("    DAFTAR ANGGOTA PERPUSTAKAAN   ")
        println("==================================")
        if (members.isEmpty()) {
            println("Belum ada anggota yang terdaftar.")
        } else {
            members.forEach { it.displayInfo() }
        }
    }

    fun displayAllTransactions() {
        println("\n==================================")
        println("    SEMUA TRANSAKSI PERPUSTAKAAN  ")
        println("==================================")
        var totalTransaksi = 0
        members.forEach { member ->
            val userTransactions = member.getTransactions()
            if (userTransactions.isNotEmpty()) {
                userTransactions.forEach { trx ->
                    totalTransaksi++
                    println("$totalTransaksi. ID Transaksi : ${trx.id}")
                    println("   Peminjam     : ${member.name} (${member.id})")
                    println("   Item         : ${trx.item.title} [${trx.item.getItemType()}]")
                    println("   Status       : ${trx.status.display()}")
                    println("----------------------------------")
                }
            }
        }
        if (totalTransaksi == 0) {
            println("Belum ada catatan aktivitas transaksi apa pun.")
        }
    }
}