package com.novatech.contactsmanager.room

// repository provide access to multiple data sources
// provides a clean API for data access to the rest of the application
// implements the logic to pull in data from network or local DB
class UserRepository(private val dao: UserDao) {

    val users = dao.getAllUsersInDB()

    suspend fun insert(user: User): Long {
        return dao.insertUser(user)
    }

    suspend fun delete(user: User) {
        return dao.deleteUser(user)
    }

    suspend fun update(user: User) {
        return dao.updateUser(user)
    }

    suspend fun deleteAll() {
        return dao.deleteAll()
    }
}