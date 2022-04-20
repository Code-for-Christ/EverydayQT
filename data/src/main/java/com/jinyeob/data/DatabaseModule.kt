package com.jinyeob.data

import android.content.Context
import androidx.room.Room
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class DatabaseModule {
    @Provides
    @Singleton
    fun providesKotlinJsonAdapterFactory(): KotlinJsonAdapterFactory = KotlinJsonAdapterFactory()

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): MyDatabase =
        Room.databaseBuilder(
            context,
            MyDatabase::class.java,
            "eqt.db"
        ).build()

    @Provides
    @Singleton
    fun providesMoshi(
        jsonAdapter: KotlinJsonAdapterFactory
    ): Moshi = Moshi
        .Builder()
        .add(jsonAdapter)
        .build()

    @Provides
    @Singleton
    fun providesMoshiConverter(
        moshi: Moshi
    ): MoshiConverterFactory = MoshiConverterFactory.create(moshi)
}
