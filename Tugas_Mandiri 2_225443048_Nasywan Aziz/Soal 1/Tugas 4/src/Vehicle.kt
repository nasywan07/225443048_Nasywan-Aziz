open class Vehicle(
    val plateNumber: String,
    val brand: String,
    val model: String,
    val year: Int
) {
    var isAvailable: Boolean = true

    open fun getType(): String {
        return "Kendaraan Umum"
    }

    open fun calculateFare(distanceKm: Double): Double {
        return distanceKm * 4000.0
    }

    open fun displayInfo() {
        println("===== Informasi Vehicle (${getType()}) =====")
        println("Plat Nomor : $plateNumber")
        println("Brand      : $brand")
        println("Model      : $model")
        println("Tahun      : $year")
        println("Status     : ${if (isAvailable) "Tersedia" else "Tidak Tersedia"}")
    }
}