package pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

@TableName("t_student")
public class TStudent {
	@TableId
	private String sid;

	private String password;

	private String sname;

	private String sex;

	private String scity;

	private String qx;

	private String classesId;

	private Integer absent;

	private TClasses classes;

	private List<TCourse> course;

	public List<TCourse> getCourse() {
		return course;
	}

	public void setCourse(List<TCourse> course) {
		this.course = course;
	}

	public TClasses getClasses() {
		return classes;
	}

	public void setClasses(TClasses classes) {
		this.classes = classes;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid == null ? null : sid.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname == null ? null : sname.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public String getScity() {
		return scity;
	}

	public void setScity(String scity) {
		this.scity = scity == null ? null : scity.trim();
	}

	public String getQx() {
		return qx;
	}

	public void setQx(String qx) {
		this.qx = qx == null ? null : qx.trim();
	}

	public String getClassesId() {
		return classesId;
	}

	public void setClassesId(String classesId) {
		this.classesId = classesId == null ? null : classesId.trim();
	}

	public Integer getAbsent() {
		return absent;
	}

	public void setAbsent(Integer absent) {
		this.absent = absent;
	}
}