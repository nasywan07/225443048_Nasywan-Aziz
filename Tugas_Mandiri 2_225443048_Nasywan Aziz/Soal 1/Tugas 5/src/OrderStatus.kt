sealed class OrderStatus {
    abstract fun display(): String

    fun isFinal(): Boolean {
        return this is Completed || this is Cancelled
    }

    object Waiting : OrderStatus() {
        override fun display(): String = "Menunggu Driver"
    }

    object OnGoing : OrderStatus() {
        override fun display(): String = "Dalam Perjalanan"
    }

    object Completed : OrderStatus() {
        override fun display(): String = "Pesanan Selesai"
    }

    data class Cancelled(val reason: String) : OrderStatus() {
        override fun display(): String = "Pesanan Dibatalkan (Alasan: $reason)"
    }
}