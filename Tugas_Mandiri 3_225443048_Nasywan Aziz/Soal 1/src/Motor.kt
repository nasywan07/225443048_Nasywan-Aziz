class Motor(
    merek: String,
    model: String,
    tahun: Int,
    val kapasitasMesin: Int,
    val jenis: String
) : Kendaraan(merek, model, tahun) {

    override fun info() {
        println("Motor: $merek $model ($tahun) - ${kapasitasMesin}cc, $jenis")
    }
}