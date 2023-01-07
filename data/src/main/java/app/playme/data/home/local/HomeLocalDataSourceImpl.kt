package app.playme.data.home.local

import android.content.Context
import android.database.Cursor
import android.os.Build
import android.os.Environment
import android.os.Environment.getExternalStoragePublicDirectory
import android.provider.MediaStore
import android.provider.MediaStore.Audio.AudioColumns.IS_MUSIC
import app.playme.model.Song
import javax.inject.Inject

class HomeLocalDataSourceImpl @Inject constructor(
    context: Context
) : HomeLocalDataSource {
    override suspend fun getSongs(): List<Song> {


        return listOf<Song>()
    }
}

private fun addSelectionValues(
    selectionValues: Array<String>?,
    paths: ArrayList<String>
): Array<String> {
    var selectionValuesFinal = selectionValues
    if (selectionValuesFinal == null) {
        selectionValuesFinal = emptyArray()
    }
    val newSelectionValues = Array(selectionValuesFinal.size + paths.size) {
        "n = $it"
    }
    System.arraycopy(selectionValuesFinal, 0, newSelectionValues, 0, selectionValuesFinal.size)
    for (i in selectionValuesFinal.size until newSelectionValues.size) {
        newSelectionValues[i] = paths[i - selectionValuesFinal.size] + "%"
    }
    return newSelectionValues
}

@JvmOverloads
fun makeSongCursor(
    selection: String?,
    selectionValues: Array<String>?,
    sortOrder: String = PreferenceUtil.songSortOrder,
    context: Context
): Cursor? {
    var selectionFinal = selection
    var selectionValuesFinal = selectionValues

    selectionFinal =
        selectionFinal + " AND " + Constants.DATA + " LIKE ?"
    selectionValuesFinal = addSelectionValues(
        selectionValuesFinal, arrayListOf(
            getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).canonicalPath
        )
    )

    val uri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        MediaStore.Audio.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)
    } else {
        MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
    }
    return try {
        context.contentResolver.query(
            uri,
            baseProjection,
            selectionFinal,
            selectionValuesFinal,
            sortOrder
        )
    } catch (ex: SecurityException) {
        return null
    }

}
