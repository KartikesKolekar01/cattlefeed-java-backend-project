package com.example.cattlefeed.dto;

public class ChangePasswordRequest{

    private String email;
    private String oldPassword;
    private String newPassword;

    // Default Constructor
    public ChangePasswordRequest() {
    }

    // Parameterized Constructor
    public ChangePasswordRequest(String email, String oldPassword, String newPassword) {
        this.email = email;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    // Getter and Setter for Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for Old Password
    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    // Getter and Setter for New Password
    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}