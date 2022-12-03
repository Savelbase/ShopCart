package com.basenko.shoppingcart.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokensResponse {
    @Schema(example = "eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJybW5fbW9iaWxlX2F1dGgiLCJzdWIiOiJlZTYwNzE1OS0yMjg1LTRkMDctYTgx" +
            "Ny0zNTZlNGY4ZjU2ZmMiLCJpYXQiOjE2NTA3ODE3OTksImV4cCI6MTY1MDc4NTM5OSwiYXV0aG9yaXRpZXMiOlsiUkVHSVNUUkFUSU9" +
            "OIiwiUkVTSURFTlRfQ0xJRU5UX1JFR0lTVFJBVElPTiJdfQ.Z7IhAoC6sgdeIltWT-Tz4TW1KG6uP8OWgqfVJJGQ9mKI_mQSExTeYfN" +
            "hlStltfBS43awlBso5Qzp_bWcsdVgqw")
    private String accessToken;

    @Schema(example = "Bearer", description = "Always 'Bearer'")
    private String tokenType;

    @Schema(example = "1h", description = "Access token expiration time is 1 hours. BTW, refresh token for 8 hours")
    private Integer expirationTime;

    @Schema(example = "0d3a68a1-5919-4914-bc20-839fae2480ac")
    private String userId;
}
