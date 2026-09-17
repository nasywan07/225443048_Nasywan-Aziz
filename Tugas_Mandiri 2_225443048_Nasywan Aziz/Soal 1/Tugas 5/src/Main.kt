fun main() {
    val system = TransportSystem("Go-Transport 2024")
    val car = Car("B 1234 XYZ", "Toyota", "Innova", 2021, "Bensin", 4)
    val motor = Motorcycle("D 5678 ABC", "Honda", "Beat", 2022, 125, true)
    val truck = Truck("E 9012 DEF", "Hino", "Dutro", 2020, 5.0, 2)

    system.addVehicle(car)
    system.addVehicle(motor)
    system.addVehicle(truck)

    val driver1 = Driver("D001", "Andi", "08123456789", car)
    val driver2 = Driver("D002", "Budi", "08129876543", motor)
    val driver3 = Driver("D003", "Citra", "08125678901", truck)

    system.addDriver(driver1)
    system.addDriver(driver2)
    system.addDriver(driver3)

    val cust1 = Customer("C001", "Dewi", "08134567890", "dewi@email.com", 100000.0)
    val cust2 = Customer("C002", "Eko", "08135678901", "eko@email.com", 50000.0)
    val cust3 = Customer("C003", "Fani", "08136789012", "fani@email.com", 200000.0)

    system.addCustomer(cust1)
    system.addCustomer(cust2)
    system.addCustomer(cust3)

    system.displayAllVehicles()
    println()
    system.displayAllDrivers()
    println()
    system.displayAllCustomers()
    println()

    val order1 = system.createOrder("C001", "D001", "Kampus A", "Mall B", 12.0)
    val order2 = system.createOrder("C002", "D002", "Stasiun", "Kantor", 8.0)
    val order3 = system.createOrder("C003", "D003", "Gudang", "Pelabuhan", 25.0)

    system.displayAllOrders()
    println()

    if (order1 != null) {
        println("=== PROSES PEMBAYARAN ORDER 1 ===")
        val qris = QRIS("QR1234567890")
        val fareWithFee = order1.getTotalFare() + qris.getFee(order1.getTotalFare())
        val result1 = system.processPayment(order1.id, qris, fareWithFee)
        println("Hasil: ${result1.display()}\n")
    }

    if (order2 != null) {
        println("=== PROSES PEMBAYARAN ORDER 2 (COBA 1: TUNAI NOMINAL KURANG) ===")
        val cash = Cash()
        val totalFare = order2.getTotalFare()
        val result2Gagal = system.processPayment(order2.id, cash, totalFare - 10000.0)
        println("Hasil: ${result2Gagal.display()}\n")

        println("=== PROSES PEMBAYARAN ORDER 2 (COBA 2: KARTU KREDIT SETELAH TOP-UP) ===")
        cust2.topUp(50000.0)
        val cc = CreditCard("1234567890123456")
        val fareWithFee = totalFare + cc.getFee(totalFare)
        val result2Sukses = system.processPayment(order2.id, cc, fareWithFee)
        println("Hasil: ${result2Sukses.display()}\n")
    }

    if (order1 != null) {
        system.completeOrder(order1.id)
    }

    if (order3 != null) {
        system.cancelOrder(order3.id, "Hujan deras")
    }

    println("=== STATUS AKHIR SELURUH ORDER ===")
    system.displayAllOrders()
    println()

    system.displayRevenueReport()
    println()

    println("=== DEMONSTRASI POLIMORFISME (TARIF 15 KM) ===")
    for (v in system.vehicles) {
        println("Kendaraan: ${v.brand} ${v.model} (${v.getType()}) | Tarif 15 km: Rp ${v.calculateFare(15.0)}")
    }
    println()

    println("=== DEMONSTRASI SMART CASTING ===")
    val d1 = system.findDriver("D001")
    if (d1 != null) {
        val vehicle = d1.vehicle
        if (vehicle is Car) {
            println("Driver D001 (${d1.nama}) menggunakan Mobil dengan Bahan Bakar: ${vehicle.fuelType}")
        }
    }
    println()

    println("=== DEMONSTRASI SEALED CLASS (ORDER STATUS) ===")
    val statuses: List<OrderStatus> = listOf(
        OrderStatus.Waiting,
        OrderStatus.OnGoing,
        OrderStatus.Completed,
        OrderStatus.Cancelled("Driver tidak merespon")
    )

    for (st in statuses) {
        val text = when (st) {
            OrderStatus.Waiting -> "Status: ${st.display()} [Final: ${st.isFinal()}]"
            OrderStatus.OnGoing -> "Status: ${st.display()} [Final: ${st.isFinal()}]"
            OrderStatus.Completed -> "Status: ${st.display()} [Final: ${st.isFinal()}]"
            is OrderStatus.Cancelled -> "Status: ${st.display()} [Final: ${st.isFinal()}]"
        }
        println(text)
    }
}