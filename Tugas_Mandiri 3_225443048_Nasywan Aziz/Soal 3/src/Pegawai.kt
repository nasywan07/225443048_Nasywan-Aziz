open class Pegawai(
    open val nama: String,
    open val nip: String,
    open val gajiPokok: Double
) {
    init {
        println("📋 Pegawai $nama terdaftar dengan NIP $nip")
    }

    open fun hitungGaji(): Double = gajiPokok

    open fun tampilkanInfo() {
        println("Nama       : $nama")
        println("NIP        : $nip")
        println("Gaji Pokok: Rp $gajiPokok")
        println("Total Gaji: Rp ${hitungGaji()}")
    }
}