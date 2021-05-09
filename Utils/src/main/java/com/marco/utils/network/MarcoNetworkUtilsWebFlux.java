package com.marco.utils.network;

import java.net.URL;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.util.UriBuilder;

public class MarcoNetworkUtilsWebFlux implements MarcoNetworkUtils {

    private WebClient.Builder wcb;

    public MarcoNetworkUtilsWebFlux(WebClient.Builder wcb) {
        this.wcb = wcb;
    }

    @Override
    public ClientResponse performGetRequest(URL url, Optional<Map<String, String>> headers,
            Optional<Map<String, String>> queryParameters) {
        return performRequest(HttpMethod.GET, url, headers, queryParameters, MediaType.APPLICATION_JSON,
                Optional.ofNullable(null));
    }

    @Override
    public ClientResponse performPostRequest(URL url, Optional<Map<String, String>> headers, Optional<Object> body) {
        return performRequest(HttpMethod.POST, url, headers, Optional.ofNullable(null), MediaType.APPLICATION_JSON,
                body);
    }

    @Override
    public ClientResponse performPutRequest(URL url, Optional<Map<String, String>> headers, Optional<Object> body) {
        return performRequest(HttpMethod.PUT, url, headers, Optional.ofNullable(null), MediaType.APPLICATION_JSON,
                body);
    }

    @Override
    public ClientResponse performDeleteRequest(URL url, Optional<Map<String, String>> headers, Optional<Object> body) {
        return performRequest(HttpMethod.DELETE, url, headers, Optional.ofNullable(null), MediaType.APPLICATION_JSON,
                body);
    }

    @Override
    public ClientResponse performRequest(HttpMethod method, URL url, Optional<Map<String, String>> headers,
            Optional<Map<String, String>> queryParameters, MediaType contentType, Optional<Object> body) {
        /*
         * Create the request and adds query parameters if provided
         */
        // @formatter:off
        RequestBodySpec rbs = wcb.build().method(method).uri(uriBuilder -> {
            UriBuilder ub = uriBuilder
                    .scheme(url.getProtocol())
                    .host(url.getHost())
                    .port(url.getPort())
                    .path(url.getPath());
            if (queryParameters.isPresent()) {
                for (Map.Entry<String, String> entry : queryParameters.get().entrySet()) {
                    ub = ub.queryParam(entry.getKey(), entry.getValue());
                }
            }
            return ub.build();

        }).contentType(contentType);
        // @formatter:on

        /*
         * Add HTTP headers if provided
         */
        if (headers.isPresent()) {
            for (Map.Entry<String, String> entry : headers.get().entrySet()) {
                rbs = rbs.header(entry.getKey(), entry.getValue());
            }
        }

        /*
         * Perform the call
         */
        ClientResponse resp = null;
        if (body.isPresent()) {
            resp = rbs.bodyValue(body.get()).exchange().block();
            //resp = rbs.bodyValue(body.get()).exchangeToMono(Mono::just).block();
        } else {
            resp = rbs.exchange().block();
            //resp = rbs.exchangeToMono(Mono::just).block();
        }
        return resp;
    }

    @Override
    public <T> T getBodyFromResponse(ClientResponse response, Class<T> clazz) {
        return response.bodyToMono(clazz).block();
    }

}
