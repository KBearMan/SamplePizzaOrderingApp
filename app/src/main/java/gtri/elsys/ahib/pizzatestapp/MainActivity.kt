package gtri.elsys.ahib.pizzatestapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat


class MainActivity : AppCompatActivity()
{
    var customTip = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edittext_subtotal.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                try
                {
                    var subtotal: Double = edittext_subtotal.text.toString().toDouble()
                    edittext_10percenttip.setTwoDecimalText((subtotal*0.1))
                    edittext_10percenttotal.setTwoDecimalText((subtotal*1.1))
                    edittext_15percenttip.setTwoDecimalText((subtotal*0.15))
                    edittext_15percenttotal.setTwoDecimalText((subtotal*1.15))
                    edittext_20percenttip.setTwoDecimalText((subtotal*0.2))
                    edittext_20percenttotal.setTwoDecimalText((subtotal*1.2))
                    edittext_custompercenttip.setTwoDecimalText((subtotal*(customTip/100)))
                    edittext_custompercenttotal.setTwoDecimalText((subtotal + subtotal*(customTip/100)))
                }
                catch(e:NumberFormatException)
                {
                    edittext_10percenttip.setText("")
                    edittext_10percenttotal.setText("")
                    edittext_15percenttotal.setText("")
                    edittext_15percenttip.setText("")
                    edittext_20percenttip.setText("")
                    edittext_20percenttotal.setText("")
                    edittext_custompercenttip.setText("")
                    edittext_custompercenttotal.setText("")
                }
            }
        })

    }
}

private fun EditText.setTwoDecimalText(toString: Double) {
    this.setText(String.format("%.2f",toString))
}
