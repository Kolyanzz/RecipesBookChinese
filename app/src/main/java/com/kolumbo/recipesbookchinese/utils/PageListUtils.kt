package com.kolumbo.recipesbookchinese.utils

import androidx.paging.PagedList

fun pagedListConfig() = PagedList.Config.Builder()
    .setInitialLoadSizeHint(5)
    .setEnablePlaceholders(false)
    .setPageSize(5 * 2)
    .build()