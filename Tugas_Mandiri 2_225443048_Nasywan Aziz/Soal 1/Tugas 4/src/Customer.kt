class Customer(
    val Id: String,
    val name: String,
    val phone: String,
    val email: String,
    var balance: Double = 0.0,
) {
    fun displayInfo() {
        println("===== Informasi Customer =====")
        println("ID          : $Id")
        println("Nama        : $name")
        println("No. HP      : $phone")
        println("Email       : $email")
        println("Saldo       : Rp $balance")
    }
    fun topUp(amount: Double) {
        balance += amount
    }
    fun canPay(amount: Double): Boolean {
        return balance >= amount
    }
}