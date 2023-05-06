package pe.edu.upc.digitalholics.appmobile.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PatientEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun patientDao() : PatientDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            INSTANCE = Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "theraphy.db"
            )
                .allowMainThreadQueries()
                .build()
            return INSTANCE as AppDatabase
        }
    }
}