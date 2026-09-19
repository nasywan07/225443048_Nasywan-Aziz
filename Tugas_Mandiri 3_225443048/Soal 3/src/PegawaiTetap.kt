open class PegawaiTetap(
    nama: String,
    nip: String,
    gajiPokok: Double,
    val tunjangan: Double
) : Pegawai(nama, nip, gajiPokok) {

    override fun hitungGaji(): Double = gajiPokok + tunjangan

    override fun tampilkanInfo() {
        super.tampilkanInfo()
        println("Tunjangan  : Rp $tunjangan")
    }
}