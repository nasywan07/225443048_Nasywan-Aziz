class DVD(
    val director: String,
    val duration: Int,
    val Genre: String,
    id: String,
    title: String,
    year: Int,
):item(id, title, year) {
    override fun calculateFinePerDay(): Double {
        return 5000.0
    }

    override fun getItemType(): String {
        return "DVD"
    }

    override fun getMaxBorrowDays(): Int {
        return 3
    }

    override fun displayInfo() {
        super.displayInfo()
        println("sutradara : $director")
        println("Druasi: $duration")
        println("Genre: $Genre")
    }
}