package com.bit.backend.dtos;
// add role also
public record SignUpDto(String firstName, String lastName, String login, char[] password) {
}
