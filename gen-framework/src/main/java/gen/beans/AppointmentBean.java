package gen.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class AppointmentBean {
	 
	   public String id;
	   
	   public Integer status;
	   
	   @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	   public Date begintime;
	   
	   @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	   public Date endtime;
	   
	   public Date actualbegin;
	   
	   public Date actualend;
	   
	   public Date applytime;
	   
	   public Date audittime;
	   
	   public String auditmessage;
	   
	   public String paymentcard;
	   
	   public Integer samples;
	   
	   public String projectname;
	   
	   public Integer undergraduates;
	   
	   public Integer masters;
	   
	   public Integer doctors;
	   
	   public Integer teachers;
	   
	   public Integer others;
	   
	   public Integer advstudents;
	   
	   public String equipmentid;
	   
	   public String userid;
	   
	   public Integer apptype;
	   
	   public String samplename;
	   
	   public String projectmanager;
	   
	   public String deliverer;
	   
	   public String delPhone;
	   
	   public String delMobile;
	   
	   public String delFax;
	   
	   public String delEmail;
	   
	   public String department;
	   
	   public String depAddress;
	   
	   public Date arrivetime;
	   
	   public Long speedup;
	   
	   public String requirements;
	   
	   public String comRemark;
	   
	   public String originnumber;
	   
	   public String storagedays;
	   
	   public String shapenform;
	   
	   public String color;
	   
	   public String meltingpoint;
	   
	   public String boilingpoint;
	   
	   public String td;
	   
	   public Long poisonous;
	   
	   public String othercharacter;
	   
	   public String storagecondition;
	   
	   public Long keepindark;
	   
	   public String handling;
	   
	   public String projecttypecode;
	   
	   public String solvents;
	   
	   public String compositions;
	   
	   public String testingtype;
	   
	   public String testingmethod;
	   
	   public String operatorcard;
	   
	   public String userecoredid;
	   
	   public String useTypeCode;
	   
	   public String sampledesc;
	   
	   public String sampleid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getBegintime() {
		return begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Date getActualbegin() {
		return actualbegin;
	}

	public void setActualbegin(Date actualbegin) {
		this.actualbegin = actualbegin;
	}

	public Date getActualend() {
		return actualend;
	}

	public void setActualend(Date actualend) {
		this.actualend = actualend;
	}

	public Date getApplytime() {
		return applytime;
	}

	public void setApplytime(Date applytime) {
		this.applytime = applytime;
	}

	public Date getAudittime() {
		return audittime;
	}

	public void setAudittime(Date audittime) {
		this.audittime = audittime;
	}

	public String getAuditmessage() {
		return auditmessage;
	}

	public void setAuditmessage(String auditmessage) {
		this.auditmessage = auditmessage;
	}

	public String getPaymentcard() {
		return paymentcard;
	}

	public void setPaymentcard(String paymentcard) {
		this.paymentcard = paymentcard;
	}

	public Integer getSamples() {
		return samples;
	}

	public void setSamples(Integer samples) {
		this.samples = samples;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public Integer getUndergraduates() {
		return undergraduates;
	}

	public void setUndergraduates(Integer undergraduates) {
		this.undergraduates = undergraduates;
	}

	public Integer getMasters() {
		return masters;
	}

	public void setMasters(Integer masters) {
		this.masters = masters;
	}

	public Integer getDoctors() {
		return doctors;
	}

	public void setDoctors(Integer doctors) {
		this.doctors = doctors;
	}

	public Integer getTeachers() {
		return teachers;
	}

	public void setTeachers(Integer teachers) {
		this.teachers = teachers;
	}

	public Integer getOthers() {
		return others;
	}

	public void setOthers(Integer others) {
		this.others = others;
	}

	public Integer getAdvstudents() {
		return advstudents;
	}

	public void setAdvstudents(Integer advstudents) {
		this.advstudents = advstudents;
	}

	public String getEquipmentid() {
		return equipmentid;
	}

	public void setEquipmentid(String equipmentid) {
		this.equipmentid = equipmentid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Integer getApptype() {
		return apptype;
	}

	public void setApptype(Integer apptype) {
		this.apptype = apptype;
	}

	public String getSamplename() {
		return samplename;
	}

	public void setSamplename(String samplename) {
		this.samplename = samplename;
	}

	public String getProjectmanager() {
		return projectmanager;
	}

	public void setProjectmanager(String projectmanager) {
		this.projectmanager = projectmanager;
	}

	public String getDeliverer() {
		return deliverer;
	}

	public void setDeliverer(String deliverer) {
		this.deliverer = deliverer;
	}

	public String getDelPhone() {
		return delPhone;
	}

	public void setDelPhone(String delPhone) {
		this.delPhone = delPhone;
	}

	public String getDelMobile() {
		return delMobile;
	}

	public void setDelMobile(String delMobile) {
		this.delMobile = delMobile;
	}

	public String getDelFax() {
		return delFax;
	}

	public void setDelFax(String delFax) {
		this.delFax = delFax;
	}

	public String getDelEmail() {
		return delEmail;
	}

	public void setDelEmail(String delEmail) {
		this.delEmail = delEmail;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDepAddress() {
		return depAddress;
	}

	public void setDepAddress(String depAddress) {
		this.depAddress = depAddress;
	}

	public Date getArrivetime() {
		return arrivetime;
	}

	public void setArrivetime(Date arrivetime) {
		this.arrivetime = arrivetime;
	}

	public Long getSpeedup() {
		return speedup;
	}

	public void setSpeedup(Long speedup) {
		this.speedup = speedup;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public String getComRemark() {
		return comRemark;
	}

	public void setComRemark(String comRemark) {
		this.comRemark = comRemark;
	}

	public String getOriginnumber() {
		return originnumber;
	}

	public void setOriginnumber(String originnumber) {
		this.originnumber = originnumber;
	}

	public String getStoragedays() {
		return storagedays;
	}

	public void setStoragedays(String storagedays) {
		this.storagedays = storagedays;
	}

	public String getShapenform() {
		return shapenform;
	}

	public void setShapenform(String shapenform) {
		this.shapenform = shapenform;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMeltingpoint() {
		return meltingpoint;
	}

	public void setMeltingpoint(String meltingpoint) {
		this.meltingpoint = meltingpoint;
	}

	public String getBoilingpoint() {
		return boilingpoint;
	}

	public void setBoilingpoint(String boilingpoint) {
		this.boilingpoint = boilingpoint;
	}

	public String getTd() {
		return td;
	}

	public void setTd(String td) {
		this.td = td;
	}

	public Long getPoisonous() {
		return poisonous;
	}

	public void setPoisonous(Long poisonous) {
		this.poisonous = poisonous;
	}

	public String getOthercharacter() {
		return othercharacter;
	}

	public void setOthercharacter(String othercharacter) {
		this.othercharacter = othercharacter;
	}

	public String getStoragecondition() {
		return storagecondition;
	}

	public void setStoragecondition(String storagecondition) {
		this.storagecondition = storagecondition;
	}

	public Long getKeepindark() {
		return keepindark;
	}

	public void setKeepindark(Long keepindark) {
		this.keepindark = keepindark;
	}

	public String getHandling() {
		return handling;
	}

	public void setHandling(String handling) {
		this.handling = handling;
	}

	public String getProjecttypecode() {
		return projecttypecode;
	}

	public void setProjecttypecode(String projecttypecode) {
		this.projecttypecode = projecttypecode;
	}

	public String getSolvents() {
		return solvents;
	}

	public void setSolvents(String solvents) {
		this.solvents = solvents;
	}

	public String getCompositions() {
		return compositions;
	}

	public void setCompositions(String compositions) {
		this.compositions = compositions;
	}

	public String getTestingtype() {
		return testingtype;
	}

	public void setTestingtype(String testingtype) {
		this.testingtype = testingtype;
	}

	public String getTestingmethod() {
		return testingmethod;
	}

	public void setTestingmethod(String testingmethod) {
		this.testingmethod = testingmethod;
	}

	public String getOperatorcard() {
		return operatorcard;
	}

	public void setOperatorcard(String operatorcard) {
		this.operatorcard = operatorcard;
	}

	public String getUserecoredid() {
		return userecoredid;
	}

	public void setUserecoredid(String userecoredid) {
		this.userecoredid = userecoredid;
	}

	public String getUseTypeCode() {
		return useTypeCode;
	}

	public void setUseTypeCode(String useTypeCode) {
		this.useTypeCode = useTypeCode;
	}

	public String getSampledesc() {
		return sampledesc;
	}

	public void setSampledesc(String sampledesc) {
		this.sampledesc = sampledesc;
	}

	public String getSampleid() {
		return sampleid;
	}

	public void setSampleid(String sampleid) {
		this.sampleid = sampleid;
	}

	   
}
