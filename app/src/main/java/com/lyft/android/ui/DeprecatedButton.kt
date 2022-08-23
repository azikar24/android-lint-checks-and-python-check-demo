package com.lyft.android.ui

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

/**
 * An old custom button class that is now deprecated.
 *
 * A `DeprecatedButtonXmlDetector` custom lint check has been written to prohibit new
 * usages of this button class in layout XML.
 *
 * A `DeprecatedButtonJavaKotlinDetector` has also been written to prohibit new
 * instances of this class from being instantiated programatically.
 */
class DeprecatedButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : AppCompatButton(context, attrs)