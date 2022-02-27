package com.example.charles.tablayouttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TableRow
import android.widget.TextView
import com.example.charles.tablayouttest.databinding.ActivityMainBinding

import android.R.color
import android.view.ViewGroup
import android.widget.TableLayout

class MainActivity : AppCompatActivity() {

    private lateinit var activityBinder: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinder = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityBinder.root)

        activityBinder.add.setOnClickListener {
            val androidVersion:String = activityBinder.version.text.toString()
            var androidCodeName = activityBinder.name.text.toString()

            val tableRow = TableRow(this@MainActivity)
            val tableRowParams = TableRow.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT
            ).also {
                it.topMargin = 2
                it.bottomMargin = 2
            }
            tableRow.layoutParams = tableRowParams

            tableRow.setBackgroundColor(resources.getColor(color.holo_red_dark))

            val leftCol = TextView(this@MainActivity)
//            leftCol.layoutParams = LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT
//            )
            leftCol.text = androidVersion

            val rightCol = TextView(this@MainActivity)
//            rightCol.layoutParams = LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT
//            )
            rightCol.text = androidCodeName

            val divider = View(this@MainActivity)
//            val dividerParams = ViewGroup.LayoutParams(1,
//                ViewGroup.LayoutParams.WRAP_CONTENT
//            )
//            divider.layoutParams = dividerParams
            divider.setBackgroundColor(resources.getColor(color.black))


            tableRow.addView(leftCol,0)
            tableRow.addView(divider,1)
            tableRow.addView(rightCol,2)

            activityBinder.tableLayout.addView(tableRow)


        }
    }
}