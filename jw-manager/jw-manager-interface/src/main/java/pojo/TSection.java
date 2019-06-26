package pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName
public class TSection {
	@TableId
	private String id;

	private String week;

	private String section;

	public String getSectionTime() {
		return week + " " + section;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week == null ? null : week.trim();
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section == null ? null : section.trim();
	}
}