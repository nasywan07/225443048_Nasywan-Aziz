class Manager(
    nama: String,
    nip: String,
    gajiPokok: Double,
    tunjangan: Double,
    val tunjanganManajemen: Double
) : PegawaiTetap(nama, nip, gajiPokok, tunjangan) {

    override fun hitungGaji(): Double = super.hitungGaji() + tunjanganManajemen

    override fun tampilkanInfo() {
        super.tampilkanInfo()
        println("Tunj. Manajemen: Rp $tunjanganManajemen")
    }
}