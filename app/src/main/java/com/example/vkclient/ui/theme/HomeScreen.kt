package com.example.vkclient.ui.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.vkclient.MainViewModel


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(viewModel: MainViewModel, paddingValues: PaddingValues){

    val feedPosts = viewModel.feedPosts.observeAsState(listOf())

    LazyColumn(
        contentPadding = PaddingValues(
            top = 16.dp, start = 8.dp,
            end = 8.dp, bottom = 72.dp,
        ), verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        items(
            items = feedPosts.value,
            key = { it.id }
        ) { feedPost ->
            val dismissState = rememberSwipeToDismissBoxState()
            if (dismissState.dismissDirection == SwipeToDismissBoxValue.EndToStart){
                viewModel.remove(feedPost)
            }
            SwipeToDismissBox(
                modifier = Modifier.animateItemPlacement(),
                enableDismissFromStartToEnd = false,
                state = dismissState,
                backgroundContent = {},
                content = {
                    PostCard(
                        feedPost = feedPost,
                        onShareClickListener = { statisticsItem ->
                            viewModel.updateCount(feedPost = feedPost, item = statisticsItem)
                        },
                        onCommentClickListener = { statisticsItem ->
                            viewModel.updateCount(feedPost = feedPost, item = statisticsItem)
                        },
                        onViewsClickListener = { statisticsItem ->
                            viewModel.updateCount(feedPost = feedPost, item = statisticsItem)
                        },
                        onLikeClickListener = { statisticsItem ->
                            viewModel.updateCount(feedPost = feedPost, item = statisticsItem)
                        },
                    )
                }
            )

        }
    }

}
