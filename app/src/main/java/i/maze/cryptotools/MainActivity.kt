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
        am_slider.addOnChangeListener { slider, value, fromUser ->
            cal(value.toDouble())
        }
    }

    @SuppressLint("SetTextI18n")
    private fun cal(value: Double) {
        val num = "%.2f".format(value)
        am_percent_tv.text = getString(R.string.percentage) + "  " + num + "%"
        if (!org.text.isNullOrEmpty()) {
            am_priceUp_tv.text = getString(
                R.string.original_price_change_1_s
            ) + "  " + up(org.text!!.toString().toDouble(), num.toDouble())
            comp(org.text!!.toString().toDouble(), num.toDouble())
        }
        if (!org.text.isNullOrEmpty() && !chan.text.isNullOrEmpty()) {
            am_priceDOWN_tv.text = getString(
                R.string.percentage_changed_1_s
            ) + "  " + changed(
                org.text!!.toString().toDouble(),
                chan.text.toString().toDouble()
            ) + '%'
        }
    }

    private fun up(num: Double, per: Double): String {
        return ((per * num) / 100).toFloat().toString()

    }

    private fun changed(orginal: Double, changed: Double): String {
        return (((changed - orginal) / orginal) * 100).toFloat().toString()
    }

    fun comp(x: Double, y: Double) {
        val mComp = up(x, y).toDouble()
        am_comp_up_tv.text = (x + mComp).toString()
        am_comp_down_tv.text = (x - mComp).toString()
    }
}
