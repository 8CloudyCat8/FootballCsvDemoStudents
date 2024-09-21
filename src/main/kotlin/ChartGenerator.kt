import org.knowm.xchart.PieChartBuilder
import org.knowm.xchart.SwingWrapper
import model.Player

fun generateCountryDistributionChart(players: List<Player>) {
    val countryCounts = players.groupingBy { it.nationality }.eachCount()
    val chart = PieChartBuilder().title("Доля игроков из разных стран").build()

    countryCounts.forEach { (country, count) ->
        chart.addSeries(country, count.toDouble())
    }

    SwingWrapper(chart).displayChart()
}