class Payment(
    val order: Order
) {
    private var _amount: Double = order.getTotalFare()
    private var _method: String = "Tunai"

    var isPaid: Boolean = false
        private set

    fun getAmount(): Double = _amount
    fun getMethod(): String = _method

    fun setMethod(method: String) {
        if (method == "Tunai" || method == "Kartu Kredit" || method == "QRIS") {
            _method = method
        }
    }

    fun processPayment(paidAmount: Double): Boolean {
        if (!isPaid && paidAmount >= _amount) {
            isPaid = true
            return true
        }
        return false
    }

    fun displayPayment() {
        println("===== Detail Pembayaran =====")
        println("ID Order   : ${order.id}")
        println("Jumlah     : Rp $_amount")
        println("Metode     : $_method")
        println("Status     : ${if (isPaid) "Lunas" else "Belum Dibayar"}")
    }
}