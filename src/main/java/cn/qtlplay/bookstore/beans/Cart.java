package cn.qtlplay.bookstore.beans;/*
    @author 乔同良
    @date 2020/6/21 - 上午12:07
*/

public class Cart {
    private int cartId;
    private int bookId;
    private String bookName;
    private int userId;
    private String loginName;
    private int bookNumber;
    private long priceTotal;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        if (cartId != cart.cartId) return false;
        if (bookId != cart.bookId) return false;
        if (userId != cart.userId) return false;
        if (bookNumber != cart.bookNumber) return false;
        if (priceTotal != cart.priceTotal) return false;
        if (bookName != null ? !bookName.equals(cart.bookName) : cart.bookName != null) return false;
        if (loginName != null ? !loginName.equals(cart.loginName) : cart.loginName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cartId;
        result = 31 * result + bookId;
        result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + (loginName != null ? loginName.hashCode() : 0);
        result = 31 * result + bookNumber;
        result = 31 * result + (int) (priceTotal ^ (priceTotal >>> 32));
        return result;
    }
}
