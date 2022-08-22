package com.example.daval.cleanrecyclerview.cardSetup.presentation.models

class SimpleDialog(
    val image: Int?,
    val title: String?,
    val message: String?,
    val subTitle: String?,
    val btnConfirm: String?,
    val btnCancel: String?
) {
    private constructor(builder: Builder) : this(
        builder.image,
        builder.title,
        builder.message,
        builder.subTitle,
        builder.btnConfirm,
        builder.btnCancel

    )

    class Builder {
        var image: Int? = null
            private set

        var title: String? = null
            private set

        var message: String? = null
            private set

        var subTitle: String? = null
            private set

        var btnConfirm: String? = null
            private set

        var btnCancel: String? = null
            private set

        fun image(image: Int) = apply { this.image = image }
        fun title(title: String) = apply { this.title = title }
        fun message(message: String) = apply { this.message = message }
        fun subTitle(subTitle: String) = apply { this.subTitle = subTitle }
        fun btnConfirm(btnConfirm: String) = apply { this.btnConfirm = btnConfirm }
        fun btnCancel(btnCancel: String) = apply { this.btnCancel = btnCancel }
        fun build() = SimpleDialog(this)
    }
}