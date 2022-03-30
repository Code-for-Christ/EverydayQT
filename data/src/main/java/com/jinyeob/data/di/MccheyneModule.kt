package com.jinyeob.data.di

import com.jinyeob.data.MyDatabase
import com.jinyeob.data.model.MccheyneLocalDataSource
import com.jinyeob.data.repository.MccheyneRepositoryImpl
import com.jinyeob.domain.repository.MccheyneRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface MccheyneModule {
    @Binds
    @Singleton
    fun bindsRepository(mccheyneRepositoryImpl: MccheyneRepositoryImpl): MccheyneRepository

    companion object {
        @Provides
        @Singleton
        fun providesLocalDataSource(database: MyDatabase): MccheyneLocalDataSource =
            database.getMccheyneLocalDataSource()
    }
}
