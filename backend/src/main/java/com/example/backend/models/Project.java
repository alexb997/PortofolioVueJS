package com.example.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@Builder
@NoArgsConstructor 
@AllArgsConstructor
public class Project {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private String imgUrl;
    private String status;
            
}
