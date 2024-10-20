package com.example.visitcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.visitcard.ui.theme.VisitCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VisitCardTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    VisitCard()
                }
            }
        }
    }
}

@Composable
fun VisitCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo ),
            contentDescription = "Logo",
            modifier = modifier
                .size(100.dp)
                .padding(bottom = 16.dp),
            contentScale = ContentScale.Crop
        )

        Text(
            text = stringResource(R.string.name),
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold
            ),
            modifier = modifier.padding(bottom = 8.dp)
        )
        Text(
            text = stringResource(R.string.title),
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color.Gray
            ),
            modifier = modifier.padding(bottom = 32.dp)
        )

        ContactDetails(icon = R.drawable.ic_phone, contactDetails = stringResource(R.string.telephone))
        ContactDetails(icon = R.drawable.ic_social_media, contactDetails = stringResource(R.string.social_media))
        ContactDetails(icon = R.drawable.ic_email, contactDetails = stringResource(R.string.email))
    }
}


@Composable
fun ContactDetails(icon: Int, contactDetails: String, modifier: Modifier = Modifier){
    Row(
        modifier = modifier
            .width(200.dp)
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = contactDetails, style = MaterialTheme.typography.bodyMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    VisitCardTheme {
        VisitCard()
    }
}