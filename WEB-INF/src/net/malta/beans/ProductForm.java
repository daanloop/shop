package net.malta.beans;
import org.apache.struts.upload.FormFile;
import java.util.Date;
import org.apache.commons.lang.StringUtils;
public class ProductForm
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
{
private static final java.text.DateFormat simpleformat = new java.text.SimpleDateFormat("yyyy/MM/dd");private static final java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy/MM/dd hh:mm:ss");static { format.setLenient(true); }private String note;
public void setNote(String note){
this.note = note;
}
public String getNote(){
return this.note;
}
private Integer id;
public void setId(Integer id){
this.id = id;
}
public Integer getId(){
return this.id;
}
private boolean removed;
public void setRemoved(boolean removed){
this.removed = removed;
}
public boolean isRemoved(){
return this.removed;
}
private String no;
public void setNo(String no){
this.no = no;
}
public String getNo(){
return this.no;
}
private Integer category;
public void setCategory(Integer category){
this.category = category;
}
public Integer getCategory(){
return this.category;
}
private int pricewithtax;
public void setPricewithtax(int pricewithtax){
this.pricewithtax = pricewithtax;
}
public int getPricewithtax(){
return this.pricewithtax;
}
private String material;
public void setMaterial(String material){
this.material = material;
}
public String getMaterial(){
return this.material;
}
private String catchcopy;
public void setCatchcopy(String catchcopy){
this.catchcopy = catchcopy;
}
public String getCatchcopy(){
return this.catchcopy;
}
private int stocknum;
public void setStocknum(int stocknum){
this.stocknum = stocknum;
}
public int getStocknum(){
return this.stocknum;
}
private boolean pub;
public void setPub(boolean pub){
this.pub = pub;
}
public boolean isPub(){
return this.pub;
}
private Integer thumnail;
public void setThumnail(Integer thumnail){
this.thumnail = thumnail;
}
public Integer getThumnail(){
return this.thumnail;
}
private Integer slideshow;
public void setSlideshow(Integer slideshow){
this.slideshow = slideshow;
}
public Integer getSlideshow(){
return this.slideshow;
}
private String name;
public void setName(String name){
this.name = name;
}
public String getName(){
return this.name;
}
private String size;
public void setSize(String size){
this.size = size;
}
public String getSize(){
return this.size;
}
private String description;
public void setDescription(String description){
this.description = description;
}
public String getDescription(){
return this.description;
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
private String mainitemname;
public void setMainitemname(String mainitemname){
this.mainitemname = mainitemname;
}
public String getMainitemname(){
return this.mainitemname;
}
private String english;
public void setEnglish(String english){
this.english = english;
}
public String getEnglish(){
return this.english;
}
FormFile[] formFiles = new FormFile[10];
public void setFormFiles(FormFile[] formFiles){
this.formFiles = formFiles;
}
public FormFile[] getFormFiles(){
return this.formFiles;
}
public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request){	removed =false;
	pub =false;
}
}
