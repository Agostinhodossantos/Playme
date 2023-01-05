package app.playme.onboarding

import androidx.compose.animation.*
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun OnBoardingScreen(
    onBoardingFinished: () -> Unit
) {
    OnBoardingContent(viewModel = hiltViewModel(), onBoardingFinished = onBoardingFinished)
}

@Composable
internal fun OnBoardingContent(
    viewModel: OnBoardingViewModel,
    onBoardingFinished: () -> Unit
) {
    val launchDestination: Boolean by viewModel.viewState.collectAsStateWithLifecycle()

    val systemUiController = rememberSystemUiController()
    val onBoardingItemsList = viewModel.getOnBoardingItemsList()
    val pagerState = remember { PagerState() }
    val coroutineScope = rememberCoroutineScope()
    val onBoardingPage = onBoardingItemsList[pagerState.currentPage]
    val backgroundColor by animateColorAsState(
        onBoardingPage.color,
        spring(Spring.DampingRatioLowBouncy, Spring.StiffnessLow)
    )
    if (launchDestination) {
        onBoardingFinished()
    }

    SideEffect {
        systemUiController.setStatusBarColor(
            color = backgroundColor,
            darkIcons = false
        )
        systemUiController.setNavigationBarColor(
            color = Color.White,
            darkIcons = true
        )
    }

    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            color = Color.White
        ) {
            AnimatedVisibility(
                visible = pagerState.currentPage == pagerState.pageCount - 1,
                enter = slideInVertically(initialOffsetY = { -40 }) + expandVertically(
                    expandFrom = Alignment.Top
                ) + fadeIn(initialAlpha = 0.3f)
            ) {
                Button(
                    onClick = {
                        viewModel.getStartedClick()
                    },
                    modifier = Modifier
                        .padding(horizontal = 120.dp)
                        .windowInsetsPadding(WindowInsets.systemBars.only(WindowInsetsSides.Bottom)),
                    shape = MaterialTheme.shapes.small
                ) {
                    Text(
                        text = stringResource(id = R.string.label_lets_go),
                        style = MaterialTheme.typography.body2,
                        color = Color.White
                    )
                }
            }
            AnimatedVisibility(
                visible = pagerState.currentPage != pagerState.pageCount - 1,
                exit = slideOutVertically() + shrinkVertically() + fadeOut()
            ) {
                OnBoardingPager(
                    viewModel = viewModel,
                    pagerState = pagerState,
                    coroutineScope = coroutineScope
                )
            }
        }

        Surface(
            color = backgroundColor,
            modifier = Modifier
                .requiredHeight(600.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(bottomStart = 60.dp, bottomEnd = 60.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .statusBarsPadding()
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(R.drawable.ic_delish_logo),
                        modifier = Modifier
                            .padding(16.dp)
                            .width(80.dp),
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.height(60.dp))

                OnBoardingPager(onBoardingItemsList, pagerState)
            }
        }
    }
}

@Composable
internal fun OnBoardingPager(
    viewModel: OnBoardingViewModel,
    pagerState: PagerState,
    coroutineScope: CoroutineScope
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier =
        Modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.systemBars.only(WindowInsetsSides.Bottom))
            .padding(horizontal = 16.dp)
    ) {
        IconButton(
            modifier = Modifier.align(Alignment.CenterVertically),
            onClick = {
                viewModel.getStartedClick()
            }
        ) {
            Text(
                text = stringResource(id = R.string.label_skip),
                color = MaterialTheme.colors.background,
                style = MaterialTheme.typography.body2
            )
        }

        HorizontalPagerIndicator(
            pagerState = pagerState, modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(16.dp)
        )

        TextButton(
            onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                }
            },
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Text(
                text = stringResource(id = R.string.label_next),
                color = MaterialTheme.colors.background,
                style = MaterialTheme.typography.body2
            )
            Image(
                imageVector = Icons.Outlined.KeyboardArrowRight,
                contentDescription = null
            )
        }
    }
}
