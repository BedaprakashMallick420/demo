package com.example.demo.apiresponse;

import java.util.List;

import lombok.Data;

@Data
public class ApiResponse<T> {

    private boolean status;

    private String successMessage;

    private List<String> successMessageList;

    private String errorMessage;

    private List<String> errorMessageList;

    private T data;

    public static <T> ApiResponse<T> successResponse(String message, T data) {

        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(true);
        apiResponse.setSuccessMessage(message);
        apiResponse.setData(data);

        return apiResponse;
    }

    public static <T> ApiResponse<T> multiSuccessResponse(List<String> messageList, T data) {

        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(true);
        apiResponse.setSuccessMessageList(messageList);
        apiResponse.setData(data);

        return apiResponse;
    }

    public static <T> ApiResponse<T> errorResponse(String message) {

        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(false);
        apiResponse.setErrorMessage(message);

        return apiResponse;
    }

    public static <T> ApiResponse<T> multiErrorResponse(List<String> messageList, T data) {

        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(false);
        apiResponse.setErrorMessageList(messageList);

        return apiResponse;
    }
}