/*
 * This file is part of Seeneva Android Reader
 * Copyright (C) 2021 Sergei Solodovnikov
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package app.seeneva.reader.data.source.local.db.entity

import androidx.room.Embedded
import androidx.room.Relation
import app.seeneva.reader.data.entity.ComicBookPage
import app.seeneva.reader.data.entity.ComicPageObject

data class ComicBookPageWithObjects(
    @Embedded val page: ComicBookPage,
    @Relation(
        parentColumn = ComicBookPage.COLUMN_ID,
        entityColumn = ComicPageObject.COLUMN_PAGE_ID
    )
    val objects: List<ComicPageObject>,
)

/**
 * Map from [ComicBookPageWithObjects] to [ComicBookPage]
 */
internal fun ComicBookPageWithObjects.intoPublic() =
    page.copy(objects = objects)