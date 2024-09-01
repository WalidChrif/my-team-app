package com.docker_spring_cloud.api_gateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {

    @Bean
    public RouteLocator myRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p -> p.path("/api/v1/staff/**").uri("lb://staff-management"))
                .route(p -> p.path("/api/v1/teams/**").uri("lb://team-management"))
                .route(p -> p.path("/api/v1/players/**").uri("lb://player-management"))
                .route(p -> p.path("/eureka").filters(f -> f.setPath("/")).uri("http://eureka-server:8761"))
                .route(p -> p.path("/eureka/**").uri("http://eureka-server:8761"))
//                .route(p -> p.path("/eureka").filters(f -> f.setPath("/")).uri("http://localhost:8761"))
//                .route(p -> p.path("/eureka/**").uri("http://localhost:8761"))
                .build();
    }

}
