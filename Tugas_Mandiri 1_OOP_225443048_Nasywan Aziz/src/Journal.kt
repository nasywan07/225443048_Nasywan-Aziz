class Journal(
    val publisher: String,
    val volume: Int,
    val issueNumber: Int,
    id: String,
    title: String,
    year: Int,
):item(id, title, year) {
    override fun calculateFinePerDay(): Double {
        return 3000.0
    }
    override fun getItemType(): String {
        return "Jurnal"
    }
    override fun getMaxBorrowDays(): Int {
        return 7
    }
    override fun displayInfo(){
        super.displayInfo()
        println("Penerbit : $publisher")
        println("Volume: vol. $volume")
        println("Edisi: edisi.$issueNumber")
    }
}