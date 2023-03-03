package com.graphqljava.tutorial.bookDetails.config;

import graphql.language.StringValue;
import graphql.scalars.ExtendedScalars;
import graphql.schema.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import java.time.format.DateTimeParseException;
import java.util.UUID;

/**
 * @author nevinsunny
 * date 27/02/23
 * time 3:25 PM
 */
@Configuration
public class GraphQLConfig {



    @Bean
    RuntimeWiringConfigurer configurer() {
        return (builder) -> builder.scalar(uuidScalar());
    }

    @Bean
    public GraphQLScalarType uuidScalar() {
        return GraphQLScalarType.newScalar()
                .name("UUID")
                .description("UUID of documents ")
                .coercing(new Coercing<UUID, String>() {
                    @Override
                    public String serialize(final Object uuidFetcherResult) {
                        if (uuidFetcherResult instanceof UUID) {
                            return uuidFetcherResult.toString();
                        } else {
                            throw new CoercingSerializeException("Expected a UUID object.");
                        }
                    }

                    @Override
                    public UUID parseValue(final Object input) {
                        try {
                            if (input instanceof String) {
                                return UUID.fromString((String) input);
                            } else {
                                throw new CoercingParseValueException("Expected a String");
                            }
                        } catch (DateTimeParseException e) {
                            throw new CoercingParseValueException(String.format("Not a valid date: '%s'.", input), e
                            );
                        }
                    }

                    @Override
                    public UUID parseLiteral(final Object input) {
                        if (input instanceof StringValue) {
                            try {
                                return UUID.fromString((String) input);
                            } catch (DateTimeParseException e) {
                                throw new CoercingParseLiteralException(e);
                            }
                        } else {
                            throw new CoercingParseLiteralException("Expected a StringValue.");
                        }
                    }
                }).build();
    }
}
