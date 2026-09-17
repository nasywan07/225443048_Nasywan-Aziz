sealed class PaymentResult {
    abstract fun display(): String

    data class Success(val transactionId: String, val timestamp: String) : PaymentResult() {
        override fun display(): String = "Pembayaran Berhasil! [ID: $transactionId, Waktu: $timestamp]"
    }

    data class Failed(val reason: String, val errorCode: Int) : PaymentResult() {
        override fun display(): String = "Pembayaran Gagal! [Kode: $errorCode, Alasan: $reason]"
    }

    object Pending : PaymentResult() {
        override fun display(): String = "Pembayaran Menunggu Konfirmasi."
    }
}