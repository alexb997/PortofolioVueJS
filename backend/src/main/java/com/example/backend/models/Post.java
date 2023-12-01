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
public class Post {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String description;
    private String type;
    private String reference;
    @ManyToOne(fetch=FetchType.LAZY)  
    private Project project;  
}
