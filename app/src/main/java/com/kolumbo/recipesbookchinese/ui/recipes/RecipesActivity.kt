package com.kolumbo.recipesbookchinese.ui.recipes

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.kolumbo.recipesbookchinese.R
import com.kolumbo.recipesbookchinese.base.BaseActivity
import com.kolumbo.recipesbookchinese.base.BaseFragment
import com.kolumbo.recipesbookchinese.ui.favourites.FavouritesActivity
import kotlinx.android.synthetic.main.activity_main_recipes.*

class RecipesActivity : BaseActivity(false) {

    @LayoutRes
    override fun getLayoutResId() = R.layout.activity_main_recipes

    override fun fragment(): BaseFragment = RecipesFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupClickButton()
    }

    private fun setupClickButton() {
        fab_favourites.setOnClickListener {
            this.startActivity(
                FavouritesActivity.createIntent(this)
            )
        }
    }
}
