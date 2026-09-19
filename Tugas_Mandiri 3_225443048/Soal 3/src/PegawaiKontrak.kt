class PegawaiKontrak(
    nama: String,
    nip: String,
    gajiPokok: Double,
    val durasiKontrak: Int // dalam bulan
) : Pegawai(nama, nip, gajiPokok) {

    override fun tampilkanInfo() {
        super.tampilkanInfo()
        println("Durasi     : $durasiKontrak bulan")
    }
}