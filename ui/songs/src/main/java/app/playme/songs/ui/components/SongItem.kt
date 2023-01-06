package app.playme.songs.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.Dimension.Companion.fillToConstraints
import app.playme.compose.PlaymeTheme
import app.playme.model.Music

@Composable
fun SongItem(
    music: Music,
    onClick: (String) -> Unit,
    addPlaylist: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(modifier = modifier.clickable { onClick(music.uri) }) {
        val (
            divider, songTitle, songAuthor, image,
            playIcon, date, addPlaylist, overFlow
        ) = createRefs()

        Divider(
            Modifier.constrainAs(divider) {
                top.linkTo(parent.top)
                centerHorizontallyTo(parent)

                width = fillToConstraints
            }
        )

        AsyncImage(
            model = recipe.image ?: "",
            requestBuilder = { crossfade(true) },
            contentDescription = "Cuisine image",
            modifier = Modifier.fillMaxSize() ,
            contentScale = ContentScale.Crop
        )

    }
}

@Preview
@Composable
fun PreviewEpisodeListItem() {
    var music = Music("1", "url", "Title", "Cover")
    PlaymeTheme() {
        SongItem(
            music = music,
            onClick = { },
            addPlaylist = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}
