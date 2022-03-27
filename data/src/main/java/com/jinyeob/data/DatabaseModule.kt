package com.jinyeob.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jinyeob.data.model.MccheyneItemEntity
import com.jinyeob.data.model.MccheyneLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Database(
    version = 1,
    entities = [MccheyneItemEntity::class]
)

internal abstract class EqtDatabase : RoomDatabase() {
    abstract fun getMccheyneLocalDataSource(): MccheyneLocalDataSource
}

@Module
@InstallIn(SingletonComponent::class)
internal class DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): EqtDatabase =
        Room.databaseBuilder(
            context,
            EqtDatabase::class.java,
            "eqt.db"
        ).build()
}
