package com.vxsoftware.quickgeometry.ui.rectangular

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

class RectangleFragment : Fragment() {

    private lateinit var rectangleViewModel: RectangleViewModel

    var s = 3.14
    var d = 3.14
    var P = 3.14
    var A = 3.14

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        rectangleViewModel =
                ViewModelProvider(this).get(RectangleViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_rectangle, container, false)
        val textView: TextView = root.findViewById(R.id.text_rectangle)
        rectangleViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        var ResultView: TextView = root.findViewById(R.id.ResultRView)

        // get reference to button
        val btn_click_me = root.findViewById(R.id.calcRbutton) as Button
        var editText: EditText
        var checkLText: EditText
        var checkWText: EditText
        var checkDText: EditText
        var checkPText: EditText
        var checkAText: EditText

        var i: Int
        var l: Double
        var w: Double
        var d: Double
        var P: Double
        var A: Double

        l = 0.0
        w = 0.0
        d = 0.0
        P = 0.0
        A = 0.0

        // set on-click listener
        btn_click_me.setOnClickListener {
            var mToast = Toast.makeText(getActivity(), "Calculating", Toast.LENGTH_SHORT)
            mToast.show()
            // your code to perform when the user clicks on the button

            i = 0
            l = 0.0
            w = 0.0
            d = 0.0
            P = 0.0
            A = 0.0

            checkLText = root.findViewById(R.id.LengthRDecimal)
            if ((checkLText.text.toString().length > 0))
                i++
            checkWText = root.findViewById(R.id.WidthRDecimal)
            if ((checkWText.text.toString().length > 0))
                i++
            checkDText = root.findViewById(R.id.DiagonalRDecimal)
            if ((checkDText.text.toString().length > 0))
                i++
            checkPText = root.findViewById(R.id.PerimeterRDecimal)
            if ((checkPText.text.toString().length > 0))
                i++
            checkAText = root.findViewById(R.id.AreaRDecimal)
            if ((checkAText.text.toString().length > 0))
                i++

            if (i < 2){
                mToast = Toast.makeText(
                        getActivity(),
                        "Kindly insert enouph values",
                        Toast.LENGTH_SHORT
                )
                mToast.show()
            }

            if ((checkLText.text.toString().length > 0) && (checkWText.text.toString().length > 0)) {
                l = checkLText.text.toString().toDouble()
                w = checkWText.text.toString().toDouble()
                d = sqrt((l * l) + (w * w))
                P = 2 * (l + w)
                A = l * w
            } else if ((checkLText.text.toString().length > 0) && (checkDText.text.toString().length > 0)) {
                    l = checkLText.text.toString().toDouble()
                    d = checkDText.text.toString().toDouble()
                    w = sqrt((d * d) - (l * l))
                    P = 2 * (l + w)
                    A = l * w
                } else if ((checkLText.text.toString().length > 0) && (checkPText.text.toString().length > 0)) {
                    l = checkLText.text.toString().toDouble()
                    P = checkPText.text.toString().toDouble()
                    w = ((P / 2) - l)
                    d = sqrt((l * l) + (w * w))
                    A = l * w
                 } else if ((checkLText.text.toString().length > 0) && (checkAText.text.toString().length > 0))
                 {
                         l = checkLText.text.toString().toDouble()
                         A = checkAText.text.toString().toDouble()
                         w = A / l
                         P = 2 * (l + w)
                         d = sqrt((l * l) + (w * w))
                 } else if ((checkWText.text.toString().length > 0) && (checkDText.text.toString().length > 0)) {
                    w = checkWText.text.toString().toDouble()
                    d = checkDText.text.toString().toDouble()
                    l = sqrt((d * d) - (w * w))
                    P = 2 * (l + w)
                    A = l * w
                } else if ((checkWText.text.toString().length > 0) && (checkPText.text.toString().length > 0)) {
                    w = checkWText.text.toString().toDouble()
                    P = checkPText.text.toString().toDouble()
                    l = ((P / 2) - w)
                    d = sqrt((l * l) + (w * w))
                    A = l * w
                } else if ((checkWText.text.toString().length > 0) && (checkAText.text.toString().length > 0)) {
                    w = checkWText.text.toString().toDouble()
                    A = checkAText.text.toString().toDouble()
                    l = A / w
                    d = sqrt((l * l) + (w * w))
                    P = 2 * (l + w)
                } else if ((checkDText.text.toString().length > 0) && (checkPText.text.toString().length > 0)) {
                    d = checkDText.text.toString().toDouble()
                    P = checkPText.text.toString().toDouble()
                    l = (P / 4) + ((1 / 4) * sqrt((8 * d * d) - (P * P)))
                    w = ((P / 2) - l)
                    A = l * w
                } else if ((checkDText.text.toString().length > 0) && (checkAText.text.toString().length > 0)) {
                    d = checkDText.text.toString().toDouble()
                    A = checkAText.text.toString().toDouble()
                    l = (sqrt(2.0) * d * d * sqrt((d * d) + sqrt((d * d * d * d) - (4 * A * A))) - sqrt(2.0) * sqrt((d * d * d * d) - (4 * A * A)) * sqrt((d * d) + sqrt((d * d * d * d) - (4 * A * A)))) / (4 * A)
                    w = A / l
                    P = 2 * (l + w)
                } else if ((checkPText.text.toString().length > 0) && (checkAText.text.toString().length > 0)) {
                    P = checkPText.text.toString().toDouble()
                    A = checkAText.text.toString().toDouble()
                    l = (P / 4) + (0.25 * sqrt((P * P) - (16 * A)))
                    w = A / l
                    d = sqrt((l * l) + (w * w))
                }

            if (l != 0.0 && w != 0.0) {
            ResultView.text = "\nLegth is $l \n" + "Wedth is $w \n" +
                    "Diagonal is $d \n" + "Perimeter is $P \n" +
                    "Area is $A square unit of measurement"
            } else {
                ResultView.text = "\n "
            }
        }
        return root
    }
}