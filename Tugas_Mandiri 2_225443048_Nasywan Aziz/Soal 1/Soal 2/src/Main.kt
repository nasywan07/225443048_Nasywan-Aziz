fun main() {
    val vehicle: Vehicle = Vehicle("B 1234 ABC", "Toyota", "Avanza", 2020)
    val driver = Driver("D001", "Budi", "08123456789", vehicle)
    val customer = Customer("C001", "Siti", "08987654321", "siti@email.com", 50000.0)
    val order = Order(
        id = "ORD001",
        customer = customer,
        driver = driver,
        pickupLocation = "Jl. Merdeka No. 1",
        destination = "Jl. Sudirman No. 45",
        distanceKm = 15.0
    )
    order.displayOrder()
    println("\n--- Memulai & Menyelesaikan Perjalanan ---")
    order.startTrip()
    order.completeTrip()
    println("Status saat ini: ${order.getStatus()}")
    val isCancelled = order.cancelTrip("Ingin ganti tujuan")
    println("Apakah pembatalan berhasil? $isCancelled")
    val payment = Payment(order)
    payment.setMethod("QRIS")
    payment.processPayment(75000.0)
    println()
    payment.displayPayment()

