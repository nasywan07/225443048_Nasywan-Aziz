class Order(
    val id: String,
    val customer: Customer,
    val driver: Driver,
    val pickupLocation: String,
    val destination: String,
    val distanceKm: Double
) {
    var status: OrderStatus = OrderStatus.Waiting
    private var _totalFare: Double = 0.0

    init {
        _totalFare = driver.vehicle.calculateFare(distanceKm)
    }

    fun getTotalFare(): Double = _totalFare

    fun startTrip(): Boolean {
        if (status is OrderStatus.Waiting) {
            status = OrderStatus.OnGoing
            return true
        }
        return false
    }

    fun completeTrip(): Boolean {
        if (status is OrderStatus.OnGoing) {
            status = OrderStatus.Completed
            return true
        }
        return false
    }

    fun cancelTrip(reason: String): Boolean {
        if (!status.isFinal()) {
            status = OrderStatus.Cancelled(reason)
            return true
        }
        return false
    }

    fun displayOrder() {
        println("===== Detail Order =====")
        println("ID Order           : $id")
        println("Customer           : ${customer.name}")
        println("Driver             : ${driver.nama}")
        println("Lokasi Penjemputan : $pickupLocation")
        println("Lokasi Tujuan      : $destination")
        println("Jarak              : $distanceKm km")
        println("Total Tarif        : Rp $_totalFare")
        println("Status             : ${status.display()}")
    }
}