package app.playme.songs.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.playme.model.Song
import app.playme.songs.ui.components.SearchItem
import app.playme.songs.ui.components.SongItem

@Composable
fun Songs(
    onDetails: (Int) -> Unit,
    onSongs: () -> Unit,
    bottomBarPadding: PaddingValues,
    onSongsSearch: (String) -> Unit
) {
    Songs()
}

@Composable
internal fun Songs(

) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var song = Song("1", "https://i.ibb.co/qyxwYMG/download-1.jpg", "What do you mean", "Cover","","","Justin bieber", "04:00 min")
        var songs = mutableListOf<Song>()
        repeat(40) {
            songs.add(song)
        }
        AnimatedVisibility(visible = true) {
            MusicList(songs) {

            }
        }
    }

}

@Composable
private fun MusicList(
    songs: List<Song>,
    navigateToPlayer: (String) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(0.dp),
        verticalArrangement = Arrangement.Center
    ) {
        item {
            Spacer(modifier = Modifier.height(80.dp))
            HeaderTitle()
        }
        item {
            Spacer(modifier = Modifier.height(20.dp))
            SearchItem(){}
            Spacer(modifier = Modifier.height(30.dp))
        }
        itemsIndexed(songs) { index, item ->
            SongItem(
                song = item,
                onClick = { },
                addPlaylist = {},
                modifier = Modifier.fillMaxWidth(),
                showDivider = (index != 0)
            )
        }
    }
}

@Composable
fun HeaderTitle(modifier: Modifier = Modifier) {
    Text(
        modifier =  modifier.padding(horizontal = 12.dp),
        text = "Find Your Bes Music",
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            color = Color.White
        )
    )
}
