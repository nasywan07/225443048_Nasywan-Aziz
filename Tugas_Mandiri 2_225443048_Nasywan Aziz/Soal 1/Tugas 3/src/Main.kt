fun main() {
    val car = Car("B 1234 ABC", "Toyota", "Avanza", 2020, "Bensin", 4)
    val motorcycle = Motorcycle("B 5678 DEF", "Honda", "Vario", 2022, 150, true)
    val truck = Truck("B 9101 GHI", "Mitsubishi", "Canter", 2019, 5.0, 2)

    println("=== DETAIL KENDARAAN ===")
    car.displayInfo()
    println()
    motorcycle.displayInfo()
    println()
    truck.displayInfo()
    println()

    println("=== TARIF 20 KM ===")
    println("Tarif Mobil (20 km) : Rp ${car.calculateFare(20.0)}")
    println("Tarif Motor (20 km) : Rp ${motorcycle.calculateFare(20.0)}")
    println("Tarif Truk (20 km)  : Rp ${truck.calculateFare(20.0)}")
    println()

    val driverCar = Driver("D001", "Budi", "08123456789", car)
    val driverMotor = Driver("D002", "Siti", "08987654321", motorcycle)
    val driverTruck = Driver("D003", "Agus", "08551234567", truck)

    println("=== DETAIL DRIVER ===")
    driverCar.displayInfo()
    println()
    driverMotor.displayInfo()
    println()
    driverTruck.displayInfo()
}