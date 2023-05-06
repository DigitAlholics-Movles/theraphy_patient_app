package pe.edu.upc.digitalholics.appmobile.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PatientDao {
    @Query("select * from Patient where id=:id")
    suspend fun getPatientById(id: String) : List<PatientEntity>?

    @Insert
    suspend fun insert(patientEntity: PatientEntity)

    @Delete
    suspend fun delete(patientEntity: PatientEntity)

}