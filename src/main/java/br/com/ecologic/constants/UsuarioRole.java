package br.com.ecologic.constants;

public enum UsuarioRole {
    ADMIN("Admin"),
    USER("User");

    private final String role;

    UsuarioRole(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
