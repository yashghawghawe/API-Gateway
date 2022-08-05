/**
 * 
 */
package com.microservices.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author yash.ghawghawe
 *
 */
@Component
public class RouteConfiguration {

    @Bean
    public RouteLocator routeCOnfiguration(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/get").uri("http://httpbiob.org:80"))
                .route( p -> p.path("/currency-exchange/**")
                        .uri("lb://currency-exchange"))
                .route( p -> p.path("/currency-conversion/**")
                        .uri("lb://currency-conversion"))
                .build();
    }

}
