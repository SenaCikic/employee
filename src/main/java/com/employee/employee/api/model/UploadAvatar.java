package com.employee.employee.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadAvatar implements Serializable {

    private Long id;

    private String fileName;

    private byte[] file;

    private String mimeType;

    private String extension;
}
