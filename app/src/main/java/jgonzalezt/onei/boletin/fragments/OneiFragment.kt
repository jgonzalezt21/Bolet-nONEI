package jgonzalezt.onei.boletin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.TransitionInflater
import jgonzalezt.onei.boletin.R
import jgonzalezt.onei.boletin.adapter.ActvAdapter
import jgonzalezt.onei.boletin.data.ListActvDatasource

/**
 * A simple [Fragment] subclass.
 */
class OneiFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = TransitionInflater.from(requireContext())
        enterTransition = inflater.inflateTransition(R.transition.fade)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onei, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize data.
        val myDataset = ListActvDatasource().loadActvItem()

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_Actv)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = ActvAdapter(view.context, myDataset)
        }
        recyclerView.setHasFixedSize(true)
    }
}