fun main() {
    val daftarHewan: List<Hewan> = listOf(
        Kucing("Milo", 3),
        Anjing("Rex", 5),
        Sapi("Sapi", 4)
    )

    println("=== INFO HEWAN ===")
    for (hewan in daftarHewan) {
        hewan.info()
    }

    println("=== SUARA HEWAN ===")
    for (hewan in daftarHewan) {
        hewan.suara()
    }
}