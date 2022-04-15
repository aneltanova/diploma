package iitu.kz.diploma.Models;

public enum Role {
    Teacher("TEACHER"), Head("HEAD_OF_DEP"), Admin("ADMIN");

    public final String role;

    Role(String role){
        this.role = role;
    }
}
