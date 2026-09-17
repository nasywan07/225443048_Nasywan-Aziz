class Payment(
    val order: Order,
    var method: PaymentMethod
) {
    private var _amount: Double = order.getTotalFare()

    var isPaid: Boolean = false
        private set

    fun getAmount(): Double = _amount

    fun processPayment(paidAmount: Double): PaymentResult {
        val totalFee = method.getFee(_amount)
        val totalToPay = _amount + totalFee

        if (paidAmount < totalToPay) {
            return PaymentResult.Failed("Nominal kurang! Total tagihan + biaya: Rp $totalToPay", 402)
        }

        val result = method.processPayment(paidAmount)
        if (result is PaymentResult.Success) {
            isPaid = true
        }
        return result
    }

    fun displayPayment() {
        println("===== Detail Pembayaran =====")
        println("ID Order   : ${order.id}")
        println("Jumlah     : Rp $_amount")
        println("Biaya Admin: Rp ${method.getFee(_amount)}")
        println("Metode     : ${method.name}")
        println("Status     : ${if (isPaid) "Lunas" else "Belum Dibayar"}")
    }
}