package com.kolumbo.recipesbookchinese.ui.favourites

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.lifecycle.Observer
import com.kolumbo.recipesbookchinese.R
import com.kolumbo.recipesbookchinese.base.BaseFragment
import com.kolumbo.recipesbookchinese.extension.gone
import com.kolumbo.recipesbookchinese.extension.visible
import com.kolumbo.recipesbookchinese.persitence.RecipeDB
import com.kolumbo.recipesbookchinese.ui.adapter.favourites.RecipeFavouritesAdapter
import com.kolumbo.recipesbookchinese.ui.web.WebViewActivity
import com.kolumbo.recipesbookchinese.viewmodel.FavouritesRecipeViewModel
import kotlinx.android.synthetic.main.favourites_fragment.*
import org.jetbrains.anko.support.v4.toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavouritesFragment : BaseFragment(), RecipeFavouritesAdapter.OnItemClickListener {

    private val recipeFavouritesAdapter = RecipeFavouritesAdapter(arrayListOf(), this)
    private val model by viewModel<FavouritesRecipeViewModel>()

    @LayoutRes
    override fun getLayoutResId() = R.layout.favourites_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observe()
        model.loadRecipesPersistence()
    }

    private fun setupRecyclerView() {
        fragment_favourites_recycler_view.adapter = recipeFavouritesAdapter
    }

    private fun observe() {
        model.recipes.observe(this,
            Observer<List<RecipeDB>> {
                it?.let {
                    if (it.isNotEmpty()) {
                        showNormalState()
                        recipeFavouritesAdapter.replaceData(it)
                    } else {
                        showEmptyState()
                    }
                }
            })
    }

    private fun showEmptyState() {
        fragment_favourites_recycler_view.gone()
        favourites_view_empty.visible()
    }

    private fun showNormalState() {
        fragment_favourites_recycler_view.visible()
        favourites_view_empty.gone()
    }

    override fun onDeleteClick(recipeDB: RecipeDB) {
        recipeDB.let {
            model.deleteRecipePersistence(recipeDB)
            toast(recipeDB.title + " " + getString(R.string.deleted_favs))
        }
    }

    override fun onRecipeRowClicked(href: String) {
        activity?.let { WebViewActivity.createIntent(it, href) }?.let { openActivity(it) }
    }
}