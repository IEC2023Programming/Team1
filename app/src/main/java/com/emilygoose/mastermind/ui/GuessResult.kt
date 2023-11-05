package com.emilygoose.mastermind.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.emilygoose.mastermind.ui.theme.ColorDot

@Preview
@Composable
fun GuessResult() {


    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
                modifier = Modifier
                .size(64.dp)
            .padding(0.dp),

//        verticalItemSpacing = 4.dp,
//        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ){
        items(4) {
            ColorDot(
            color = Color.Black,
                modifier = Modifier
                    .size(16.dp)
                    .padding(0.dp),
                onClick = {
                    // Click event with index
//                    onColorClick(index)
                }
            )
        }
    }
//    LazyVerticalGrid(
//        columns = GridCells.Adaptive(minSize = 128.dp)
//    ) {
//        item(
//
////            span = {
//
//            // LazyGridItemSpanScope:
//            // maxLineSpan
//            GridItemSpan(maxLineSpan)
//        )
////        }
//         {
////
//            for (i in 0..3) {
//                ColorDot(
//                    color = Color.White,
//                    modifier = Modifier
//                        .size(64.dp)
//                        .padding(8.dp)
//                )
//            }
//        }
//        // ...
//    }


//    Row {
//        Column (){
//            for (i in 0..1) {
//                ColorDot(
//                    color = Color.White,
//                    modifier = Modifier
//                        .size(64.dp)
//                        .padding(8.dp)
//                )
//            }
//        }
//        Column (){
//            for (i in 0..1) {
//                ColorDot(
//                    color = Color.Black,
//                    modifier = Modifier
//                        .size(64.dp)
//                        .padding(8.dp)
//                )
//            }
//        }
//
//
//
//    }
}


