package me.kakutalua.website.infrastructure.services

import com.vladsch.flexmark.html.HtmlRenderer
import com.vladsch.flexmark.parser.Parser
import org.springframework.stereotype.Component

@Component
class MarkdownToHtmlRenderer {
    fun renderToHtml(markdownText: String): String {
        val parser = Parser.builder().build()
        val htmlRenderer = HtmlRenderer.builder().build()

        return htmlRenderer.render(parser.parse(markdownText))
    }
}