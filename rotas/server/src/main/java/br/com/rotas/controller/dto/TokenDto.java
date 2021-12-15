package br.com.rotas.controller.dto;

public class TokenDto {

    private String bearer;
    private String token;

    public TokenDto(String bearer, String token) {
        this.bearer = bearer;
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public String getToken() {
        return token;
    }

}
