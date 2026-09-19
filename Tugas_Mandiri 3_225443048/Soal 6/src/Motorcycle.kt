class Motorcycle(
    brand: String,
    model: String,
    year: Int,
    price: Double,
    val engineCapacity: Int,
    val type: String
) : Vehicle(brand, model, year, price) {

    override fun calculateTax(): Double {
        return price * 0.05
    }

    override fun displayInfo(): String {
        val statusText = if (isSold) "Terjual" else "Tersedia"
        return """
            [Motorcycle] $brand $model ($year)
            Harga        : Rp $price
            Pajak        : Rp ${calculateTax()}
            Mesin        : ${engineCapacity}cc
            Tipe         : $type
            Status       : $statusText
        """.trimIndent()
    }
}