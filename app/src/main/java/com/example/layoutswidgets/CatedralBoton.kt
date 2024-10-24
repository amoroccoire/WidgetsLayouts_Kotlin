package com.example.layoutswidgets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CatedralBoton : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_catedral_boton, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentButtonCatedral = view.findViewById<FrameLayout>(R.id.btnCatedral)
        fragmentButtonCatedral.setOnClickListener{
            replaceFragment()
        }
    }

    private fun replaceFragment() {
        val catedralContent = CatedralContent()
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            replace(R.id.fragmentContainerView, catedralContent)
            addToBackStack(null)
            commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CatedralBoton().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}