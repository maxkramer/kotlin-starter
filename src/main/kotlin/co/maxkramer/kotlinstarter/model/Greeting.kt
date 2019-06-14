package co.maxkramer.kotlinstarter.model

data class Greeting(
    private val name: String,
    private val messageFormat: String
) {
    var renderedMessage = messageFormat.format(name)
}
