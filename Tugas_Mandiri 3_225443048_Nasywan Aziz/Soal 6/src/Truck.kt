class Truck(
    brand: String,
    model: String,
    year: Int,
    price: Double,
    val loadCapacity: Double,
    val numberOfAxles: Int
) : Vehicle(brand, model, year, price) {

    override fun calculateTax(): Double {
        return price * 0.15
    }

    override fun displayInfo(): String {
        val statusText = if (isSold) "Terjual" else "Tersedia"
        return """
            [Truck] $brand $model ($year)
            Harga        : Rp $price
            Pajak        : Rp ${calculateTax()}
            Kapasitas    : $loadCapacity ton
            Sumbu        : $numberOfAxles
            Status       : $statusText
        """.trimIndent()
    }
}