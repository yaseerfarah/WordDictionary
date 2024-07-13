package com.yasser.features.details.presentation.screens.details.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yasser.features.details.domain.entity.WordInfoEntity

@Composable
fun WordInfoItem(
    wordInfo: WordInfoEntity,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = wordInfo.word,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Left,
        )
        Text( modifier = Modifier.fillMaxWidth(),text = wordInfo.phonetic, fontWeight = FontWeight.Light, textAlign = TextAlign.Left,)
        Spacer(modifier = Modifier.height(16.dp))
        Text( modifier = Modifier.fillMaxWidth(),text = wordInfo.origin, textAlign = TextAlign.Left,)

        wordInfo.meanings.forEach { meaning ->
            Text( modifier = Modifier.fillMaxWidth(),text = meaning.partOfSpeech, fontWeight = FontWeight.Bold, textAlign = TextAlign.Left,)
            meaning.definitions.forEachIndexed { i, definition ->
                Text( modifier = Modifier.fillMaxWidth(),text = "${i + 1}. ${definition.definition}", textAlign = TextAlign.Left,)
                Spacer(modifier = Modifier.height(8.dp))
                definition.example?.let { example ->
                    Text( modifier = Modifier.fillMaxWidth(),text = "Example: $example", textAlign = TextAlign.Left,)
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}