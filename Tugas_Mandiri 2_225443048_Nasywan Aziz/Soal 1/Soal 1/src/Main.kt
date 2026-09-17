fun main() {
    val vehicle: Vehicle = Vehicle("B 1234 ABC", "Toyota", "Avanza", 2020)
    val driver = Driver("D001", "Budi", "08123456789",vehicle)
    val customer = Customer("C001", "Siti", "08987654321", "siti@email.com", 50000.0)

    vehicle.displayInfo()
    driver.displayInfo()
    customer.displayInfo()

    val fare = vehicle.calculateFare(10.0)
    println("Tarif perjalanan (10.0 km): Rp $fare")

    customer.topUp(100000.0)
    println("Saldo baru: Rp ${customer.balance}")

    val orderStatus = driver.acceptOrder()
    println("Apakah driver dapat menerima pesanan? $orderStatus")
}