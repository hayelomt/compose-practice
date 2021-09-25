package com.example.composeapplication.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun Screen() {


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(20.dp)
            .border(
                BorderStroke(1.dp, Color.Red),
                RoundedCornerShape(
                    topStartPercent = 30,
                    topEndPercent = 30,
                    bottomEndPercent = 30,
                    bottomStartPercent = 30,
                )
            )
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (centerRef, redRef) = createRefs()

            Box(
                modifier = Modifier.size(1.dp)
                    .constrainAs(centerRef) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {

            }

            Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .constrainAs(redRef) {
                    circular(centerRef, 0f, 115.dp)
//                    top.linkTo(redBoxRef.bottom, margin = 20.dp)
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
                }
            ) {}
        }
    }
//    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
//        val (redBoxRef, blueBoxRef) = createRefs()
//
//        Box(
//            modifier = Modifier
//                .size(100.dp)
//                .background(Color.Red)
//                .constrainAs(redBoxRef) {
//                    top.linkTo(parent.top)
//                    bottom.linkTo(parent.bottom)
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                }
//        ) {}
//        Box(
//            modifier = Modifier
//                .size(100.dp)
//                .background(Color.Blue)
//                .constrainAs(blueBoxRef) {
//                    circular(redBoxRef, 45f, 200.dp)
////                    top.linkTo(redBoxRef.bottom, margin = 20.dp)
////                    start.linkTo(parent.start)
////                    end.linkTo(parent.end)
//                }
//        )
//    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScreen() {
    Screen()
}