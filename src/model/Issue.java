package model;

public class Issue {
    private String IssueId;
    private String BorrowerId;
    private String Bookcode;
    private String IssueDate;
    private String DueDate;
    private int Quantity;

    @Override
    public String toString() {
        return "Issue{" +
                "IssueId='" + IssueId + '\'' +
                ", BorrowerId='" + BorrowerId + '\'' +
                ", Bookcode='" + Bookcode + '\'' +
                ", IssueDate='" + IssueDate + '\'' +
                ", DueDate='" + DueDate + '\'' +
                ", Quantity=" + Quantity +
                '}';
    }

    public String getIssueId() {
        return IssueId;
    }

    public void setIssueId(String issueId) {
        IssueId = issueId;
    }

    public String getBorrowerId() {
        return BorrowerId;
    }

    public void setBorrowerId(String borrowerId) {
        BorrowerId = borrowerId;
    }

    public String getBookcode() {
        return Bookcode;
    }

    public void setBookcode(String bookcode) {
        Bookcode = bookcode;
    }

    public String getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(String issueDate) {
        IssueDate = issueDate;
    }

    public String getDueDate() {
        return DueDate;
    }

    public void setDueDate(String dueDate) {
        DueDate = dueDate;
    }


    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getQuantity() {
        return Quantity;
    }
}