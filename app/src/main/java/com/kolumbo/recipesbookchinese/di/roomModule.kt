package com.kolumbo.recipesbookchinese.di

import com.kolumbo.recipesbookchinese.persitence.AppDataBase
import org.koin.dsl.module

val roomModule = module {
    single { AppDataBase.getInstance(get()) }
    single { get<AppDataBase>().getRecipeDao() }
}