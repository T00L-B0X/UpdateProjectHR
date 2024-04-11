package com.bswill.domain;

public class Criteria {

	private int page;
	private int pageSize;
	private int employee_id;
	private String search;
	private String keyword;
	private String sort;
	private String order;

	public Criteria() {
		this(1, 20);
	}

	public Criteria(int page, int pageSize) {
		this.page = page;
		this.pageSize = pageSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;

			return;
		}

		this.page = page;
	}

	public int getStartPage() {
		return (this.page - 1) * pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize <= 0) {
			this.pageSize = 10;

			return;
		}

		this.pageSize = pageSize;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", pageSize=" + pageSize + ", employee_id=" + employee_id + ", search="
				+ search + ", keyword=" + keyword + ", sort=" + sort + ", order=" + order + "]";
	}

}
