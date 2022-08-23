package com.lyft.android.lint.checks

import com.android.resources.ResourceType
import com.android.tools.lint.detector.api.*
import org.jetbrains.uast.UElement

/**
 * A custom lint check that prohibits usages of the `R.color.deprecated_purple`
 * color resource in Java and Kotlin code.
 */
class DeprecatedPurpleColorJavaKotlinDetector : Detector(), SourceCodeScanner {

    companion object {
        val ISSUE = Issue.create(
            id = "DeprecatedPurpleColorJavaKotlin",
            briefDescription = "Don't use the `deprecated_purple` color resource",
            explanation = "The `deprecated_purple` color resource is deprecated and should not be used",
            category = Category.CORRECTNESS,
            severity = Severity.ERROR,
            implementation = Implementation(
                DeprecatedPurpleColorJavaKotlinDetector::class.java,
                Scope.JAVA_FILE_SCOPE
            )
        )
    }

    override fun appliesToResourceRefs(): Boolean {
        // Return true to ensure lint will analyze references to Android resources made
        // in Java and Kotlin code.
        return true
    }

    override fun visitResourceReference(
        context: JavaContext,
        node: UElement,
        type: ResourceType,
        name: String,
        isFramework: Boolean
    ) {
        if (type != ResourceType.COLOR) {
            // Ignore the resource reference if it isn't a color resource.
            return
        }
        if (isFramework) {
            // Ignore the resource reference if this is a color resource from the Android framework
            // (i.e. `android.R.color.***`).
            return
        }
        if (name != "deprecated_purple") {
            // Finally, ignore the resource reference if it isn't named "deprecated_purple".
            return
        }

        context.report(
            issue = ISSUE,
            scope = node,
            location = context.getLocation(node),
            message = "`R.color.deprecated_purple` should not be used."
        )
    }
}