package pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.text.SimpleDateFormat;
import java.util.Date;
@TableName("t_teacher")
public class TTeacher {
	@TableId
	private String tid;

	private String password;

	private String tname;

	private String tsex;

	private String tage;

	private String status = "0";

	private String collegeId;

	private String qx;

	private Date begintime;

	private Double salary;

	private TCollege college;

	public String getFormatDate() {
		if (begintime != null) {
			return new SimpleDateFormat("yyyy-MM-dd").format(begintime);
		} else {
			return "未提交生日";
		}
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid == null ? null : tid.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname == null ? null : tname.trim();
	}

	public String getTsex() {
		return tsex;
	}

	public void setTsex(String tsex) {
		this.tsex = tsex == null ? null : tsex.trim();
	}

	public String getTage() {
		return tage;
	}

	public void setTage(String tage) {
		this.tage = tage == null ? null : tage.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public String getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId == null ? null : collegeId.trim();
	}

	public String getQx() {
		return qx;
	}

	public void setQx(String qx) {
		this.qx = qx == null ? null : qx.trim();
	}

	public Date getBegintime() {
		return begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public TCollege getCollege() {
		return college;
	}

	public void setCollege(TCollege college) {
		this.college = college;
	}

}