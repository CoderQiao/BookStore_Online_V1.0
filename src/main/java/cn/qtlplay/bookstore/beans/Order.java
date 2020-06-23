package cn.qtlplay.bookstore.beans;/*
    @author 乔同良
    @date 2020/6/21 - 上午12:07
*/

public class Order {
    private int orderId;
    private int bookId;
    private String bookName;
    private double price;
    private int userId;
    private String loginName;
    private int bookNumber;
    private long priceTotal;

    public Order() {
        super();
    }

    public Order(int bookId, String bookName, int bookNumber,double price, long priceTotal) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookNumber = bookNumber;
        this.price = price;
        this.priceTotal = priceTotal;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", userId=" + userId +
                ", loginName='" + loginName + '\'' +
                ", bookNumber=" + bookNumber +
                ", priceTotal=" + priceTotal +
                '}';
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public long getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(long priceTotal) {
        this.priceTotal = priceTotal;
    }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderId != order.orderId) return false;
        if (bookId != order.bookId) return false;
        if (userId != order.userId) return false;
        if (bookNumber != order.bookNumber) return false;
        if (priceTotal != order.priceTotal) return false;
        if (bookName != null ? !bookName.equals(order.bookName) : order.bookName != null) return false;
        if (loginName != null ? !loginName.equals(order.loginName) : order.loginName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + bookId;
        result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + (loginName != null ? loginName.hashCode() : 0);
        result = 31 * result + bookNumber;
        result = 31 * result + (int) (priceTotal ^ (priceTotal >>> 32));
        return result;
    }
}
