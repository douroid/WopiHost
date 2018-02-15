package cn.nextours.springboot.wopi.domain

data class WopiCheckFileInfo(var baseFileName: String = "",
                             var userId: String = "",
                             var ownerId: String = "",
                             var version: String = "",
                             var size: Long = 0L,
                             var supportsLocks: Boolean = true,
                             var supportsGetLock: Boolean = true,
                             var supportsUpdate: Boolean = true,
                             var userCanWrite: Boolean = true,
                             var userCanNotWriteRelative: Boolean = false)