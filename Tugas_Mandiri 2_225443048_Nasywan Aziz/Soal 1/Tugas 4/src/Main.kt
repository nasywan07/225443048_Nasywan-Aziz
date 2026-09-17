fun main() {
    val vehicles: List<Vehicle> = listOf(
        Car("B 1234 ABC", "Toyota", "Avanza", 2020, "Bensin", 4),
        Motorcycle("B 5678 DEF", "Honda", "Vario", 2022, 150, true),
        Truck("B 9101 GHI", "Mitsubishi", "Canter", 2019, 5.0, 2)
    )

    println("=== POLIMORFISME & SMART CASTING ===")
    for (v in vehicles) {
        println("Tipe: ${v.getType()} | Tarif 10 km: Rp ${v.calculateFare(10.0)}")
        when (v) {
            is Car -> println(" -> Detail Mobil: Fuel ${v.fuelType}, Pintu: ${v.numberOfDoors}")
            is Motorcycle -> println(" -> Detail Motor: ${v.engineCapacity} cc, Helm: ${v.hasHelmet}")
            is Truck -> println(" -> Detail Truk: ${v.loadCapacity} ton, Aksel: ${v.numberOfAxles}")
        }
        println()
    }

    println("=== DEMONSTRASI SAFE CASTING (as?) ===")
    val vehicleRef: Vehicle = vehicles[0]
    val safeCar = vehicleRef as? Car
    println("Casting Vehicle ke Car : ${safeCar?.brand} ${safeCar?.model}")

    val notACar: Vehicle = vehicles[1]
    val failedCar = notACar as? Car
    println("Casting Motor ke Car   : $failedCar (Safe Cast/Null)")
    println()

    println("=== UJI PEMBAYARAN (INTERFACE & SEALED CLASS) ===")
    val paymentMethods: List<PaymentMethod> = listOf(
        CreditCard("1234567890123456"), // Valid
        CreditCard("12345"),             // Invalid (< 16)
        QRIS("QRIS_CODE_123"),           // Valid
        Cash()                           // Valid
    )

    val amount = 100000.0
    for (pm in paymentMethods) {
        val result = pm.processPayment(amount)
        print("Metode: ${pm.name} | ")
        when (result) {
            is PaymentResult.Success -> println(result.display())
            is PaymentResult.Failed -> println(result.display())
            PaymentResult.Pending -> println(result.display())
        }
    }
    println()

    println("=== UJI ORDER STATUS ===")
    val statusList: List<OrderStatus> = listOf(
        OrderStatus.Waiting,
        OrderStatus.OnGoing,
        OrderStatus.Completed,
        OrderStatus.Cancelled("Driver tidak kunjung datang")
    )

    for (st in statusList) {
        val description = when (st) {
            OrderStatus.Waiting -> st.display()
            OrderStatus.OnGoing -> st.display()
            OrderStatus.Completed -> st.display()
            is OrderStatus.Cancelled -> st.display()
        }
        println("Status: $description | Status Final: ${st.isFinal()}")
    }
}