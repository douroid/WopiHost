package cn.nextours.springboot.wopi.domain

interface LockRepository {

    fun save(filename: String, lock: String, lastTime: Long)

    fun update(filename: String, lock: String, lastTime: Long)

    fun findOne(filename: String): WopiLock?

    fun delete(filename: String)
}