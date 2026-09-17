
sealed class StatusPengiriman {
    object MenungguDiproses : StatusPengiriman()
    data class DalamPerjalanan(val namaKurir: String) : StatusPengiriman()
    data class Terkirim(val namaPenerima: String, val waktuSelesai: String) : StatusPengiriman()
    data class Gagal(val alasan: String) : StatusPengiriman()
}

open class Paket(
    val nomorResi: String,
    val pengirim: String,
    val penerima: String,
    val beratKg: Double
) {
    var status: StatusPengiriman = StatusPengiriman.MenungguDiproses
        private set

    open fun hitungBiaya(): Double {
        return beratKg * 10000.0
    }

    fun updateStatus(statusBaru: StatusPengiriman) {
        this.status = statusBaru
    }


    open fun tampilkanInfo() {
        val statusDetail = when (val s = status) {
            is StatusPengiriman.MenungguDiproses -> "Menunggu Diproses"
            is StatusPengiriman.DalamPerjalanan -> "Dalam Perjalanan (Kurir: ${s.namaKurir})"
            is StatusPengiriman.Terkirim -> "Terkirim (Penerima: ${s.namaPenerima}, Waktu: ${s.waktuSelesai})"
            is StatusPengiriman.Gagal -> "Gagal (Alasan: ${s.alasan})"
        }

        println("Nomor Resi   : $nomorResi")
        println("Pengirim     : $pengirim")
        println("Penerima     : $penerima")
        println("Berat        : $beratKg kg")
        println("Status Paket : $statusDetail")
        println("Biaya Kirim  : Rp ${hitungBiaya().toInt()}")
    }
}

class PaketReguler(
    nomorResi: String,
    pengirim: String,
    penerima: String,
    beratKg: Double
) : Paket(nomorResi, pengirim, penerima, beratKg)

class PaketEkspres(
    nomorResi: String,
    pengirim: String,
    penerima: String,
    beratKg: Double,
    val biayaAsuransi: Double
) : Paket(nomorResi, pengirim, penerima, beratKg) {

    override fun hitungBiaya(): Double {
        return (beratKg * 15000.0) + biayaAsuransi
    }
}

class PaketFragile(
    nomorResi: String,
    pengirim: String,
    penerima: String,
    beratKg: Double,
    val biayaPackingKayu: Double
) : Paket(nomorResi, pengirim, penerima, beratKg) {

    override fun hitungBiaya(): Double {
        return (beratKg * 12000.0) + biayaPackingKayu
    }
}

class EkspedisiManager {
    private val daftarPaket: MutableList<Paket> = mutableListOf()

    fun terimaPaket(paket: Paket) {
        daftarPaket.add(paket)
        println("-> Paket dengan resi ${paket.nomorResi} berhasil dimasukkan ke sistem.")
    }

    fun lacakPaket(resi: String) {
        val paket = daftarPaket.find { it.nomorResi == resi }
        if (paket != null) {
            println("\n==========================================")
            println("        HASIL PELACAKAN RESI $resi")
            println("==========================================")
            paket.tampilkanInfo()

            when (paket) {
                is PaketEkspres -> {
                    println("[FITUR EKSPRES] Dilindungi asuransi sebesar Rp ${paket.biayaAsuransi.toInt()}")
                }
                is PaketFragile -> {
                    println("[FITUR FRAGILE] Dilindungi packing kayu seharga Rp ${paket.biayaPackingKayu.toInt()}")
                }
                is PaketReguler -> {
                    println("[INFO] Paket merupakan pengiriman standar.")
                }
            }
        } else {
            println("\n[!] Paket dengan nomor resi $resi tidak ditemukan.")
        }
    }

    fun tampilkanSemuaPaket() {
        println("\n==========================================")
        println("          DAFTAR SELURUH PAKET            ")
        println("==========================================")
        if (daftarPaket.isEmpty()) {
            println("Belum ada paket yang terdaftar.")
            return
        }
        for ((index, paket) in daftarPaket.withIndex()) {
            println("\n--- Paket #${index + 1} ---")
            paket.tampilkanInfo()
        }
    }

    fun hitungTotalPendapatan(): Double {
        return daftarPaket.sumOf { it.hitungBiaya() }
    }
}

fun main() {
    val manager = EkspedisiManager()

    println("=== 1. MENAMBAHKAN PAKET KE SISTEM ===")
    // 2. Membikin minimal 4 objek paket yang berbeda
    val paket1 = PaketReguler("REG-001", "Budi (Jakarta)", "Andi (Bandung)", 2.0)
    val paket2 = PaketReguler("REG-002", "Siti (Surabaya)", "Dewi (Malang)", 1.5)
    val paket3 = PaketEkspres("EXP-001", "Eko (Medan)", "Fajar (Jakarta)", 3.0, 10000.0)
    val paket4 = PaketFragile("FRG-001", "Gita (Yogyakarta)", "Hana (Solo)", 2.5, 20000.0)

    manager.terimaPaket(paket1)
    manager.terimaPaket(paket2)
    manager.terimaPaket(paket3)
    manager.terimaPaket(paket4)

    println("\n=== 2. MENGUBAH STATUS PAKET ===")
    // 3. Mengubah status paket melalui updateStatus()
    paket1.updateStatus(StatusPengiriman.DalamPerjalanan("Pak Jono"))
    paket3.updateStatus(StatusPengiriman.Terkirim("Fajar", "14:30 WIB"))
    paket4.updateStatus(StatusPengiriman.Gagal("Alamat penerima rumah kosong"))

    // 4. Menampilkan seluruh paket
    manager.tampilkanSemuaPaket()

    // 5. Menguji fungsi pencarian & Smart Casting
    manager.lacakPaket("EXP-001")
    manager.lacakPaket("FRG-001")

    // 6. Menampilkan Total Pendapatan
    println("\n==========================================")
    println("TOTAL PENDAPATAN EKSPEDISI : Rp ${manager.hitungTotalPendapatan().toInt()}")
    println("==========================================")
}