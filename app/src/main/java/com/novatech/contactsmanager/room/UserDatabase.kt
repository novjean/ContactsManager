package com.novatech.contactsmanager.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract val userDao: UserDao

    // singleton is a design pattern that is used mainly in DB and connectivity that
    // creates only one instance of the object during runtime
    // in kotlin, singletons are created using companion object

    // singleton design pattern is what is below
    // reduces memory leaks, better connection time
    companion object {
        // volatile annotation immediately makes the field available to other threads
        @Volatile
        private var INSTANCE: UserDatabase? =
            null //if the class is already made, return that object otherwise create

        fun getInstance(context: Context): UserDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    // creating the database object
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "users_db"
                    ).build()
                }

                return instance
            }
        }
    }
}