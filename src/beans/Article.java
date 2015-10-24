package beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ARTICLES")
public class Article {
	private long id;
	private Journalist journalist;
	private Category category;
	private String title;
	private String alias;
	private String shortContent;
	private String content;
	private Date createDate;
	private Date modifyDate;

	public Article() {
	}

	public Article(Journalist journalist, Category category, String title, String alias, String shortContent,
			String content) {
		this.journalist = journalist;
		this.category = category;
		this.title = title;
		this.alias = alias;
		this.shortContent = shortContent;
		this.content = content;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "journalist_id", nullable = false)
	public Journalist getJournalist() {
		return journalist;
	}

	public void setJournalist(Journalist journalist) {
		this.journalist = journalist;
	}

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(nullable = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(nullable = false)
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Column(nullable = false)
	public String getShortContent() {
		return shortContent;
	}

	public void setShortContent(String shortContent) {
		this.shortContent = shortContent;
	}

	@Column(nullable = false)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

}
