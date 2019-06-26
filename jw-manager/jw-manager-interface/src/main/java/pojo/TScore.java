package pojo;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

@TableName("t_score")
public class TScore {
	private String peacetime;

	private String endtime;

	private String score;

	private String absent = "0";

	private TStudent students;

	private TCourse course;

	public String getAbsent() {
		return absent;
	}

	public void setAbsent(String absent) {
		this.absent = absent;
	}

	public String getPeacetime() {
		return peacetime;
	}

	public void setPeacetime(String peacetime) {
		this.peacetime = peacetime == null ? null : peacetime.trim();
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime == null ? null : endtime.trim();
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score == null ? null : score.trim();
	}

	public TStudent getStudents() {
		return students;
	}

	public void setStudents(TStudent students) {
		this.students = students;
	}

	public TCourse getCourse() {
		return course;
	}

	public void setCourse(TCourse course) {
		this.course = course;
	}

}