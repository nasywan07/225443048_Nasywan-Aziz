class Dealership(val name: String) {
    private val vehicles: MutableList<Vehicle> = mutableListOf()

    fun addVehicle(vehicle: Vehicle) {
        vehicles.add(vehicle)
    }

    fun findVehicle(brand: String, model: String): Vehicle? {
        for (v in vehicles) {
            if (v.brand.equals(brand, ignoreCase = true) && v.model.equals(model, ignoreCase = true)) {
                return v
            }
        }
        return null
    }

    fun sellVehicle(brand: String, model: String): Boolean {
        val vehicle = findVehicle(brand, model)
        return if (vehicle != null && vehicle.isAvailable()) {
            vehicle.sell()
        } else {
            false
        }
    }

    fun getAvailableVehicles(): List<Vehicle> {
        val available = mutableListOf<Vehicle>()
        for (v in vehicles) {
            if (v.isAvailable()) {
                available.add(v)
            }
        }
        return available
    }

    fun getSoldVehicles(): List<Vehicle> {
        val sold = mutableListOf<Vehicle>()
        for (v in vehicles) {
            if (v.isSold) {
                sold.add(v)
            }
        }
        return sold
    }

    fun displayAllVehicles() {
        println("==================================================")
        println(" ${name.uppercase()}")
        println("==================================================")
        println()
        println("=== SEMUA KENDARAAN ===")
        println()
        for (v in vehicles) {
            println(v.displayInfo())
            println()
        }
    }

    fun displayAvailableVehicles() {
        println("=== KENDARAAN TERSEDIA ===")
        for (v in getAvailableVehicles()) {
            val jenis = when (v) {
                is Car -> "Car"
                is Motorcycle -> "Motorcycle"
                is Truck -> "Truck"
                else -> "Vehicle"
            }
            println("- ${v.brand} ${v.model} ($jenis)")
        }
        println()
    }

    fun getTotalRevenue(): Double {
        var total = 0.0
        for (v in getSoldVehicles()) {
            total += v.price
        }
        return total
    }
}