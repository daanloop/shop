package net.malta.beans;
import org.apache.struts.upload.FormFile;
import java.util.Date;
import org.apache.commons.lang.StringUtils;
public class PurchaseForm
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
{
private static final java.text.DateFormat simpleformat = new java.text.SimpleDateFormat("yyyy/MM/dd");private static final java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy/MM/dd hh:mm:ss");static { format.setLenient(true); }private Integer id;
public void setId(Integer id){
this.id = id;
}
public Integer getId(){
return this.id;
}
private Integer publicUser;
public void setPublicUser(Integer publicUser){
this.publicUser = publicUser;
}
public Integer getPublicUser(){
return this.publicUser;
}
private int total;
public void setTotal(int total){
this.total = total;
}
public int getTotal(){
return this.total;
}
private int carriage;
public void setCarriage(int carriage){
this.carriage = carriage;
}
public int getCarriage(){
return this.carriage;
}
private boolean temp;
public void setTemp(boolean temp){
this.temp = temp;
}
public boolean isTemp(){
return this.temp;
}
private int totalordernum;
public void setTotalordernum(int totalordernum){
this.totalordernum = totalordernum;
}
public int getTotalordernum(){
return this.totalordernum;
}
private boolean shipped;
public void setShipped(boolean shipped){
this.shipped = shipped;
}
public boolean isShipped(){
return this.shipped;
}
private boolean cancelled;
public void setCancelled(boolean cancelled){
this.cancelled = cancelled;
}
public boolean isCancelled(){
return this.cancelled;
}
private Date date;
public void setDate(Date date){
this.date = date;
}
public Date getDate(){
return this.date;
}
private boolean dateIsValid = false;
public void setDateIsValid(boolean dateIsValid){
this.dateIsValid = dateIsValid;
}
public boolean isDateIsValid(){
return this.dateIsValid;
}
private java.lang.String dateAsRawString ="";
public java.lang.String getDateAsString(){
    return (date== null) ? null : simpleformat.format(date);
}
public void setDateAsString(java.lang.String date){
	this.dateIsValid = true;
	this.dateAsRawString = date;
try{
		if(StringUtils.isNotBlank(date)){ simpleformat.parse(date);}
}catch (java.text.ParseException pe){
this.dateIsValid = false;
}
	if(dateIsValid){
		try {
			this.date = (org.apache.commons.lang.StringUtils.isBlank(date)) ? null : simpleformat.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
public void setDateAsRawString(java.lang.String date){
	this.dateAsRawString = date;
}

public String getDateAsRawString(){
return this.dateAsRawString;
}
private int dateyear = 0;
public void setDateyear(int dateyear){
    this.dateyear = dateyear;
}
public int getDateyear(){
   return this.dateyear;
}
private int datemonth = 0;
public void setDatemonth(int datemonth){
    this.datemonth = datemonth;
}
public int getDatemonth(){
   return this.datemonth;
}
private int dateday = 0;
public void setDateday(int dateday){
    this.dateday = dateday;
}
public int getDateday(){
   return this.dateday;
}
private int datehour = 0;
public void setDatehour(int datehour){
    this.datehour = datehour;
}
public int getDatehour(){
   return this.datehour;
}
private int dateminute = 0;
public void setDateminute(int dateminute){
    this.dateminute = dateminute;
}
public int getDateminute(){
   return this.dateminute;
}
private int datesecound = 0;
public void setDatesecound(int datesecound){
    this.datesecound = datesecound;
}
public int getDatesecound(){
   return this.datesecound;
}
private boolean datechooser = false;
public void setDatechooser(boolean datechooser){
    this.datechooser = datechooser;
if(this.datechooser){
try{
   Date date = format.parse(dateyear + "/" + datemonth + "/" + dateday + " " + datehour+ ":" + dateminute + ":" + datesecound);   this.date = date;
}catch (java.text.ParseException pe){
		pe.printStackTrace();
}
}}
public boolean isDatechooser(){
   return this.datechooser;
}
private Integer paymentMethod;
public void setPaymentMethod(Integer paymentMethod){
this.paymentMethod = paymentMethod;
}
public Integer getPaymentMethod(){
return this.paymentMethod;
}
private boolean removed;
public void setRemoved(boolean removed){
this.removed = removed;
}
public boolean isRemoved(){
return this.removed;
}
FormFile[] formFiles = new FormFile[10];
public void setFormFiles(FormFile[] formFiles){
this.formFiles = formFiles;
}
public FormFile[] getFormFiles(){
return this.formFiles;
}
public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request){	temp =false;
	shipped =false;
	cancelled =false;
	removed =false;
}
}
