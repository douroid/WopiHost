package cn.nextours.springboot.wopi.service

import cn.nextours.springboot.annotation.OpenForSpringAnnotation
import cn.nextours.springboot.wopi.ConflictException
import cn.nextours.springboot.wopi.domain.LockRepository
import cn.nextours.springboot.wopi.domain.WopiLock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@OpenForSpringAnnotation
@Service
class LockService {

    @Autowired
    @Qualifier("defaultLockRepository")
    private var lockRepository: LockRepository? = null

    fun lock(filename: String, lock: String) {
        val l = lockRepository?.findOne(filename)
        val currentTimeMillis = System.currentTimeMillis()
        if (l == null) {
            lockRepository?.save(filename, lock, currentTimeMillis)
        } else if (l.lock == lock
                || currentTimeMillis - l.lastTime > LOCK_EXPIRE) {
            lockRepository?.update(filename, lock, currentTimeMillis)
        } else {
            throw ConflictException("lock mismatch", l.lock)
        }
    }

    fun unlock(filename: String, lock: String) {
        val l = lockRepository?.findOne(filename)
        if (l == null || l.lock != lock) {
            throw ConflictException("lock mismatch", l?.lock ?: "")
        } else {
            lockRepository?.delete(filename)
        }
    }

    fun getLock(filename: String): WopiLock? {
        return lockRepository?.findOne(filename)
    }

    fun refreshLock(filename: String, lock: String) {
        val l = lockRepository?.findOne(filename)
        val currentTimeMillis = System.currentTimeMillis()
        if (l == null
                || (l.lock != lock && currentTimeMillis - l.lastTime <= LOCK_EXPIRE)) {
            throw ConflictException("lock mismatch", l?.lock ?: "")
        } else {
            lockRepository?.update(filename, lock, System.currentTimeMillis())
        }
    }

    fun unlockAndRelock(filename: String, lock: String, oldLock: String?) {
        val l = lockRepository?.findOne(filename)
        if (l == null || l.lock != oldLock) {
            throw ConflictException("lock mismatch", l?.lock ?: "")
        } else {
            lockRepository?.update(filename, lock, System.currentTimeMillis())
        }
    }

    companion object {
        private const val LOCK_EXPIRE = 30 * 60 * 1000L//30 minutes
    }
}