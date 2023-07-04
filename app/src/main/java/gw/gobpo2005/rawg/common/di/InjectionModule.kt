package gw.gobpo2005.rawg.common.di

import org.koin.core.module.Module

interface InjectionModule {
    fun onCreate(): Module
}