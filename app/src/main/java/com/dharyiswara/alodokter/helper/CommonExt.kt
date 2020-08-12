package com.dharyiswara.alodokter.helper

import android.graphics.drawable.Drawable
import android.util.Patterns
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.dharyiswara.alodokter.R

inline fun <reified T : Any> clazz() = T::class.java

inline fun <reified T : Any> tag() = T::class.java.simpleName

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

fun String.isEmail(): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun ImageView.loadFromUrl(
    imageUrl: String?,
    placeHolder: Drawable? = ContextCompat.getDrawable(context, R.drawable.ic_no_image)
) {
    val options = RequestOptions()
        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        .priority(Priority.IMMEDIATE)
    Glide.with(this.context)
        .load(imageUrl)
        .placeholder(placeHolder)
        .error(placeHolder)
        .apply(options)
        .into(this)
}