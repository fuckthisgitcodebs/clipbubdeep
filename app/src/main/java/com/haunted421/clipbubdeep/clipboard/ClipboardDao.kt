package com.haunted421.clipbubdeep.clipboard

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ClipboardDao {
@Insert
suspend fun insert(entry: ClipboardEntry)

}
