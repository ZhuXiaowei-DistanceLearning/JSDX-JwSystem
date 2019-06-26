package vo;

import java.util.List;

public class PageResult<T> {
    private Long total;// 总条数
    private Long totalPage;// 总页数
    private List<T> rows;// 当前页数据

    public PageResult(Long total, Long totalPage, List<T> rows) {
        this.total = total;
        this.totalPage = totalPage;
        this.rows = rows;
    }

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageResult() {
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}