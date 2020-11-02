package i.maze.cryptotools

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onStart() {
        super.onStart()
        am_slider.addOnChangeListener { _, value, _ ->
            fCalculation(value.toDouble())
        }
        am_slider_2.addOnChangeListener { _, value, _ ->
            fCalculation(value.toDouble())
        }
        cal.setOnClickListener {
            if (per.text?.isNotEmpty()!!) {
                fCalculation(per.text.toString().toDouble())
            } else {
                fCalculation(0.0)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun fCalculation(value: Double) {
        val num = "%.2f".format(value)
        am_percent_tv.text = getString(R.string.percentage) + "  " + num + "%"
        if (!org.text.isNullOrEmpty()) {
            am_priceUp_tv.text = getString(
                R.string.original_price_change_1_s
            ) + "  " + fAbsoluteDifference(org.text!!.toString().toDouble(), num.toDouble())
            fCompound(org.text!!.toString().toDouble(), num.toDouble())
        }
        if (!org.text.isNullOrEmpty() && !chan.text.isNullOrEmpty()) {
            am_priceDOWN_tv.text = getString(
                R.string.percentage_changed_1_s
            ) + "  " + fDifference(
                org.text.toString().toDouble(),
                chan.text.toString().toDouble()
            ) + '%'
        }
    }

    private fun fAbsoluteDifference(num: Double, per: Double): String {
        return ((per * num) / 100).toString()

    }

    private fun fDifference(original: Double, changed: Double): String {
        return (((changed - original) / original) * 100).toFloat().toString()
    }

    private fun fCompound(x: Double, y: Double) {
        val mComp = fAbsoluteDifference(x, y).toDouble()
        am_comp_up_tv.text = (x + mComp).toString()
        am_comp_down_tv.text = (x - mComp).toString()
    }
}
