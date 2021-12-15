package jgonzalezt.onei.boletin.data

class DemografiaDatasource {

    val chartYears: Int = 2019

    fun poblacion(): List<HashMap<String, Any>> {
        val mun = Util().municipality
        return listOf(
            hashMapOf("name" to mun[5], "y" to 356.9),
            hashMapOf("name" to mun[0], "y" to 71),
            hashMapOf("name" to mun[1], "y" to 53.8),
            hashMapOf("name" to mun[2], "y" to 77.3),
            hashMapOf("name" to mun[3], "y" to 12.5),
            hashMapOf("name" to mun[4], "y" to 49),
            hashMapOf("name" to mun[6], "y" to 54.5),
            hashMapOf("name" to mun[7], "y" to 40),
            hashMapOf("name" to mun[8], "y" to 39),
            hashMapOf("name" to mun[9], "y" to 31.4),
            hashMapOf("name" to mun[10], "y" to 96.2),
            hashMapOf("name" to mun[11], "y" to 22.9),
            hashMapOf("name" to mun[12], "y" to 46.1),
            hashMapOf("name" to mun[13], "y" to 73.1)
        )
    }

    val infoAmbasZonas = ArrayList(
        listOf(
            71, 53.8, 77.3, 12.5, 49, 356.9, 54.5, 40, 39, 31.4, 96.2, 22.9, 46.1, 73.1
        )
    )
    val infoZonaUrbana = ArrayList(
        listOf(
            38.5, 21.9, 45.3, 10.8, 17.6, 307.2, 18, 23.3, 24.7, 21.8, 61.7, 10.3, 22.9, 61.2
        )
    )
    val infoZonaRural = ArrayList(
        listOf(
            32.4, 31.8, 32.1, 1.8, 31.5, 49.8, 36.5, 16.7, 14.3, 9.5, 34.5, 12.6, 23.2, 11.9
        )
    )

    // Monocromatico
    val colorsMonocromatHex = ArrayList<String>(
        listOf(
            "#004D9D",
            "#145BA4",
            "#286AAC",
            "#3C78B3",
            "#5087BC",
            "#6695C4",
            "#79A2CB",
            "#8CAFD2",
            "#9FBCD9",
            "#B2C9E0",
            "#C5D6E7",
            "#D8E3EE",
            "#EBF0F5",
            "#E1E1E1"
        )
    )
}