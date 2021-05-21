package igraciarena.poc.mscustomers.adapters.output.dbentities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = "regions")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(unique = true)
    private String email;

    private int numberInvoices = 0;

    @ManyToOne(optional = false,
            fetch = FetchType.LAZY)
    @JoinColumn(nullable = false,
            name = "region_id")
    private Region region;

}