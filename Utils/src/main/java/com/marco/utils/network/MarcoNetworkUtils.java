package com.marco.utils.network;

import java.net.URL;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;

public interface MarcoNetworkUtils {

    /**
     * It Performs a GET request
     * 
     * @param url
     * @param headers
     * @param queryParameters
     * @return
     */
    public ClientResponse performGetRequest(URL url, Optional<Map<String, String>> headers,
            Optional<Map<String, String>> queryParameters);

    /**
     * It performs a POST request with content type
     * {@link MediaType#APPLICATION_JSON}
     * 
     * @param url
     * @param headers
     * @param body
     * @return
     */
    public ClientResponse performPostRequest(URL url, Optional<Map<String, String>> headers, Optional<Object> body);

    /**
     * It performs a PUT request with content type
     * {@link MediaType#APPLICATION_JSON}
     * 
     * @param url
     * @param headers
     * @param body
     * @return
     */
    public ClientResponse performPutRequest(URL url, Optional<Map<String, String>> headers, Optional<Object> body);

    /**
     * It performs a DELETE request with content type
     * {@link MediaType#APPLICATION_JSON}
     * 
     * @param url
     * @param headers
     * @param body
     * @return
     */
    public ClientResponse performDeleteRequest(URL url, Optional<Map<String, String>> headers, Optional<Object> body);

    /**
     * It performs an HTTP request
     * 
     * @param method
     * @param url
     * @param headers
     * @param queryParameters
     * @param contentType
     * @param body
     * @return
     */
    public ClientResponse performRequest(HttpMethod method, URL url, Optional<Map<String, String>> headers,
            Optional<Map<String, String>> queryParameters, MediaType contentType, Optional<Object> body);

    /**
     * It extracts the body from the response
     * 
     * @param <T>
     * @param response
     * @param clazz
     * @return
     */
    public <T> T getBodyFromResponse(ClientResponse response, Class<T> clazz);
}
