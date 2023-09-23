package com.esslinger.msu.geoquizhw3

import androidx.annotation.StringRes

data class Question(@StringRes val textResId: Int, val answer: Boolean,  var answered: Boolean = false)