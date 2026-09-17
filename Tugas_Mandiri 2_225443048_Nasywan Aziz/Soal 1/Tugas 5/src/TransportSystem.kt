class TransportSystem(val name: String) {
    private val _vehicles: MutableList<Vehicle> = mutableListOf()
    private val _drivers: MutableList<Driver> = mutableListOf()
    private val _customers: MutableList<Customer> = mutableListOf()
    private val _orders: MutableList<Order> = mutableListOf()
    private val _payments: MutableList<Payment> = mutableListOf()

    // Akses read-only ke list
    val vehicles: List<Vehicle> get() = _vehicles
    val drivers: List<Driver> get() = _drivers
    val customers: List<Customer> get() = _customers
    val orders: List<Order> get() = _orders
    val payments: List<Payment> get() = _payments

    private var orderCounter = 1

    // --- Metode Manajemen ---
    fun addVehicle(vehicle: Vehicle) {
        _vehicles.add(vehicle)
    }

    fun addDriver(driver: Driver) {
        _drivers.add(driver)
    }

    fun addCustomer(customer: Customer) {
        _customers.add(customer)
    }

    fun findVehicle(plateNumber: String): Vehicle? {
        return _vehicles.find { it.plateNumber.equals(plateNumber, ignoreCase = true) }
    }

    fun findDriver(id: String): Driver? {
        return _drivers.find { it.id.equals(id, ignoreCase = true) }
    }

    fun findCustomer(id: String): Customer? {
        return _customers.find { it.Id.equals(id, ignoreCase = true) }
    }

    // --- Metode Operasi ---
    fun createOrder(customerId: String, driverId: String, pickup: String, dest: String, distance: Double): Order? {
        val customer = findCustomer(customerId)
        val driver = findDriver(driverId)

        if (customer != null && driver != null) {
            val orderId = "ORD-${String.format("%03d", orderCounter++)}"
            val order = Order(orderId, customer, driver, pickup, dest, distance)
            _orders.add(order)
            return order
        }
        return null
    }

    fun processPayment(orderId: String, method: PaymentMethod, paidAmount: Double): PaymentResult {
        val order = _orders.find { it.id == orderId }
            ?: return PaymentResult.Failed("Order tidak ditemukan", 404)

        val totalFareWithFee = order.getTotalFare() + method.getFee(order.getTotalFare())

        if (paidAmount < totalFareWithFee) {
            return PaymentResult.Failed("Nominal pembayaran kurang! (Total tagihan + biaya: Rp $totalFareWithFee)", 402)
        }

        val result = method.processPayment(paidAmount)
        if (result is PaymentResult.Success) {
            val payment = Payment(order, method)
            method.processPayment(paidAmount)
            _payments.add(payment)
            order.startTrip() // Mengubah status menjadi OnGoing saat pembayaran sukses
        }
        return result
    }

    fun completeOrder(orderId: String): Boolean {
        val order = _orders.find { it.id == orderId }
        return order?.completeTrip() ?: false
    }

    fun cancelOrder(orderId: String, reason: String): Boolean {
        val order = _orders.find { it.id == orderId }
        return order?.cancelTrip(reason) ?: false
    }

    // --- Metode Laporan ---
    fun displayAllVehicles() {
        println("===== DAFTAR KENDARAAN ($name) =====")
        if (_vehicles.isEmpty()) println("Belum ada kendaraan.")
        for (v in _vehicles) {
            v.displayInfo()
            println("------------------------------------")
        }
    }

    fun displayAllDrivers() {
        println("===== DAFTAR DRIVER ($name) =====")
        if (_drivers.isEmpty()) println("Belum ada driver.")
        for (d in _drivers) {
            d.displayInfo()
            println("------------------------------------")
        }
    }

    fun displayAllCustomers() {
        println("===== DAFTAR CUSTOMER ($name) =====")
        if (_customers.isEmpty()) println("Belum ada customer.")
        for (c in _customers) {
            c.displayInfo()
            println("------------------------------------")
        }
    }

    fun displayAllOrders() {
        println("===== DAFTAR ORDER ($name) =====")
        if (_orders.isEmpty()) println("Belum ada order.")
        for (o in _orders) {
            o.displayOrder()
            println("------------------------------------")
        }
    }

    fun displayRevenueReport() {
        val completedOrders = _orders.filter { it.status is OrderStatus.Completed }
        val totalRevenue = completedOrders.sumOf { it.getTotalFare() }
        println("===== LAPORAN PENDAPATAN ($name) =====")
        println("Jumlah Order Selesai : ${completedOrders.size}")
        println("Total Pendapatan     : Rp $totalRevenue")
        println("==========================================")
    }
}