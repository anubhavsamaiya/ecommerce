package com.ecommerce.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category_id", nullable = false)
    private Long categoryID;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @Column(name = "description", length = 256, nullable = false)
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;

    @Column(name = "remark", length = 100)
    private String remark;
}
