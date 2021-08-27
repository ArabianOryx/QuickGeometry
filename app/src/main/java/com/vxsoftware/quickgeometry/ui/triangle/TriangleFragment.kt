package com.vxsoftware.quickgeometry.ui.triangle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vxsoftware.quickgeometry.R
import kotlin.math.sqrt

class TriangleFragment : Fragment() {

    private lateinit var triangleViewModel: TriangleViewModel

    var s = 3.14
    var d = 3.14
    var P = 3.14
    var A = 3.14

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        triangleViewModel =
                ViewModelProvider(this).get(TriangleViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_triangle, container, false)
        val textView: TextView = root.findViewById(R.id.text_triangle)
        triangleViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        var ResultView: TextView = root.findViewById(R.id.ResultTView)

        // get reference to button
        val btn_click_me = root.findViewById(R.id.calcTbutton) as Button
        var editText: EditText
        var checkHText: EditText
        var checkBText: EditText
        var checkScText: EditText
        var checkPText: EditText
        var checkAText: EditText

        var i: Int
        var h: Double
        var b: Double
        var c: Double
        var s: Double
        var P: Double
        var A: Double

        h = 0.0
        b = 0.0
        c = 0.0
        s = 0.0
        P = 0.0
        A = 0.0

        // set on-click listener
        btn_click_me.setOnClickListener {
            var mToast = Toast.makeText(getActivity(), "Calculating", Toast.LENGTH_SHORT)
            mToast.show()
            // your code to perform when the user clicks on the button

            i = 0
            h = 0.0
            b = 0.0
            c = 0.0
            s = 0.0
            P = 0.0
            A = 0.0

            checkHText = root.findViewById(R.id.HeightTDecimal)
            if ((checkHText.text.toString().length > 0))
                i++
            checkBText = root.findViewById(R.id.SidebTDecimal)
            if ((checkBText.text.toString().length > 0))
                i++
            checkAText = root.findViewById(R.id.AreaTDecimal)
            if ((checkAText.text.toString().length > 0))
                i++

            if (i < 2){
                mToast = Toast.makeText(
                        getActivity(),
                        "Kindly insert enough values",
                        Toast.LENGTH_SHORT
                )
                mToast.show()
            }

            if ((checkHText.text.toString().length > 0) && (checkBText.text.toString().length > 0)) {
                h = checkHText.text.toString().toDouble()
                b = checkBText.text.toString().toDouble()
                A = (h * b) / 2.0

            } else if ((checkHText.text.toString().length > 0) && (checkAText.text.toString().length > 0)) {
                h = checkHText.text.toString().toDouble()
                A = checkAText.text.toString().toDouble()
                b = (A * 2.0) / h

                } else if ((checkBText.text.toString().length > 0) && (checkAText.text.toString().length > 0)) {
                    b = checkBText.text.toString().toDouble()
                A = checkAText.text.toString().toDouble()
                h = (A * 2.0) / b
                }

            if (h != 0.0 && b != 0.0) {
            ResultView.text = "\nHeight is $h \n" + "Base is $b \n" +
                    "Area is $A square unit of measurement"
            } else {
                ResultView.text = "\n "
            }
        }
        return root
    }
}