package org.se.lab;

import java.util.Objects;

public class TestParameters {
    private final int quantity;
    private final int articleNr;

    public TestParameters(int quantity, int articleNr) {
        this.quantity = quantity;
        this.articleNr= articleNr;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestParameters that = (TestParameters) o;
        return quantity == that.quantity &&
                articleNr == that.articleNr;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, articleNr);
    }

    public int getQuantity() {
        return quantity;
    }

    public int getArticleNr() {
        return articleNr;
    }
}
