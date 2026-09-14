class Book(
    val author: String,
    val pages: Int,
    val Genre: String,
    id: String,
    title: String,
    year: Int,
):item(id, title, year) {
    override fun calculateFinePerDay(): Double {
        return 2000.0
    }
    override fun getItemType(): String {
        return "Buku"
    }
    override fun getMaxBorrowDays(): Int {
        return 14
    }
    override fun displayInfo(){
        super.displayInfo()
    println("Penulis: $author")
    println("Jumlah Halaman: $pages")
    println("Genre: $Genre")
    }
}