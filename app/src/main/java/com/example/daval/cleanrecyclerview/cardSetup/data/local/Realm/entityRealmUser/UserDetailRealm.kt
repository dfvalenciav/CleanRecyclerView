package co.cristian.bizumdialog.data.local.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class UserDetailRealm(
    var name: String = "",
    var userGarbageIcon: String = "",
    var userSmallIcon: String = "",
    @PrimaryKey var id: Long? = 0

):RealmObject()