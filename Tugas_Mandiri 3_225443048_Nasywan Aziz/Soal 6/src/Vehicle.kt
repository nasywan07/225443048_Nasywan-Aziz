open class Vehicle(
    val brand: String,
    val model: String,
    val year: Int,
    val price: Double
) {
    var isSold: Boolean = false
        private set

    open fun calculateTax(): Double {
        return price * 0.10
    }

    fun sell(): Boolean {
        return if (!isSold) {
            isSold = true
            true
        } else {
            false
        }
    }

    fun isAvailable(): Boolean {
        return !isSold
    }

    open fun displayInfo(): String {
        val statusText = if (isSold) "Terjual" else "Tersedia"
        return "Brand: $brand, Model: $model, Year: $year, Price: Rp $price, Status: $statusText"
    }
}