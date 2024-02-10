package me.xtopz.bookstore.bookservice.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.i18n.SessionLocaleResolver
import java.util.Locale

@Configuration
class LocaleConfig {

    @Bean
    fun localResolver(): LocaleResolver {
        val localeResolver = SessionLocaleResolver()

        localeResolver.setDefaultLocale(Locale.forLanguageTag("ru"))

        return localeResolver
    }

    @Bean
    fun resourceBundleMessageSource(): ResourceBundleMessageSource {
        val messageSource = ResourceBundleMessageSource()

        messageSource.setBasename("locale")
        messageSource.setUseCodeAsDefaultMessage(true)

        return messageSource
    }

}