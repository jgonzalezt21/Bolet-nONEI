package jgonzalezt.onei.boletin.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Menu(
    @StringRes
    val stringResourceId: Int,
    @DrawableRes
    val imageResourceId: Int
)