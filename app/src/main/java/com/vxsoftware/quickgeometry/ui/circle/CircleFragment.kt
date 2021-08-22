package com.vxsoftware.quickgeometry.ui.circle

import android.annotation.SuppressLint
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

class CircleFragment : Fragment() {

    private lateinit var circleViewModel: CircleViewModel
    var PI = 3.14
    var r = 3.14
    var d = 3.14
    var C = 3.14
    var A = 3.14


    @SuppressLint("CutPasteId")
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        circleViewModel =
                ViewModelProvider(this).get(CircleViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_circle, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        circleViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        var ResultView: TextView = root.findViewById(R.id.ResultView)

        // get reference to button
        val btn_click_me = root.findViewById(R.id.calcbutton) as Button
        var editText: EditText

        var r: Double
        var d: Double
        var C: Double
        var A: Double

        // set on-click listener
        btn_click_me.setOnClickListener {
            var mToast = Toast.makeText(getActivity(), "Calculating", Toast.LENGTH_SHORT)
            mToast.show()
            // your code to perform when the user clicks on the button
            //Toast.makeText (this@CircleFragment, "You clicked me.", Toast.LENGTH_SHORT).show()

            editText = root.findViewById(R.id.RadiusCDecimal)
            if ((editText.text.toString().length > 0)) {
                r = editText.text.toString().toDouble()
                d = 2 * r
                C = (2 * r * 3.14).toDouble()
                A = (r * r * 3.14).toDouble()

                ResultView.text = "\nRadius was given as $r \n" +
                        "Diameter is $d \n" + "Circumference is $C \n" +
                        "Area is $A square unit of measurement"

            } else {
                editText = root.findViewById(R.id.DiameterCDecimal)

                if ((editText.text.toString().length > 0)) {
                    d = editText.text.toString().toDouble()
                    r = d / 2
                    C = (2 * r * 3.14).toDouble()
                    A = (r * r * 3.14).toDouble()

                    ResultView.text = "\nDiameter was given as $d \n" +
                            "Radius is $r \n" + "Circumference is $C \n" +
                            "Area is $A square unit of measurement"
                } else {
                    editText = root.findViewById(R.id.CrDecimal)

                    if ((editText.text.toString().length > 0)) {
                        C = editText.text.toString().toDouble()
                        r = C / (2 * 3.14)
                        d = 2 * r
                        A = (r * r * 3.14).toDouble()

                        ResultView.text = "\nCircumference was given as $C \n" +
                                "Radius is $r \n" + "Diameter is $d \n" +
                                "Area is $A square unit of measurement"
                    } else {
                        editText = root.findViewById(R.id.AreaCDecimal)

                        if ((editText.text.toString().length > 0)) {
                            A = editText.text.toString().toDouble()
                            r = sqrt(A / 3.14)
                            d = 2 * r
                            C = (2 * r * 3.14).toDouble()

                            ResultView.text =
                                "\nArea was given as $A square unit of measurement\n" +
                                        "Radius is $r \n" + "Diameter is $d \n" +
                                        "Circumference is $C"
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