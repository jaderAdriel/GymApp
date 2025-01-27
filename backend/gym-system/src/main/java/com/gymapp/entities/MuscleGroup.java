package com.gymapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="tb_muscle_groups")
public class MuscleGroup {

    @Id
    @EqualsAndHashCode.Include
    private String name;

    private String description;
}
