package com.example.daval.cleanrecyclerview.cardSetup.presentation.models

import com.example.daval.cleanrecyclerview.base.BaseAdapter

class DataListDialog<T>(
    val title: String?,
    val adapter: BaseAdapter<T, *>?,
    val listData: List<T>?,
    val btnClose: Boolean,
) {

    private constructor(builder: Builder<T>) : this(
        builder.title,
        builder.adapter,
        builder.listData,
        builder.btnClose
    )

    class Builder<T> {
        var title: String? = null
            private set

        var adapter: BaseAdapter<T, *>? = null
            private set

        var listData: List<T>? = null
            private set

        var btnClose: Boolean = false
            private set

        fun title(title: String) = apply { this.title = title }
        fun adapter(adapter: BaseAdapter<T, *>) = apply { this.adapter = adapter }
        fun listData(listData: List<T>) = apply { this.listData = listData }
        fun btnClose(btnClose : Boolean) = apply { this.btnClose = btnClose }
        fun build() = DataListDialog<T>(this)
    }

}