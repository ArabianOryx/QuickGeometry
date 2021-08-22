package com.vxsoftware.quickgeometry.ui.square

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

class SquareFragment : Fragment() {

    private lateinit var squareViewModel: SquareViewModel

    var s = 3.14
    var d = 3.14
    var P = 3.14
    var A = 3.14

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        squareViewModel =
                ViewModelProvider(this).get(SquareViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_square, container, false)
        val textView: TextView = root.findViewById(R.id.text_square)
        squareViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        var ResultView: TextView = root.findViewById(R.id.ResultSView)

        // get reference to button
        val btn_click_me = root.findViewById(R.id.calcSbutton) as Button
        var editText: EditText

        var s: Double
        var d: Double
        var P: Double
        var A: Double

        // set on-click listener
        btn_click_me.setOnClickListener {
            var mToast = Toast.makeText(getActivity(), "Calculating", Toast.LENGTH_SHORT)
            mToast.show()
            // your code to perform when the user clicks on the button
            //Toast.makeText (this@CircleFragment, "You clicked me.", Toast.LENGTH_SHORT).show()

            editText = root.findViewById(R.id.SideSDecimal)
            if ((editText.text.toString().length > 0)) {
                s = editText.text.toString().toDouble()
                d = (sqrt(2.0)) * s
                P = (4 * s).toDouble()
                A = (s * s).toDouble()

                ResultView.text = "\nSide was given as $s \n" +
                        "Diagonal is $d \n" + "Perimeter is $P \n" +
                        "Area is $A square unit of measurement"

            } else {
                editText = root.findViewById(R.id.DiagonalSDecimal)

                if ((editText.text.toString().length > 0)) {
                    d = editText.text.toString().toDouble()
                    s = d / (sqrt(2.0))
                    P = (4 * s).toDouble()
                    A = (s * s).toDouble()

                    ResultView.text = "\nDiagonal was given as $d \n" +
                            "Side is $s \n" + "Perimeter is $P \n" +
                            "Area is $A square unit of measurement"
                } else {
                    editText = root.findViewById(R.id.PerimeterSDecimal)

                    if ((editText.text.toString().length > 0)) {
                        P = editText.text.toString().toDouble()
                        s = P / 4
                        d = (sqrt(2.0)) * s
                        A = (s * s).toDouble()

                        ResultView.text = "\nPerimeter was given as $P \n" +
                                "Side is $s \n" + "Diagonal is $d \n" +
                                "Area is $A square unit of measurement"
                    } else {
                        editText = root.findViewById(R.id.AreaSDecimal)

                        if ((editText.text.toString().length > 0)) {
                            A = editText.text.toString().toDouble()
                            s = sqrt(A)
                            d = (sqrt(2.0)) * s
                            P = (4 * s).toDouble()

                            ResultView.text =
                                    "\nArea was given as $A square unit of measurement\n" +
                                            "Side is $s \n" + "Diagonal is $d \n" +
                                            "Perimeter is $P \n"
                        } else {
                            mToast = Toast.makeText(
                                    getActivity(),
                                    "Kindly put a value",
                                    Toast.LENGTH_SHORT
                            )
                            mToast.show()
                        }
                    }
                }
            }
        }
        return root
    }
}