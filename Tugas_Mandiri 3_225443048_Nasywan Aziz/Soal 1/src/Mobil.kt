class Mobil(
    merek: String,
    model: String,
    tahun: Int,
    val jumlahPintu: Int,
    val jenisBahanBakar: String
):Kendaraan(merek, model, tahun){
    override fun info() {
        println("Mobil: $merek $model ($tahun) - $jumlahPintu , $jenisBahanBakar")
    }
}