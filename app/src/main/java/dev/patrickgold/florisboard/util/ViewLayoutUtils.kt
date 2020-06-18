/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.patrickgold.florisboard.util

import android.view.View
import android.view.Window
import android.widget.FrameLayout
import android.widget.LinearLayout

/**
 * This file has been taken from the Android LatinIME project. Following modifications were done to
 * the original source code:
 * - Convert the code from Java to Kotlin
 * - Change package name to match the current project's one
 * - Remove method newLayoutParam()
 * - Remove method placeViewAt()
 * - Remove unnecessary variable params in updateLayoutGravityOf(), lp can directly be used due to
 *    Kotlin's smart cast feature
 * - Remove unused imports
 *
 * The original source code can be found at the following location:
 *  https://android.googlesource.com/platform/packages/inputmethods/LatinIME/+/refs/heads/master/java/src/com/android/inputmethod/latin/utils/ViewLayoutUtils.java
 */
object ViewLayoutUtils {
    fun updateLayoutHeightOf(window: Window, layoutHeight: Int) {
        val params = window.attributes
        if (params != null && params.height != layoutHeight) {
            params.height = layoutHeight
            window.attributes = params
        }
    }

    fun updateLayoutHeightOf(view: View, layoutHeight: Int) {
        val params = view.layoutParams
        if (params != null && params.height != layoutHeight) {
            params.height = layoutHeight
            view.layoutParams = params
        }
    }

    fun updateLayoutGravityOf(view: View, layoutGravity: Int) {
        val lp = view.layoutParams
        if (lp is LinearLayout.LayoutParams) {
            if (lp.gravity != layoutGravity) {
                lp.gravity = layoutGravity
                view.layoutParams = lp
            }
        } else if (lp is FrameLayout.LayoutParams) {
            if (lp.gravity != layoutGravity) {
                lp.gravity = layoutGravity
                view.layoutParams = lp
            }
        } else {
            throw IllegalArgumentException(
                "Layout parameter doesn't have gravity: "
                        + lp.javaClass.name
            )
        }
    }
}
