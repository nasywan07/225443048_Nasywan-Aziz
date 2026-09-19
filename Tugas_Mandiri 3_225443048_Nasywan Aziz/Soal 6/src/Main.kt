fun main() {
    val dealer = Dealership("Dealer Motor Jaya")

    val car1 = Car("Toyota", "Avanza", 2023, 250000000.0, 4, "Bensin")
    val car2 = Car("Honda", "Civic", 2022, 530000000.0, 4, "Bensin")

    val motor1 = Motorcycle("Honda", "Beat", 2022, 18000000.0, 125, "Matic")
    val motor2 = Motorcycle("Yamaha", "R15", 2023, 38000000.0, 155, "Sport")

    val truck1 = Truck("Hino", "Dutro", 2021, 350000000.0, 5.0, 4)
    val truck2 = Truck("Isuzu", "Elf", 2020, 400000000.0, 7.5, 6)

    dealer.addVehicle(car1)
    dealer.addVehicle(car2)
    dealer.addVehicle(motor1)
    dealer.addVehicle(motor2)
    dealer.addVehicle(truck1)
    dealer.addVehicle(truck2)

    dealer.displayAllVehicles()

    println("=== PENJUALAN ===")
    if (dealer.sellVehicle("Toyota", "Avanza")) {
        println("✅ Toyota Avanza berhasil dijual!")
    }
    if (dealer.sellVehicle("Honda", "Beat")) {
        println("✅ Honda Beat berhasil dijual!")
    }
    println()

    dealer.displayAvailableVehicles()

    println("=== TOTAL PENDAPATAN ===")
    println("Rp ${dealer.getTotalRevenue()}")
}