package cn.nextours.springboot.wopi.domain

import cn.nextours.springboot.annotation.OpenForSpringAnnotation
import org.springframework.stereotype.Repository

@OpenForSpringAnnotation
@Repository("defaultLockRepository")
class DefaultLockRepository : LockRepository {

    private val locks = HashMap<String, WopiLock>()

    override fun save(filename: String, lock: String, lastTime: Long) {
        locks[filename] = WopiLock(filename, lock, lastTime)
    }

    override fun update(filename: String, lock: String, lastTime: Long) {
        locks[filename] = WopiLock(filename, lock, lastTime)
    }

    override fun findOne(filename: String): WopiLock? {
        val filter = locks.filter { entry ->
            entry.key == filename
        }
        return if (filter.isNotEmpty()) filter[filename] else null
    }

    override fun delete(filename: String) {
        locks.remove(filename)
    }
}