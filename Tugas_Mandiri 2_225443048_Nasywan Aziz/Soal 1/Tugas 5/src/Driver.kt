class Driver(
    val id: String,
    val nama: String,
    val phone: String,
    val vehicle: Vehicle
) {
    var isActive: Boolean = true

    fun displayInfo() {
        println("===== Informasi Driver =====")
        println("ID     : $id")
        println("Nama   : $nama")
        println("Phone  : $phone")
        println("Status : ${if (isActive) "Aktif" else "Tidak Aktif"}")
    }
    fun acceptOrder(): Boolean {
        return isActive && vehicle.isAvailable
    }
}