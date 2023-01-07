package app.playme.com.presentation.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.playme.compose.theme.background800
import app.playme.compose.ui.AsyncImage
import app.playme.model.Song
import app.playme.songs.R

@Composable
fun TopPlayer(
    modifier: Modifier = Modifier,
    song: Song,
    onClick: (String) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .background(background800, RoundedCornerShape(8.dp))
    ) {
        Row(
            Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
           Row(
               verticalAlignment = Alignment.CenterVertically
           ) {
               AsyncImage(
                   model = song.uri ?: "",
                   requestBuilder = { crossfade(true) },
                   contentDescription = "Music image",
                   contentScale = ContentScale.Crop,
                   modifier = Modifier
                       .size(50.dp)
                       .clip(MaterialTheme.shapes.medium)
               )
               Column(
                   verticalArrangement = Arrangement.SpaceAround,
                   modifier = Modifier.padding(start = 10.dp)
               ) {
                   Text(text = song.title, fontWeight = FontWeight.W700, fontSize = 13.sp)
                   Text(text = song.author, fontSize = 11.sp)
               }
           }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    imageVector = Icons.Rounded.PlayArrow,
                    contentDescription = stringResource(R.string.cd_play),
                    contentScale = ContentScale.Fit,
                    colorFilter = ColorFilter.tint(LocalContentColor.current),
                    modifier = Modifier
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(bounded = false, radius = 24.dp)
                        ) { onClick(song.uri) }
                        .size(48.dp)
                        .padding(6.dp)
                )
            }

        }
    }

}