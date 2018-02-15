package cn.nextours.springboot.wopi.domain

data class WopiLock(var filename: String = "",
                    var lock: String = "",
                    var lastTime: Long = 0L)