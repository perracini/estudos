package br.com.rafa.estudo2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.math.BigDecimal;
import br.com.rafa.estudo2.models.Category;

@Entity
public class Product
{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private String description;
   private BigDecimal price;
   @ManyToOne
   private Category category;

   public Long getId()
   {
      return this.id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public String getName()
   {
      return this.name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public String getDescription()
   {
      return this.description;
   }

   public void setDescription(String description)
   {
      this.description = description;
   }

   public BigDecimal getPrice()
   {
      return this.price;
   }

   public void setPrice(BigDecimal price)
   {
      this.price = price;
   }

   public Category getCategory()
   {
      return this.category;
   }

   public void setCategory(Category category)
   {
      this.category = category;
   }
}
