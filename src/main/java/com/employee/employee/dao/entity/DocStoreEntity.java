package com.employee.employee.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="doc_store")
public class DocStoreEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "table_name")
    private String tableName;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file")
    private byte[] file;

    @Column(name = "mime_type")
    private String mimeType;

    @Column(name = "extension")
    private String extension;

    @OneToOne(mappedBy = "docStore")
    private EmployeeEntity employee;
}
