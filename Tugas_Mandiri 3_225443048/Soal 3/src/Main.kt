fun main() {
    val pegawai1 = PegawaiTetap("Budi", "P001", 5000000.0, 1500000.0)
    val pegawai2 = PegawaiKontrak("Siti", "P002", 4500000.0, 12)
    val manager1 = Manager("Dewi", "P003", 8000000.0, 2000000.0, 3000000.0)


    println("=== INFO PEGAWAI TETAP ===")
    pegawai1.tampilkanInfo()

    println("\n=== INFO PEGAWAI KONTRAK ===")
    pegawai2.tampilkanInfo()

    println("\n=== INFO MANAGER ===")
    manager1.tampilkanInfo()
}