class Vehicle(
    val plateNumber: String,
    val brand: String,
    val model: String,
    val year: Int
) {
    var isAvailable: Boolean = true

    fun displayInfo(): Unit {
        println("===== Informasi Vehicle =====")
        println("Plat Nomor : $plateNumber")
        println("Brand      : $brand")
        println("Model      : $model")
        println("Tahun      : $year")
        println("Status     : ${if (isAvailable) "Tersedia" else "Tidak Tersedia"}")
    }

    fun calculateFare(distanceKm: Double): Double {
        return distanceKm * 5000.0
    }
}