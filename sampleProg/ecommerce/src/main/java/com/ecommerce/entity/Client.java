package com.ecommerce.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue
    @Column(name = "client_id", nullable = false)
    private Long clientID;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @Column(name = "description", length = 256, nullable = false)
    private String description;

    @Column(name = "contract_detail", length = 256, nullable = false)
    private String contractDetail;

    @Column(name = "url", length = 256)
    private String url;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Product> products;

    @Column(name = "remark", length = 100)
    private String remark;

}
