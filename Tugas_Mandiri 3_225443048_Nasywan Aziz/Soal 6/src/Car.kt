class Car(
    brand: String,
    model: String,
    year: Int,
    price: Double,
    val numberOfDoors: Int,
    val fuelType: String
) : Vehicle(brand, model, year, price) {

    override fun calculateTax(): Double {
        return price * 0.12
    }

    override fun displayInfo(): String {
        val statusText = if (isSold) "Terjual" else "Tersedia"
        return """
            [Car] $brand $model ($year)
            Harga        : Rp $price
            Pajak        : Rp ${calculateTax()}
            Pintu        : $numberOfDoors
            Bahan Bakar: $fuelType
            Status       : $statusText
        """.trimIndent()
    }
}