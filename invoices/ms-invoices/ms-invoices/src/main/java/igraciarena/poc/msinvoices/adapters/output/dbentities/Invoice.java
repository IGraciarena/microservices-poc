package igraciarena.poc.msinvoices.adapters.output.dbentities;

import igraciarena.poc.msinvoices.application.exceptions.NotFoundException;
import igraciarena.poc.msinvoices.domain.valueObjects.Price;
import igraciarena.poc.msinvoices.domain.valueObjects.Quantity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "invoices")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(exclude = "invoiceItems")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String numberInvoice;

    @Column
    private String description;

    @Column
    private Date createAt;

    @Column
    private Double total = 0.00;

    @OneToMany(fetch = FetchType.LAZY,
    cascade = CascadeType.ALL,
    mappedBy = "invoice")
    private List<InvoiceItem> invoiceItems = new ArrayList<>();

    @Column
    private Long customerId;

    private void setTotal(){

        Double total = 0.00;

        for(InvoiceItem invoiceItem : this.invoiceItems){
            total += invoiceItem.getSubTotal();
        }

        this.total = total;
    }

   @PrePersist
    void prePersist(){
        this.createAt = new Date();
    }

   public void addInvoiceItem(int quantity, Double price, Long productId){
       Quantity quantity1 = new Quantity(quantity);
       Price price1 = new Price(price);

       InvoiceItem invoiceItem = InvoiceItem.builder()
               .invoice(this)
               .productId(productId)
               .price(price1)
               .quantity(quantity1)
               .subTotal(quantity*price)
               .build();

       invoiceItems.add(invoiceItem);

       setTotal();
   }

   public void removeInvoiceItem(Long invoiceItemId){
        InvoiceItem invoiceItem = findInvoiceItemById(invoiceItemId);

        invoiceItems.remove(invoiceItem);
        setTotal();
   }

   public void clearInvoice(){
        invoiceItems.clear();
   }

   public void updateInvoiceItemQuantity(Long invoiceItemId, int quantity){

        InvoiceItem invoiceItem = findInvoiceItemById(invoiceItemId);

        Quantity quantity1 = new Quantity(quantity);

        InvoiceItem newInvoiceItem = InvoiceItem.builder()
                .invoice(this)
                .id(invoiceItemId)
                .productId(invoiceItem.getProductId())
                .price(Price.builder()
                    .price(invoiceItem.getPrice().getPrice()).build())
                .quantity(quantity1)
                .subTotal(quantity*invoiceItem.getPrice().getPrice())
                .build();

        invoiceItems.remove(invoiceItem);
        invoiceItems.add(newInvoiceItem);

        setTotal();
}

    public InvoiceItem findInvoiceItemById(Long invoiceItemId){
        Optional<InvoiceItem> invoiceItem = invoiceItems.stream().filter(invoiceItem1 -> invoiceItem1.getId() == invoiceItemId).findFirst();

        if (! invoiceItem.isPresent()){
            throw new NotFoundException(String.format("The invoice item with id %s is not in the invoice", invoiceItemId));
        }

        return invoiceItem.get();
    }

    public Invoice  updateInvoice(String numberInvoice, String description){
         Long id = this.id;
         Date createAt = this.createAt;
         Long customerId = this.customerId;

         List<InvoiceItem> invoiceItemList = new ArrayList<>();

         for(InvoiceItem invoiceItem : this.invoiceItems){

            Price price = Price.builder()
                    .price(invoiceItem.getPrice().getPrice())
                    .build();

            Quantity quantity = Quantity.builder()
                    .quantity(invoiceItem.getQuantity().getQuantity())
                    .build();

             InvoiceItem invoiceItem1 = new InvoiceItem(invoiceItem.getId(), quantity, price, invoiceItem.getProductId(),invoiceItem.getSubTotal(),  this);
             invoiceItemList.add(invoiceItem1);
         }

        Invoice newInvoice = new Invoice(id, numberInvoice, description, createAt, this.total, invoiceItemList, customerId);

        return newInvoice;
    }
}