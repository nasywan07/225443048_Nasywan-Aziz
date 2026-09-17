interface PaymentMethod {
    val name: String
    fun processPayment(amount: Double): PaymentResult
    fun getFee(amount: Double): Double = 0.0
}

class CreditCard(val cardNumber: String) : PaymentMethod {
    override val name: String = "Kartu Kredit"

    override fun getFee(amount: Double): Double = amount * 0.02

    override fun processPayment(amount: Double): PaymentResult {
        return if (cardNumber.length >= 16) {
            PaymentResult.Success("TXN-CC-99812", "2026-09-17 10:00")
        } else {
            PaymentResult.Failed("Nomor kartu kredit tidak valid (minimal 16 digit)", 400)
        }
    }
}

class QRIS(val qrCode: String) : PaymentMethod {
    override val name: String = "QRIS"

    override fun getFee(amount: Double): Double = amount * 0.005

    override fun processPayment(amount: Double): PaymentResult {
        return if (qrCode.length >= 10) {
            PaymentResult.Success("TXN-QR-55412", "2026-09-17 10:00")
        } else {
            PaymentResult.Failed("Kode QR tidak valid (minimal 10 karakter)", 401)
        }
    }
}

class Cash : PaymentMethod {
    override val name: String = "Tunai"

    override fun getFee(amount: Double): Double = 0.0

    override fun processPayment(amount: Double): PaymentResult {
        return PaymentResult.Success("TXN-CASH-1002", "2026-09-17 10:00")
    }
}