open class Kendaraan(
    val merek: String,
    val model:String,
    val tahun : Int,
){
    open fun info(){
        println("Kendaraan : $merek, $model, ($tahun)")
    }
    open fun start(){
        println("$merek, $model, Dinyalakan")
    }
}