/*
 * Copyright 2010-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.idea.caches

import com.intellij.openapi.vfs.VirtualFile

data class CachedAttributeData<T: Enum<T>>(val value: T?, val timeStamp: Long)

interface FileAttributeService {
    fun register(id: String, version: Int) {}

    fun <T: Enum<T>> writeAttribute(id: String, file: VirtualFile, value: T): CachedAttributeData<T> =
            CachedAttributeData(value, timeStamp = file.timeStamp)

    fun <T: Enum<T>> readAttribute(id: String, file: VirtualFile, klass: Class<T>): CachedAttributeData<T>? = null
}
