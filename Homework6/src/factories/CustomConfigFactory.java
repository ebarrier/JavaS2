package factories;

import java.net.URI;
import java.util.logging.Filter;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.appender.RollingFileAppender;
import org.apache.logging.log4j.core.appender.rolling.RolloverStrategy;
import org.apache.logging.log4j.core.appender.rolling.TriggeringPolicy;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Order;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;
import org.apache.logging.log4j.core.config.plugins.Plugin;

@Plugin(name = "CustomConfigurationFactory", category = ConfigurationFactory.CATEGORY)
@Order(50)
public class CustomConfigFactory extends ConfigurationFactory {

	static Configuration createConfiguration(final String config, ConfigurationBuilder<BuiltConfiguration> builder) {
		builder.setConfigurationName(config);
		builder.setStatusLevel(Level.DEBUG);

		AppenderComponentBuilder appendConsole = builder.newAppender("CONSOLE", "CONSOLE").addAttribute("target",
				ConsoleAppender.Target.SYSTEM_OUT);
		appendConsole.add(builder.newLayout("PatternLayout").addAttribute("pattern",
				"%d{HH:mm:ss.SSS} RootLogger %-5level %logger{36} - %msg%n"));
		builder.add(appendConsole);

		AppenderComponentBuilder appendConsole2 = builder.newAppender("CONSOLE2", "CONSOLE").addAttribute("target",
				ConsoleAppender.Target.SYSTEM_OUT);
		appendConsole2.add(builder.newLayout("PatternLayout").addAttribute("pattern2",
				"%d{HH:mm:ss.SSS} %-5level %logger{36} - %msg%n"));
		builder.add(appendConsole2);

		AppenderComponentBuilder useractions = builder.newAppender("useractions", "CONSOLE").addAttribute("target",
				RollingFileAppender.createAppender(
						"logs/useractions.log", 
						"logs/$${date:yyyy-MM}/useractions-%d{dd}-%i.log",
						"True", "useractions", "True", "8192", "True", TriggeringPolicy.class, RolloverStrategy.class, Layout.class, Filter.class, "True", "False", "False", config));
		builder.add(useractions);

		builder.add(builder.newLogger("org.apache.logging.log4j", Level.DEBUG).add(builder.newAppenderRef("Stdout"))
				.addAttribute("additivity", false));
		builder.add(builder.newRootLogger(Level.ERROR).add(builder.newAppenderRef("Stdout")));
		return builder.build();
	}

	@Override
	public Configuration getConfiguration(ConfigurationSource source) {
		return getConfiguration(source.toString(), null);
	}

	@Override
	public Configuration getConfiguration(final String name, final URI configLocation) {
		ConfigurationBuilder<BuiltConfiguration> builder = newConfigurationBuilder();
		return createConfiguration(name, builder);
	}

	@Override
	protected String[] getSupportedTypes() {
		return new String[] { "*" };
	}
}
