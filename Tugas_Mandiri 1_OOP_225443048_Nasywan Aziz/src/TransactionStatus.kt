sealed class TransactionStatus {
    abstract fun display(): String
    fun isFinal(): Boolean {
        return this is Returned || this is Cancelled
    }
}
object Borrowed : TransactionStatus() {
    override fun display(): String = "sedang dipinjam"
}
object Returned : TransactionStatus() {
    override fun display(): String = "sudah dikembalikan"
}
data class Overdue(val daysLate: Int) : TransactionStatus() {
    override fun display(): String = "  terlambat dengan jumlah hari ($daysLate hari)"
}
object Cancelled : TransactionStatus() {
    override fun display(): String = "dibatalkan"
}
