fun main() {
    println("=== KENDARAAN ===")

    // Membuat objek Mobil dan memanggil metodenya
    val mobil = Mobil("Toyota", "Avanza", 2023, 4, "Bensin")
    mobil.info()
    mobil.start()

    println() // Baris kosong untuk pemisah sesuai contoh output

    // Membuat objek Motor dan memanggil metodenya
    val motor = Motor("Honda", "Beat", 2022, 125, "Matic")
    motor.info()
    motor.start()
}