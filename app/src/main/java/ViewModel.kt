import androidx.compose.runtime.mutableStateListOf

class ViewModel {
    val card = mutableStateListOf<CardData>()

    fun addCard(text:String){
        cards.add(CardData(text))
    }

    fun removeCard(){

    }
}
//tener inventario, vender productos, tienda en linea