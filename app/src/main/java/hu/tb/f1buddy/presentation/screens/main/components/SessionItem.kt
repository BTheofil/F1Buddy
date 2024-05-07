package hu.tb.f1buddy.presentation.screens.main.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import hu.tb.network.domain.model.Session
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun SessionItem(
    modifier: Modifier = Modifier,
    dateStart: LocalDate,
    dateEnd: LocalDate,
) {
    Card(
        modifier = modifier,
        onClick = { /*TODO*/ }) {
        Column {
            Text(
                text = dateStart.dayOfMonth.toString() + "-" + dateEnd.dayOfMonth.toString()
            )
        }
    }
}

@Preview
@Composable
private fun SessionItemPreview() {

    val testSessionData = Session(
        circuitKey = 7,
        circuitShortName = "Spa-Francorchamps",
        countryCode = "BEL",
        countryKey = 16,
        countryName = "Belgium",
        dateEnd = LocalDate.parse(
            "2023-07-29T15:35:00+00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX")
        ),
        dateStart = LocalDate.parse(
            "2023-07-29T15:35:00+00:00",
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX")
        ),
        gmtOffset = "02:00:00",
        location = "Spa-Francorchamps",
        meetingKey = 1216,
        sessionKey = 9140,
        sessionName = "Sprint",
        sessionType = "Race",
        year = 2023
    )

    SessionItem(
        dateStart = testSessionData.dateStart,
        dateEnd = testSessionData.dateEnd
    )
}