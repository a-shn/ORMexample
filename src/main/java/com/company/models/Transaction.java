package com.company.models;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private Integer someValue;

    @Transient
    private Boolean isKazan;

    @PostLoad
    public void isKazan() {
        if (city.equals("Kazan")) {
            isKazan = true;
        }
    }
}
