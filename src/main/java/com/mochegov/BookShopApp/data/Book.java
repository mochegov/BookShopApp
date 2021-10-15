package com.mochegov.BookShopApp.data;

public class Book {
    private Integer id;
    private String author;
    private String title;
    private String priceold;
    private String price;

    private Integer discount;
    private Boolean bestseller;

    private Boolean recomended;
    private Boolean news;
    private Boolean popular;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPriceold() {
        return priceold;
    }

    public void setPriceold(String priceold) {
        this.priceold = priceold;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Boolean getRecomended() {
        return recomended;
    }

    public void setRecomended(Boolean recomended) {
        this.recomended = recomended;
    }

    public Boolean getNews() {
        return news;
    }

    public void setNews(Boolean news) {
        this.news = news;
    }

    public Boolean getPopular() {
        return popular;
    }

    public void setPopular(Boolean popular) {
        this.popular = popular;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Boolean getBestseller() {
        return bestseller;
    }

    public void setBestseller(Boolean bestseller) {
        this.bestseller = bestseller;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", priceold='" + priceold + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}