package jgonzalezt.onei.boletin.data

import jgonzalezt.onei.boletin.R
import jgonzalezt.onei.boletin.model.Menu

class MenuDatasource {

    fun loadMenuItem(): List<Menu> {
        return listOf(
            Menu(R.string.item1, R.drawable.imgoneitrabajadores),
            Menu(R.string.item2, R.drawable.imghlgatardecer),
            Menu(R.string.item3, R.drawable.imgdecretosleyes),
            Menu(R.string.item4, R.drawable.imgdemograf),
            Menu(R.string.item5, R.drawable.imgonei)
        )
    }
}