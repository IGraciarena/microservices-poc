package igraciarena.poc.msinvoices.adapters.output.dbentities;

import igraciarena.poc.msinvoices.domain.valueObjects.Price;
import igraciarena.poc.msinvoices.domain.valueObjects.Quantity;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "invoice_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = "invoice")
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Embedded
    private Quantity quantity;

    @Column
    @Embedded
    private Price price;

    @Column
    private Long productId;

    @Column
    private Double subTotal = 0.00;

    @ManyToOne(fetch = FetchType.LAZY,
    cascade = CascadeType.PERSIST)
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

}
