package com.novatech.contactsmanager.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    // suspend is a keyword used for executing a long running operation
    // function that can be paused and resumed
    @Insert
    suspend fun insertUser(user: User) : Long

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("delete from user")
    suspend fun deleteAll()

    @Query("select * from user")
    fun getAllUsersInDB() : LiveData<List<User>>
}
