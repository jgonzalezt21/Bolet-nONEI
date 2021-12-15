package jgonzalezt.onei.boletin.data

import jgonzalezt.onei.boletin.R
import jgonzalezt.onei.boletin.model.ListActv

class ListActvDatasource {

    fun loadActvItem(): List<ListActv> {
        return listOf(
            ListActv(R.string.a_txt1),
            ListActv(R.string.a_txt2),
            ListActv(R.string.a_txt3),
            ListActv(R.string.a_txt4),
            ListActv(R.string.a_txt5),
            ListActv(R.string.a_txt6),
            ListActv(R.string.a_txt7),
            ListActv(R.string.a_txt8),
            ListActv(R.string.a_txt9),
            ListActv(R.string.a_txt10)
        )
    }
}