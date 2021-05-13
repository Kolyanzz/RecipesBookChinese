package com.kolumbo.recipesbookchinese.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.kolumbo.recipesbookchinese.R
import kotlinx.android.synthetic.main.layout_custom_lable.view.*

class LabelCustomView : LinearLayout {
    var labelText: String? = null

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {


        LayoutInflater.from(context).inflate(R.layout.layout_custom_lable, this, true)

        attrs?.let {

            val typedArray = context?.obtainStyledAttributes(attrs, R.styleable.LabelCustomView, 0, 0)
            labelText = typedArray?.getString(R.styleable.LabelCustomView_labelText)

            updateView()

            typedArray?.recycle()
        }
    }

    private fun updateView() {
        label_text.text = labelText
    }
}