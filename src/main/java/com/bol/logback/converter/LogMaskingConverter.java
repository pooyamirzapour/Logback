package com.bol.logback.converter;

//import java.utLogMaskingConverteril.Arrays;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

@Plugin(name = "LogMaskingConverter", category = "Converter")
@ConverterKeys({ "hideKeys" })
public class LogMaskingConverter extends LogEventPatternConverter {

    private static final String KEY_PATTERN = "\"key1\":([^,]+)(|$)";

    protected LogMaskingConverter(String name, String style) {
        super(name, style);
    }

    // This method is used by Log4J's engine. Do not remove it.
    public static LogMaskingConverter newInstance(final Configuration config, final String[] options) {
        return new LogMaskingConverter("hideKeys", Thread.currentThread().getName());
    }

    @Override
    public void format(LogEvent event, StringBuilder outputMessage) {
        String mask = mask(event.getMessage().getFormattedMessage());
        outputMessage.append(mask);

    }

    public static String mask(String json) {

        StringBuilder sb = new StringBuilder(json);
        Pattern pattern = Pattern.compile(KEY_PATTERN);
        Matcher matcher = pattern.matcher(json);
        while (matcher.find()) {
            IntStream.rangeClosed(1, matcher.groupCount()).forEach(group -> {
                if (matcher.group(group) != null) {
                    IntStream.range(matcher.start(group), matcher.end(group)).forEach(i -> sb.setCharAt(i, '*'));
                }
            });
        }
        return sb.toString();
    }
}