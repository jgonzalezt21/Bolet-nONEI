package jgonzalezt.onei.boletin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.transition.TransitionInflater
import com.highsoft.highcharts.common.hichartsclasses.*
import com.highsoft.highcharts.core.HIChartView
import jgonzalezt.onei.boletin.R
import jgonzalezt.onei.boletin.data.DemografiaDatasource
import jgonzalezt.onei.boletin.data.Util
import java.util.*
import kotlin.collections.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class DemografiaFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = TransitionInflater.from(requireContext())
        enterTransition = inflater.inflateTransition(R.transition.slide_bottom)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_demografia, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val notTitle = HITitle()
        notTitle.text = ""

        val dataLabels = HIDataLabels()
        dataLabels.enabled = true

        val legend = HILegend()
        legend.enabled = false

        val colorsMonocromatHex = DemografiaDatasource().colorsMonocromatHex

        // PRIMERA -----------------------------------
        val chartView1 = view.findViewById<HIChartView>(R.id.hc1)
        val options1 = HIOptions()
        val chartCols = HIChart()
        chartCols.type = "column"
        options1.chart = chartCols
        options1.colors = ArrayList<String>(
            listOf(
                colorsMonocromatHex[0],
                colorsMonocromatHex[4],
                colorsMonocromatHex[8]
            )
        )

        val title1 = HITitle()
        title1.text = "Población residente por sexo"
        options1.title = title1

        val subtitle1 = HISubtitle()
        subtitle1.text = "${DemografiaDatasource().chartYears}"
        options1.subtitle = subtitle1

        val xAxis1 = HIXAxis()
        xAxis1.type = "category"
        options1.xAxis = ArrayList(Collections.singletonList(xAxis1))

        val yAxis1 = HIYAxis()
        yAxis1.title = notTitle
        yAxis1.min = 0
        options1.yAxis = ArrayList(Collections.singletonList(yAxis1))

        options1.legend = legend

        val total = HIColumn()
        total.name = "Total"
        total.data = ArrayList(listOf(arrayOf("Total", 1023703)))
        total.dataLabels = ArrayList(Collections.singletonList(dataLabels))

        val hombres = HIColumn()
        hombres.name = "Hombres"
        hombres.data = ArrayList(listOf(arrayOf("Hombres", 513912)))
        hombres.dataLabels = ArrayList(Collections.singletonList(dataLabels))

        val mujeres = HIColumn()
        mujeres.name = "Mujeres"
        mujeres.data = ArrayList(listOf(arrayOf("Mujeres", 509791)))
        mujeres.dataLabels = ArrayList(Collections.singletonList(dataLabels))

        options1.series = ArrayList(listOf(total, hombres, mujeres))
        chartView1.options = options1

        // SEGUNDA -----------------------------------
        val chartView2 = view.findViewById<HIChartView>(R.id.hc2)
        val options2 = HIOptions()
        val chartPie = HIChart()
        chartPie.type = "pie"
        chartPie.plotShadow = false
        options2.chart = chartPie
        options2.colors = DemografiaDatasource().colorsMonocromatHex

        val title2 = HITitle()
        title2.text = "Población por Municipios ${DemografiaDatasource().chartYears}"
        options2.title = title2

        val subtitle2 = HISubtitle()
        subtitle2.text = "(Miles de Unidades)"
        options2.subtitle = subtitle2

        val plotOps = HIPlotOptions()
        plotOps.pie = HIPie()
        plotOps.pie.allowPointSelect = true
        plotOps.pie.cursor = "pointer"

        val dataLabelsPie = HIDataLabels()
        dataLabelsPie.enabled = true
        dataLabelsPie.format = "<b>{point.name}</b>: {point.y:.1f}"
        plotOps.pie.dataLabels = ArrayList(Collections.singletonList(dataLabelsPie))
        options2.plotOptions = plotOps

        val pie = HIPie()
        pie.name = "Población"
        pie.data = ArrayList(DemografiaDatasource().poblacion())

        options2.series = ArrayList(Collections.singletonList(pie))
        chartView2.options = options2

        // TERCERA -----------------------------------
        val chartView3 = view.findViewById<HIChartView>(R.id.hc3)
        val options3 = HIOptions()
        options3.chart = chartCols
        options3.colors = ArrayList<String>(
            listOf(
                colorsMonocromatHex[0],
                colorsMonocromatHex[5],
                colorsMonocromatHex[10]
            )
        )

        val title3 = HITitle()
        title3.text =
            "Población por Municipios y Zonas de Residencias ${DemografiaDatasource().chartYears}"
        options3.title = title3

        val subtitle3 = HISubtitle()
        subtitle3.text = "(Miles de Unidades)"
        options3.subtitle = subtitle3

        val xAxis3 = HIXAxis()
        xAxis3.categories = Util().municipality
        options3.xAxis = ArrayList(Collections.singletonList(xAxis3))

        val yAxis3 = HIYAxis()
        yAxis3.title = notTitle
        yAxis3.min = 0
        options3.yAxis = ArrayList(Collections.singletonList(yAxis3))

        val az = HIColumn()
        az.name = "Ambas Zonas"
        az.data = DemografiaDatasource().infoAmbasZonas
        az.dataLabels = ArrayList(Collections.singletonList(dataLabels))

        val urbana = HIColumn()
        urbana.name = "Urbana"
        urbana.data = DemografiaDatasource().infoZonaUrbana
        urbana.dataLabels = ArrayList(Collections.singletonList(dataLabels))

        val rural = HIColumn()
        rural.name = "Rural"
        rural.data = DemografiaDatasource().infoZonaRural
        rural.dataLabels = ArrayList(Collections.singletonList(dataLabels))

        options3.series = ArrayList(listOf(az, urbana, rural))
        chartView3.options = options3

        // Charger Hiden
//        Handler(Looper.getMainLooper()).postDelayed({
//            val pbar = view.findViewById<ProgressBar>(R.id.pbDemografia)
//            pbar.visibility = View.GONE
//        }, 2500)
    }
}